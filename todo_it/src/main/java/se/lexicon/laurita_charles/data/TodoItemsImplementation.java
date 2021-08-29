package se.lexicon.laurita_charles.data;

import se.lexicon.laurita_charles.model.Person;
import se.lexicon.laurita_charles.model.Todo;

import java.util.Collection;

public class TodoItemsImplementation implements TodoItems{
    @Override
    public boolean create(Todo todo) {
        return false;
    }

    @Override
    public Collection<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int todoId) {
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean isDone) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int personId) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person assignee) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int todoId) {
        return false;
    }
}
