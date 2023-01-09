package ru.ifmo.cloudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.Docs2TagsPG;
import ru.ifmo.cloudproject.model.entites.DocumentPG;
import ru.ifmo.cloudproject.model.entites.TagPG;

import java.util.List;
import java.util.Optional;

@Repository
public interface Docs2TagsPGRepository extends JpaRepository<Docs2TagsPG, Long> {

    Optional<List<Docs2TagsPG>> findByDocId(DocumentPG documentPG);

    Optional<List<Docs2TagsPG>> findByTagId(TagPG tagPG);
}
