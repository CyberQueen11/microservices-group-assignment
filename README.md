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


#### FrontEnd
In another terminal you should be standing under the frontend folder and run these commands in order.

    npm install
    npm run build
    npm run dev

And then go into this link: http://localhost:8084/ \
There is only data in the product page.\
It is possible to use all methods in the CRUD format\
create, read, update and delete.


