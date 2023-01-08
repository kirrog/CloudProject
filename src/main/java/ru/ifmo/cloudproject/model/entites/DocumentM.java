package ru.ifmo.cloudproject.model.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document("documents")
public class DocumentM {
    @Id
    private String id;
    private String document;
}
