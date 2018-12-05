Login Scenario
=====================
Created by Dell on 2/14/2018

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
Login into Box
----------------
tags: login

* I navigate to box app
* Then box "Login" page should display
* I login with following credentials
    |username                   |password    |
    |---------------------------|------------|
    |nancydhingra131@gmail.com  |nancy131    |
* Then box "Home" page should display
* When I click on logout
* Then box "Login" page should display

Second scenario
--------------
* I navigate to box app
* Then box "Login" page should display
* I login with following credentials
    |username             |password    |
    |---------------------|------------|
    |nancydhingra131@gmail.com  |nancy131    |
* Then box "Home" page should display
* Then create new Folder
* Then delete the new Folder
*  When I click on logout
* Then box "Login" page should display

Third scenario
--------------
* I navigate to box app
* Then box "Login" page should display
* I login with following credentials
    |username             |password    |
    |---------------------|------------|
    |nancydhingra131@gmail.com  |nancy131    |
* Then box "Home" page should display
* When user rename the folder from "serious123" to "TestRename"
* Then folder should be renamed to "TestRename"
* When user rename the folder from "TestRename" to "serious123"
* Then folder should be renamed to "serious123"
*  When I click on logout
* Then box "Login" page should display