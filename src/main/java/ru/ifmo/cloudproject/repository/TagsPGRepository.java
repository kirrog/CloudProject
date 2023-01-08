package ru.ifmo.cloudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.TagsPG;

import java.util.UUID;

@Repository
public interface TagsPGRepository extends JpaRepository<TagsPG, UUID> {
}
