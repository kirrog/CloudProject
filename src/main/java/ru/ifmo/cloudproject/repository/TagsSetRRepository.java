package ru.ifmo.cloudproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.TagsSetR;

@Repository
public interface TagsSetRRepository extends CrudRepository<TagsSetR, String> {
}
