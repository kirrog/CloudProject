package ru.ifmo.cloudproject.model.entites;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Data
@RedisHash
@Builder
public class RequestTagsR {
    @Id
    private Long id;
    @Reference
    private TagsSetR tagsSetR;
    @Reference
    private SerpR serpR;
}
