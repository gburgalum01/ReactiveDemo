package com.brm.ReactiveDemo.mvc;

import com.brm.ReactiveDemo.pojo.Notification;
import com.brm.ReactiveDemo.webflux.NotificationFluxSink;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;

/**
 * This controller handles the requests for the reactive-driven functionality in the application.
 */
@Controller
public class ReactiveWebController {

    @Autowired
    private NotificationFluxSink fluxSink;

    /**
     * This method handles the request to send a notification event to a user.
     *
     * @param notificationDTO the object containing the notification data to be sent
     * @return the response containing the result of the action
     */
    @PostMapping(value = "/sendnotification", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendNotification(@RequestBody Notification notificationDTO) {

        try {
            //Publish the notification to the subscriber.
            fluxSink.publishNotification(new Notification(notificationDTO.getUser(), notificationDTO.getNotification()));

            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(
                    addToJSONObject("RESULT", "Success")), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method handles the request to view the notification events for a specified user.
     *
     * @param user the name of the user for which notification events are to be viewed
     * @return the response containing flux for the notification events
     */
    @GetMapping(path="/viewnotifications/{user}")
    public ResponseEntity<Flux<Notification>> viewNotifications(@PathVariable String user) {

        try {
            //Create the flux for the subscriber.
            Flux<Notification> flux = Flux.create(fluxSink);

            //Subscribe to the notification event stream.
            flux.subscribe(o -> {});

            return new ResponseEntity<Flux<Notification>>(flux.filter(m -> m.getUser().equalsIgnoreCase(user)), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This method creates an empty object that will be utilized to create a JSON document.
     *
     * @return an empty object that will be utilized to create a JSON document
     */
    public ObjectNode createJSONObject() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.createObjectNode();
    }

    /**
     * This method adds a field to an object that will be utilized to create a JSON document.
     *
     * @param fieldName the name of the field to be added
     * @param fieldValue the value of the field to be added
     * @return the object containing the name and value that will be utilized to create a JSON document
     */
    public ObjectNode addToJSONObject(String fieldName, Object fieldValue) {

        ObjectNode jsonObject = createJSONObject();
        jsonObject.putPOJO(fieldName, fieldValue);
        return jsonObject;
    }
}
