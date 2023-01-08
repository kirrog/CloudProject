package ru.ifmo.cloudproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.DocR;

@Repository
public interface DocRRepository extends CrudRepository<DocR, String> {

}
