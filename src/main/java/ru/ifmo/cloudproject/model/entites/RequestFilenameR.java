package ru.ifmo.cloudproject.model.entites;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash
@Builder
public class RequestFilenameR {
    @Id
    private String id;
    private String filename;
    @Reference
    private SerpR serpR;
}
