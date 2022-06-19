package rsi.kryna.rsirabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "RSI")
public class Receiver {

    @RabbitHandler
    public void receive(String in) {
        System.out.println("Received '" + in + "'");
    }
}
