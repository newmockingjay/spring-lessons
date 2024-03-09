package ru.spring.zayceva.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.spring.zayceva.dao.PersonDAO;
import ru.spring.zayceva.models.Person;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass); // тк для класса Person
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        // посмотреть есть ли человек с таким же email-ом в бд
//        if (personDAO.show(person.getEmail()) != null){
        if (personDAO.show(person.getEmail()).isPresent()){ // существует ли объект
            errors.rejectValue("email", "", "This email is already taken");
        }
    }


}
