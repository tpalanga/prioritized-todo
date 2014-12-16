prioritized-todo
================

A simple app for managing a prioritized todo list. The application comes as a help tool for Alan Lakein's book
"How to get control of your time and your life".



tests and code coverage
=======================

The project Scala code has 100% test coverage. The JavaScript code is tested but not (yet) checked for coverage.

In order to run all the tests (JavaScript, unit, integration) and report the coverage, run the following command in the 
project root:
#> sbt clean coverage test

The html report should be generated in <project-root>/target/scala-2.11/scoverage-report/index.html
