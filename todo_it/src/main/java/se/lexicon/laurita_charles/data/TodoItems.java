package se.lexicon.laurita_charles.data;

import se.lexicon.laurita_charles.model.Person;
import se.lexicon.laurita_charles.model.Todo;

import java.util.Collection;

public interface TodoItems {


    //CRUD

    //Create
    boolean create(Todo todo);

    //Read's
    Collection<Todo> findAll();

    Todo findById(int todoId);

    Collection<Todo> findByDoneStatus(boolean isDone);

    Collection<Todo> findByAssignee(int personId);

    Collection<Todo> findByAssignee(Person assignee);

    Collection<Todo> findByUnassignedTodoItems();

    //Update
    Todo update(Todo todo);

    //Delete
    boolean deleteById(int todoId);
}
