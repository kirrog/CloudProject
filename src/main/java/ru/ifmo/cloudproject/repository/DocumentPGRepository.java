package ru.ifmo.cloudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.DocumentPG;

import java.util.UUID;

@Repository
public interface DocumentPGRepository extends JpaRepository<DocumentPG, UUID> {
}
