# Marker 

API designed for sites of bulk items purchases with authentication and permissions in java with Spring


## data models

### Post

| title   | string    |
|---------|-----------|
| image   | File\blob |
| date    | date      |
| product | Product   |

### product

| title      | string         |
|------------|----------------|
| description | String        |
| quantities | list<quantity> |

### quantity
| price    | Int      |
|----------|----------|
| quantity | quantity |


### user 
| Username    | String    |
|-------------|-----------|
| Password    | String    |
| UserRole    | enum      |
| phoneNumber | String    |

## working endpoints

| Method | url                | description                              |
|---|--------------------|------------------------------------------|
| GET | /api/v1/posts      | lists all posts                          |
| GET | /api/v1/posts/{id} | find post by id                          |
| POST | /api/v1/posts      | insert a post in the database            |
| DELETE | /api/v1/posts/{id} | remove a post from the database          |
| GET | /api/v1/image/{id} | find a image by id                       |
| POST | /api/v1/image      | insert a image/png in the database       |  
| POST | /auth/login        | insert an existing user to login         |  
| POST | /auth/register     | insert a new user to add to the database |  

## runnig in your machine

- install [docker compose](https://docs.docker.com/compose/install/)
- ``` git clone https://github.com/Luiszf/marker/ ```
- ``` cd marker ```
- ``` docker-compose up ```
- default root url ```127.0.0.1:8079/```
- scripts to fill empty database in .utils(using curl)

