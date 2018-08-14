# GraphQL-Spring-boot Application: 

This Standalone Spring boot project demonstrates the crud operations on Tour services using GraphQL as API.


[![Build Status](https://travis-ci.org/ravisankarchinnam/spring-boot-graphQL.svg?branch=master)](https://travis-ci.org/ravisankarchinnam/spring-boot-graphQL)

## 1. In Memory H2 Database is used.
    So you can modify application.properies as per your loving database. 

## 2. Running as a Packaged Application (Following ways)
    Way-1 : java -jar target/spring-boot-graphql-0.0.1-SNAPSHOT.war

    Way-2 : mvn spring-boot:run (using maven)

## 3. Once the application is started you can access http://localhost:8080/graphiql
    ![GraphiQL](screen-shots/graphiql.PNG)

## Testing the Application using below Syntax:

### To retrieve AllTours:
    ```
    GraphiQL Syntax:
        query {
          allTours {
            name
            type
            description
            agency {
              name
              rating
            }
          }
        }
    
    JSON/postman syntax:
        {
            "query":"{allTours{name type description agency {name rating} }}"
        }
    ```
### To createTour:
    ```
    GraphiQL Syntax:
        mutation {
          createTour(name:"India", price:"34543.43",duration:"3", type:LUXURY,agency:1){
            name
          }
        }
    
    JSON/postman syntax:
        {
            "mutation":"{createTour(name:"India", price:"3454334.00",duration:"10", type:LUXURY,agency:1){name}}"
        }
    ```
### To retrieve a single Tour:
    ```
    GraphiQL Syntax:
        query {
          tour(id:1){
            name
            description
            type
            agency{
              name
              rating
            }
          }
        }
    
    JSON/postman syntax:
        {
            "query":"{tour(id:1){name description}}"
        }
    ```
## To delete a Tour:
    ```
    GraphiQL Syntax:
        mutation {
          deleteTour(id:10)
        }
    
    JSON/postman syntax:
        {
            "mutation":"{deleteTour(id:2)}"
        }
    ```    
## To retrieve allAgencies:
    ```
    GraphiQL Syntax:
        query{
          allAgencies{
            name
          }
        }
    
    JSON/postman syntax:
        {
            "query":"{allAgencies{name rating}}"
        }
    ```
### To retrieve a single Agency:
    ```
    GraphiQL Syntax:
        query {
          agency(id:1){
            name
            rating
          }
        }
    
    JSON/postman syntax:
        {
            "query":"{agency(id:1){name rating}}"
        }
    ```    
## To update Agency rating:
    ```
    GraphiQL Syntax:
        mutation{
          updateAgencyRating(id:1, rating:5){
            rating
            name
          }
        }
    
    JSON/postman syntax:
        {
            "mutation":"{updateAgencyRating(id:1, rating:5){name rating}}"
        }
    ```