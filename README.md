README for fibserver
====================

See the [wiki](https://github.com/lucrussell/fibserver/wiki) for background on this project.

## Introduction
fibserver is a simple REST server implemented with [Spring](http://spring.io/guides/gs/rest-service/), for calculating fibonacci sequences. It also comes with an [AngularJS](http://angularjs.org) front end to demonstrate calling the REST server. It's all glued together with [JHipster](https://jhipster.github.io/tech_stack.html), which provides monitoring and maintenance screens and other features.

At the time of writing, there is an instance deployed [here](http://fibserver.cfapps.io/#/).

## Support Documentation
The front end for the application looks like this:
![alt text](https://github.com/lucrussell/fibserver/blob/master/doc-images/home.png)
Type a number between 0 and 200 in the input to print out a fibonacci sequence.

See it in action [here](http://fibserver.cfapps.io).
### How To See Health Checks
An authenticated user can see health checks for a running instance of the server.
![alt text](https://github.com/lucrussell/fibserver/blob/master/doc-images/health.png)
See the health checks [here](http://fibserver.cfapps.io/#/health).


### How To Check Metrics
An authenticated user can view metrics for a running instance of the server.
![alt text](https://github.com/lucrussell/fibserver/blob/master/doc-images/metrics.png)
View the Metrics screen [here](http://fibserver.cfapps.io/#/metrics).

This will also show number of server errors by http request.

### How to Obtain Timings for a Web Service Call
It may be useful to check the performance statistics for services in production. Authenticated users can check service time in milliseconds for `getFibonacciSequence` on the Metrics page, Services Statistics section.

![alt text](https://github.com/lucrussell/fibserver/blob/master/doc-images/statistics.png)
View the Metrics screen [here](http://fibserver.cfapps.io/#/metrics).

## Developer Documentation
### Install Prerequisites
These instructions apply to OSX 10.8.2.

1. Install Java from the Oracle website.
1. Install Maven
1. Install Git if not already installed
1. Install Node.js from https://nodejs.org/
1. Install Yeoman: `sudo npm install -g yo`
1. Install Bower: `sudo npm install -g bower`
1. Install Grunt: `sudo npm install -g grunt-cli`
1. Install JHipster: `sudo npm install -g generator-jhipster`
1. Check out the project : `git clone https://github.com/lucrussell/fibserver`
1. Run `mvn spring-boot:run` (or run src/main/java/com.mycompany.myapp.Application.java` in your IDE)
1. Browse to http://localhost:8080

### How to Build the Application

### Development Notes

I've picked out a few key parts of the application below.

* [FibonacciServiceTest.java](https://github.com/lucrussell/fibserver/blob/8b0619b9c004f48bd8171efae074186992621ebf/src/test/java/com/mycompany/myapp/service/FibonacciServiceTest.java): Unit test for the FibonacciService.
* [FibonacciService.java](https://github.com/lucrussell/fibserver/blob/master/src/main/java/com/mycompany/myapp/service/FibonacciService.java): This contains the business logic for the calculation. 
* [FibonacciResource](https://github.com/lucrussell/fibserver/blob/master/src/main/java/com/mycompany/myapp/web/rest/FibonacciResource.java): Exposes the service to POST requests.
* [main.controller.js](https://github.com/lucrussell/fibserver/blob/master/src/main/webapp/scripts/app/main/main.controller.js): AngularJS file for calling the REST service.

### How To Run The Tests
You can run `mvn:test` on the command line, or run all the tests under `src/main/test` in your IDE.


### How To Deploy to Cloud Foundry
1. Create an account on Pivotal Cloud Foundry 
1. Install the cf CLI [here](http://docs.cloudfoundry.org/devguide/installcf/install-go-cli.html)
1. Run `yo jhipster:cloudfoundry`

## Troubleshooting
Grunt tests might faile. Ensure they can run by setting up PHANTOMJS_BIN env var
http://stackoverflow.com/questions/28336214/no-binary-for-phantomjs-browser-on-your-platform-please-set-phantomjs-bin-en
