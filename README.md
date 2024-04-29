# Coffee Microservices

This repository contains a collection of microservices for managing a coffee shop system.

## Installation

Before running the microservices, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 8 or later
- Maven
- MySQL Server

Clone this repository to your local machine:

```bash
git clone https://github.com/your-username/coffee-microservices.git
```

## Setup

### 1. Database Setup

Navigate to the coffee-inventory-service/src/main/resources directory.
Run the schema-inventory.sql script to create the database schema.
Run the data-inventory.sql script to populate the database with sample data.
Repeat the same steps for the coffee-order-service module using the respective SQL scripts.

### 2. Configuration Server Setup

Navigate to the coffee-config-server directory.
Open the application.properties file and configure the database connection properties.
Run the following command to start the configuration server:

```
mvn spring-boot:run
```

### 3. Eureka Server Setup

Navigate to the coffee-eureka-server directory.
Open the application.properties file and configure the server port if necessary.
Run the following command to start the Eureka server:
```
mvn spring-boot:run
```

### 4. Microservices Setup

For each microservice (config, inventory, order, gateway), follow these steps:

Navigate to the respective directory (e.g., coffee-inventory-service). 
Open the application.properties file and configure the database connection properties, Eureka server details, and server port if necessary. 
Run the following command to start the microservice:
```
mvn spring-boot:run
```
Once all microservices are up and running, you can access the services through the gateway:  

Gateway URL: http://localhost:8072  
Consult each microservice's API documentation for available endpoints and usage instructions.  

## Contributing

Pull requests and contributions are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

MIT

