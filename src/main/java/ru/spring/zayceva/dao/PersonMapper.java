package ru.spring.zayceva.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.spring.zayceva.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

// как BeanPropertyRowMapper (в нем название полей как название колонок в бд)
// а тут можно сделать как угодно ручками
public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));

        return person;
    }
}
