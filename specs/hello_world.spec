Specification Heading
=====================

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, use

	gauge specs/hello_world.spec

* A context step which gets executed before every scenario

First scenario
--------------

tags: hello world, first test

* Say1 "hello" to "gauge"


Second scenario for the specification
-------------------------------------

This is the second scenario in this specification

* Say1 "hello again" to "gauge"
* Step1 that takes a table <table:D:\\java-workspace\\BoxGaugeProject\\user.csv>
