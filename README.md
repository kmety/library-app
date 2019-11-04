# Library

## Table of Contents
* [Description](#description)
* [Introduction - the project's aim](#aim)
* [Technologies](#technologies)
* [Launch](#launch)

## <a name="description"></a>Description
Web application - simulator of book library. Unauthenticated users can look through list of books. Authenticated users with “USER” role can rent books and then return them back. Users with “ADMIN” role can create, update and delete books from list.

## <a name="aim"></a>Introduction - the project's aim

This is a training project. It's aim is to improve my programming skills, deepen knowledge in hibernate, spring-mvc and spring security technologies.

## <a name="technologies"></a>Technologies

* Java 11
* Maven 4.0
* Spring-mvc 4.3
* Hibernate 5.2
* Spring security 4.2
* MySQL database
* Hibernate-validator 6.0


## <a name="launch"></a>Launch

1. Clone or download the project from github.com
2. Add to IDE as maven project
3. Add tomcat configuration
4. Add artifact libraryapp:war exploded
5. Change db.properties file, set your login, password and database name
6. You may login in the app either via using precreated users or by creating new user. There are precreated users with:
* ADMIN role: "login: ivan, password: 1",
* USER role: "login: peter, password: 1",
* USER role: "login: nick, password: 1".
