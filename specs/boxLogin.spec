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