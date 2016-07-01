Camunda Spring Seed Project
====================

This project shows how to set up a simple Hiring app in Camunda with Spring Boot and the H2 SQL database.

Installation
============

Download Camunda Modeler: https://camunda.org/download/modeler/

The sample process file, showing a hiring situation, is in src/main/resources/bpmn/post_job.bpmn

Run gradle bootRun (or import as a Gradle project into your IDE and run the bootRun task) to start the server on localhost:8080.

App in action
=============

1. Go to http://localhost:8080 and  set up an admin login.
2. Log in. Click in the top-right and switch to the task view.
3. In the left column, add a filter named All. Without further configuration, this will let you see all tasks, even though they are not assigned to your group.
4. In the top of the screen, click Create Process and select Post Job.
5. Follow the tasks that appear for the various groups in the org (HR, Recruitment, Managers) to accept a job applicant or keep searching.

Viewing the process
===================

Start Camunda Modeler. Open the bpmn file listed above. Poke around and see how the forms get set up and linked together.

Viewing the code
================

There is not much code; all of the logic and validation is handled by the process engine. I put some sample code showing saving data to a database, but even that is trivial and quite frankly not needed for this project.

The communication layer of handing off tasks to other people via messaging is handled by the SimpleMessage class. All of the black email icons in the diagram reference it. The SimpleMessage just copies the entire process state from one process to the next.

TODOs
=====
- Show how to save H2 to a file
- Show how to integrate with a REST endpoint
- Show how to do custom HTML forms
- Set up a job portal page for people to view the jobs and apply for them outside of Camunda.
