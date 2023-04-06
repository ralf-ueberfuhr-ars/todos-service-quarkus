package de.samples.quarkus.todos.persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
@Transactional
public class TodosRepository implements PanacheRepository<TodoEntity> {

}
