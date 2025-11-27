package com.example.api.demo;

import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Repository
public class DayDAO {
    private static Days days;
    private Stock stock;
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://mysql-app/Stock_Events"; // Database name
    private static final String USER = "root"; // MySQL username
    private static final String PASS = "mypassword"; // MySQL password


    // Retrieve all days
    public Days getAllDays(String event_ID) {
      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
            // Register JDBC driver (not strictly necessary for modern JDBC drivers, but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver"); 

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected successfully!");

            String sql = "select * from events natural join day natural join tickers where events.Event_ID= ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, event_ID);
                rs = pstmt.executeQuery();
                // Process results
            

                /*
                // Create a statement
                stmt = conn.createStatement();

                // Execute a query
                String sql = "select * from events natural join day natural join tickers where events.Event_ID=\"" + event_ID + "\""; // Replace 'users' with your table name
                rs = stmt.executeQuery(sql);
                */

                Day[] stockDays = new Day[5];
                String ticker = "";
                String name = "";
                String timestamp = "";
                int i = 0;

                // Process the result set
                while (rs.next()) {
                    ticker = rs.getString("Ticker");
                    name = rs.getString("Ticker_Name");
                    timestamp = rs.getString("Timestamp");
                    stockDays[i++] = new Day(rs.getString("Day_Date"), rs.getDouble("Day_Open"), rs.getDouble("Day_Close"), rs.getDouble("Day_High"), rs.getDouble("Day_Low"), rs.getDouble("Day_Movement"), rs.getDouble("Day_Direction"), rs.getString("Day_State"), rs.getDouble("Day_PLowerWick"), rs.getDouble("Day_PBody"), rs.getDouble("Day_PUpperWick"));
                    
                }

                Event event = new Event(event_ID, ticker, timestamp);
                this.stock = new Stock(event, name, stockDays);
                days = new Days();
                days.getAppData()
                    .add(this.stock);
            }

        } catch (SQLException se) {
            // Handle JDBC errors
            se.printStackTrace();
        } catch (Exception e) {
            // Handle other errors
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
            } catch (SQLException se2) {
                // Ignore
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                // Ignore
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return days;
    }

    public void setEvent(Stock stock) {
        //System.out.print(stock.getEvent().getTimestamp());

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Register JDBC driver (not strictly necessary for modern JDBC drivers, but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver"); 

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected successfully!");


            // Execute a query
            String sql = "insert into `events`(Event_ID, Timestamp, Ticker_ID) select \"" + stock.getEvent().getEventID() + "\", \"" + stock.getEvent().getTimestamp() + "\", Ticker_ID from\r\n" + //
                               "tickers where Ticker=\"" + stock.getEvent().getTicker() + "\""; // Replace 'users' with your table name
            ps = conn.prepareStatement(sql);

            // Step 6: Process the results
            ps.execute();

            Day[] stockDays = stock.getDays();
            for(Day day: stockDays) {
                
                sql = "insert into `day`(Event_ID, Day_Date, Day_Open, Day_Close, Day_High, Day_Low, Day_Movement, Day_Direction, Day_State, Day_PLowerWick, Day_PBody, Day_PUpperWick) values ( \"" + stock.getEvent().getEventID() + "\", \"" + day.getDate() + "\", \r\n" + //
                                "\"" + day.getOpen() + "\", \"" + day.getClose() + "\", \"" + day.getHigh() + "\", \"" + day.getLow() + "\", \"" + day.getTotalMovement() + "\", \"" + day.getDirection() + "\", \"" + day.getState() + "\", \"" + day.getPLowerWick() + "\", \r\n" + //
                                "\"" + day.getPBody() + "\", \"" + day.getPUpperWick() + "\")"; // Replace 'users' with your table name
                ps = conn.prepareStatement(sql);

                // Step 6: Process the results
                ps.execute();
            }
            
        } catch (SQLException se) {
            // Handle JDBC errors
            se.printStackTrace();
        } catch (Exception e) {
            // Handle other errors
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (ps != null) ps.close();
            } catch (SQLException se2) {
                // Ignore
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
