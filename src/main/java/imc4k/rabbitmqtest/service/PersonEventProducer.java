package imc4k.rabbitmqtest.service;

import imc4k.rabbitmqtest.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonEventProducer {

    private StreamBridge streamBridge;

    public PersonEventProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public Person emitPerson(Person person) {
        log.info("send person info to message broker");
        streamBridge.send("emitPerson-out-0", person);
        return person;
    }
}
