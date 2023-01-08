package ru.ifmo.cloudproject.model.entites;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Data
@RedisHash
@Builder
public class SerpR {
    @Id
    private String id;

    @Reference
    private List<DocR> docIds;

    public void addDoc(DocR docR) {
        docIds.add(docR);
    }
}
