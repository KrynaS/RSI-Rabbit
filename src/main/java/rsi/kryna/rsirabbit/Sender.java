package rsi.kryna.rsirabbit;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Sender {

    private final AmqpAdmin amqpAdmin;

    private final AmqpTemplate amqpTemplate;

    private final Queue queue;

    public Sender(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
        this.queue = new Queue("RSI");
    }

    public void sendMessage() {
        String s = "Sender";
        Message m = new Message(s.getBytes(StandardCharsets.UTF_8));
        amqpTemplate.send(queue.getName(), m);
    }
}

