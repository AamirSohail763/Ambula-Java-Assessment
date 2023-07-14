# Ambula-Java-Assessment (User Location Application)
* A SpringBoot project which provides REST API for an Online Food Delivery application. This API performs all the fundamental CRUD operations of a User Location Application with separate access for Admin and Reader.

  ## Tech Stack

* Java
* Spring Framework
* Spring Data JPA
* Maven
* HSQL
* Postman

  ## Modules

* CRUD access for ADMIN
* GET access for READER

  ## REST API Endpoints
  `https:///localhost:8080/userLocation/create_data`
  `https:///localhost:8080/userLocation/update_data`
  `https:///localhost:8080/userLocation/get_users/N`

  ## Sample Request Body for POST request

```
{
    "userId": 1,
    "name": "Aamir",
    "type": "ADMIN",
    "latitude": 144,
    "longitude":-235 
}
```
