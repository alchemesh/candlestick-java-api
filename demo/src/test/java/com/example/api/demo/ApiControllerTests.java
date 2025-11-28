package com.example.api.demo;


import org.junit.jupiter.api.Test;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



class ApiControllerTests {

	@Test
    void testAPI() {
        HttpClient client = HttpClient.newHttpClient(); // Create an HTTP client

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.example.com/api/test")) // Set the target URI
                .GET() // Specify the HTTP method (GET, POST, PUT, DELETE, etc.)
                .build(); // Build the request

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // Send the request and handle the response body as a String


        String expected = "Test Successful";
        String actual = response.body();
        assertEquals(expected, actual, "API call should be 'Test Succesful'");
    }

}