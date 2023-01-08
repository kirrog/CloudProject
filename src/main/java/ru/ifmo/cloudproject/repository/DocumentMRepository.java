package ru.ifmo.cloudproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ifmo.cloudproject.model.entites.DocumentM;

public interface DocumentMRepository extends MongoRepository<DocumentM, String> {
    long count();
}
