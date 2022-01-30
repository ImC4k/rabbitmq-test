package imc4k.rabbitmqtest.service;

import imc4k.rabbitmqtest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class PersonEventConsumer {

    private final PersonService personService;

    @Autowired
    public PersonEventConsumer(PersonService personService) {
        this.personService = personService;
    }

    @Bean
    public Consumer<Person> receivePerson() {
        return personService::printPerson;
    }
}
