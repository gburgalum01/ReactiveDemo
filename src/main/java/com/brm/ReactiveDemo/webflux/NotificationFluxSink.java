package com.brm.ReactiveDemo.webflux;

import com.brm.ReactiveDemo.pojo.Notification;
import org.springframework.stereotype.Component;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

/**
 * This class wraps a subscriber in order to send a notification event to that client.
 */
@Component
public class NotificationFluxSink implements Consumer<FluxSink<Notification>> {

    private FluxSink<Notification> fluxSink;

    @Override
    public void accept(FluxSink<Notification> fluxSink) {
        this.fluxSink = fluxSink;
    }

    /**
     * This method sends a notification event to the subscriber.
     *
     * @param notification the notification to be sent to the subscriber
     */
    public void publishNotification(Notification notification){
        this.fluxSink = this.fluxSink.next(notification);
    }
}
