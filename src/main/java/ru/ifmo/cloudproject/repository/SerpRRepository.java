package ru.ifmo.cloudproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.SerpR;

@Repository
public interface SerpRRepository extends CrudRepository<SerpR, String> {
}
