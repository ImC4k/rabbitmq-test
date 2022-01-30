package imc4k.rabbitmqtest.service;

import imc4k.rabbitmqtest.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonService {
    public void printPerson(Person person) {
        log.info("person: {}", person);
    }
}
