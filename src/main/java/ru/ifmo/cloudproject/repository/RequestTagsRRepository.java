package ru.ifmo.cloudproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.RequestTagsR;

@Repository
public interface RequestTagsRRepository extends CrudRepository<RequestTagsR, String> {
}
