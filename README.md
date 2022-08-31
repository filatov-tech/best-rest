[![Codacy Badge](https://app.codacy.com/project/badge/Grade/49b615cd1ce5450ca69b231a682d83c7)](https://www.codacy.com/gh/filatov-tech/best-rest/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=filatov-tech/best-rest&amp;utm_campaign=Badge_Grade)
# best-rest
REST API restaurant selection service for dinner by voting

##  Technical requirement:
Design and implement a REST API using Hibernate/Spring/SpringMVC (Spring-Boot preferred!) **without frontend**.

The task is:

Build a voting system for deciding where to have lunch.

* 2 types of users: admin and regular users
* Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
* Menu changes each day (admins do the updates)
* Users can vote on which restaurant they want to have lunch at
* Only one vote counted per user
* If user votes again the same day:
  - If it is before 11:00 we assume that he changed his mind.
  - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides a new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and couple curl commands to test it (**better - link to Swagger**).

## Description
Each restaurant has its own list of available and unavailable dishes. The restaurant menu contains enabled ones, which all the users can see. When an administrator creates new dishes, they become available by default. If the dish is not needed, the administrator disables it by sending a PATCH request to URI of dish with parameter `enable=false`. The dish remains in the database and can be enabled at any time. This allows to update the restaurant menu by including and excluding dishes.

## API spec
The project is deployed on the personal server. You can use `filatov.tech` instead of `localhost:8080` to check documentation without running project on your machine.

Documentation: [Online](http://filatov.tech/best-rest/api/v1/swagger-ui/index.html#/ "Online") | [Local](http://localhost:8080/best-rest/api/v1/swagger-ui/index.html#/ "Local")

Credentials:
- **Admin** - admin@yandex.ru : password
- **User** - user@yandex.ru : password