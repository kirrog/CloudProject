package ru.ifmo.cloudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ifmo.cloudproject.model.entites.TagPG;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagsPGRepository extends JpaRepository<TagPG, Long> {
    Optional<List<TagPG>> findByText(String text);
}
