package rsi.kryna.rsirabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "RSI")
@Profile("receiver")
public class Receiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println("Received '" + in + "'");
    }
}
