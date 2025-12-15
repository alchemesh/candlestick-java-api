# Candlestick Pattern - JAVA API

The Java API for the Candlestick Pattern application.

The API is essential for communication with the database. There are 2 endpoints for pushing data and retieving it. 

* /
    - Post endpoint for the event data
    - Saves data to MYSQL database
* /{event_ID}
    - Get endpoint for the event data
    - Retrieves event data from the MYSQL database


## How to use ##

Deploy the image using Docker, Kubernetes, or any other container orchestration service using the docker io image: sabatiel180/candlestick-java-api-app

### Environment variables ###

The docker images needs 2 environment variable to function
- MYSQL_USER
- MYSQL_PASS

These variables are used to connect to the MYSQL database

### Docker ###

#### Docker Build ####
The manual approach can be used by downloading the repository your local machine. Navigate to the folder and run:

docker build -t [your_image_name] .

#### Docker Run ####
Run the image using the environment variables for the MYSQL user and password.

docker run -itd --env=MYSQL_USER=[your_sql_user] --env=MYSQL_PASS=[your_sql_password] -p 8080:8080 --name [your_container_name] [your_image_name]

Where:
* your_sql_user = (User name for the MYSQL database)
* your_sql_password = (User password for the MYSQL database)
* -p 8080 = Open port for Java API for other applications
* your_container_name = (The name you want to issue to the running container)
* your_image_name = (The name you used if you built the image manually. Use sabatiel180/candlestick-java-api-app for easier deployment)


### Kubernetes ###
The Kubernetes files in this repo can be used as a template for deployment.

#### Deployment ####
The deployment.yaml file will deploy the java api as a replica set with a name and app labels as candlestick-java-api-app-deploy and candlestick-java-api-app respectfully. 

#### Service ####
The Java API replicaset is deployed as a LoadBalancer service. This can potentially allow for horizontal scaling for the api to balance the load should it ever be necessary. The service name, candlestick-java-api-service, is used by Python backend and NodeJS frontend for communication between pods. For more information about the Python backend or NodeJS frontend, please visit [Python Backend] (https://github.com/alchemesh/candlestick-backend) or [NodeJS Frontend] (https://github.com/alchemesh/candlestick-frontend) repo.