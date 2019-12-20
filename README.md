# TrelloAPI Testing

Functional positive API testing for ***/cards, /lists, /boards*** and ***/members*** endpoints.
Security testing for API calls without authorization.

End-to-end scenarios of creation of a board with a card and a list and a board delete.

[Rest-Assured](http://rest-assured.io/) and [Cucumber](https://cucumber.io/) are used.

## Prerequisites

For run this project you need to download and setup [Java](https://java.com/en/download/) and [Maven](https://maven.apache.org/download.cgi)

## Running the tests

For run tests with default configuration, go to project directory and run command:
```
mvn clean test
```
In Test Runner Use TestNG, specifying class *runners.TestRunner* in TestNG run configurations.

## Reporting

After test running, run command

```
mvn allure:serve
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Oleksandra Sandul** - *Initial work* - [osandul](https://github.com/osandul)
