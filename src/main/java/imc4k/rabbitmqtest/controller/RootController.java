package imc4k.rabbitmqtest.controller;

import imc4k.rabbitmqtest.model.Person;
import imc4k.rabbitmqtest.service.PersonEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/root")
public class RootController {

    private final PersonEventProducer personEventProducer;

    @Autowired
    public RootController(PersonEventProducer personEventProducer) {
        this.personEventProducer = personEventProducer;
    }

    @PostMapping("/person")
    public @ResponseBody Person createPerson(@RequestBody Person person) {
        return personEventProducer.emitPerson(person);
    }
}
