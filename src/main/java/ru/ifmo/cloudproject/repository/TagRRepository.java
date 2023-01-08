package ru.ifmo.cloudproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.TagR;

@Repository
public interface TagRRepository extends CrudRepository<TagR, String> {
}
