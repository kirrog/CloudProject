package ru.ifmo.cloudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.Docs2TagsPG;

import java.util.UUID;

@Repository
public interface Docs2TagsPGRepository extends JpaRepository<Docs2TagsPG, UUID> {

}
