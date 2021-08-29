package se.lexicon.laurita_charles.data;

import se.lexicon.laurita_charles.model.Person;

import java.util.Collection;

public interface People {

    //CRUD

    //Create
    boolean create(Person person);

    //Read's
    Collection<Person> findAll();

    Person findById(int personId);

    Collection<Person> findByName(String name);

    //Update
    Person update(Person person);

    //Delete
    boolean deleteById(int personId);
}
