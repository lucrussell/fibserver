README for fibserver
====================

See [fibserver/wiki](https://github.com/lucrussell/fibserver/wiki) for background on this project.

## Introduction
fibserver is a simple REST server for calculating fibonacci sequences. It also comes with a front end to demonstrate calling the REST server. In addition, there are monitoring and maintenance screens. At the time of writing, there is an instance deployed [here](http://fibserver.cfapps.io/#/).

## Support Documentation


### How To See Health Checks
You can see health checks for a running instance of the server.
![alt text](https://github.com/lucrussell/fibserver/blob/master/doc-images/health.png)
Go to [Health](http://fibserver.cfapps.io/#/health) to check the status of the database, email server and disk space.

### How To Check Metrics
Go to http://fibserver.cfapps.io/#/metrics
This will also show number of server errors, by http request
++ How to Obtain Timings for a Web Service call
(screenshot)
It may be useful to check the performance statistics for services in production. You can check service time in milliseconds for getFibonacciSequence on the Metrics page, Services statistics section.


## Developer Documentation
### Install Prerequisites
This was done on OSX 10.8.2.

Install Java from the Oracle website.
Install Maven
Install Git if not already installed
Install Node.js from https://nodejs.org/
Install Yeoman: sudo npm install -g yo
Install Bower: sudo npm install -g bower
Install Grunt: sudo npm install -g grunt-cli 
Install JHipster: sudo npm install -g generator-jhipster
Check out the project : git ...
`mvn spring-boot:run or run src/main/java/com.mycompany.myapp.Application.java` in your IDE
browse to http://localhost:8080

### How to Build the Application

### How To Run The Tests

### How To Deploy to Cloud Foundry
Create an account on Pivotal Cloud Foundry 
Install the cf CLI [here](http://docs.cloudfoundry.org/devguide/installcf/install-go-cli.html)
Run `yo jhipster:cloudfoundry`

## Troubleshooting
Ensure grunt tests can run by setting up PHANTOMJS_BIN env var
http://stackoverflow.com/questions/28336214/no-binary-for-phantomjs-browser-on-your-platform-please-set-phantomjs-bin-en
