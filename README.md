#Reactive Programming Demo Using Spring WebFlux

##Overview
This Spring Boot application demonstrates reactive programming through the use of Spring WebFlux to transmit server-sent events to a subscriber.

##Running the Application

1. Build the application artifact by running the Gradle build process.


    `gradle build`
2. Execute the JAR file to start the application.



    `java -jar ReactiveDemo-0.0.1-SNAPSHOT.jar`

3. Navigate to the following web address to verify that the application has started.


    `http://localhost:8080`



## Sending Notifications Using WebFlux

1. Open two web browser windows. Navigate to the application in each window.
2. In the first browser window, click the View Notifications link.
3. On the View Notifications screen, select a user from the dropdown and click the View Notifications button.  You should observe a table with the message "No notifications have been received."
4. In the second browser window, click the Send Notification link.
5. On the Send Notification screen, select the same user as was selected in Step 3.  Enter a message in the Notification field.  Click the Send Notification button.
6. On the View Notifications screen, ensure that the message entered in Step 5 is displayed.
7. On the Send Notification screen, select a different user than was chosen in Step 3.  Enter a message in the Notification field.  Click the Send Notification button.
8. On the View Notifications screen, ensure that the messahe entered in Step 7 is **not** displayed.