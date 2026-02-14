I implemented the Order Management microservice using controller, service, and repositorylayers to keep the code organized and easy to maintain. Orders are stored in memory using a map, 
and DTOs are used to handle request and response data cleanly. I also added status validation and proper exception handling to ensure the API works reliably and follows the correct order flow.

The APIs can be tested using Postman with the following endpoints:
POST: http://localhost:8089/orders to create an order
GET:  http://localhost:8089/orders/{orderId} to fetch an order
PUT:  http://localhost:8089/orders/{orderId}/status to update status
GET:  http://localhost:8089/orders to fetch all orders.
