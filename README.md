# microservices-group-assignment
This project is for school purposes only and it includes the use of spring boot, JPA and microservices

## Product
First start up the service like this:\
In the terminal you should be under the product folder

    mvn package spring-boot:run

#### API endpoints
In bruno or insomnia\
get all products: GET http://localhost:8081/getAllProducts \
create new product: POST http://localhost:8081/insertOne \
create many products: POST http://localhost:8081/insertMany \
update product: UPDATE http://localhost:8081/update \
delete product: DELETE http://localhost:8081/delete 


Example for a json body request:\

    {
        "id": 3,
        "name": "Coco",
        "age": 1,
        "ethnicity": "Brazil",
        "weight": 10.23,
        "price": 18000.25
    }

## Purchase
Navigate to the purchase directory and run this command:
```
mvn clean spring-boot:run
```
This will start the microservice on http://localhost:8082

#### API endpoints:
get all purchases: GET http://localhost:8082/purchases \
post new purchase: POST http://localhost:8082/purchases/create-purchase \
update purchase: PUT http://localhost:8082/purchases/update-purchase \
delete purchase: DELETE http://localhost:8082/purchases/delete-purchase

When posting a new purchase, the body of the request should be in JSON format, like the example below:
```
{
    "productId": 1,  
    "ownerId": 2    
}
```

Owner
Navigate to the Owner directory and run command mvn clean spring-boot:run
You can then access it at the following end points:

Addresses
Get all addresses: GET http://localhost:8083/addresses
Create a new address: POST http://localhost:8083/addresses
Update an address: UPDATE http://localhost:8083/update-address
Delete an address: DELETE http://localhost:8083/delete-address


#### Owners
Get all owners: GET http://localhost:8083/owners
Create a new owner: POST http://localhost:8083/owners
Update an owner: UPDATE http://localhost:8083/update-address
Delete an owner: DELETE http://localhost:8083/delete-address

Example for a owner post request: 
```
curl -X POST http://localhost:8083/owners \
-H "Content-Type: application/json" \
-d '{
  "name": "Bob Odenkirk",
  "email": "bob@example.com",
  "address": {
    "id": 1,
    "street": "123 Main St",
    "city": "New York",
    "postalCode": "10001"
  }
}
```
If you are using HTTPie or Bruno, you can use the following JSON syntax to post those values.


## FrontEnd
In another terminal you should be standing under the frontend folder and run these commands in order.

    npm install
    npm run build
    npm run dev

And then go into this link: http://localhost:8084/ \
There is only data in the product page.\
It is possible to use all methods in the CRUD format\
create, read, update and delete.

