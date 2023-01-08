package ru.ifmo.cloudproject.model.entites;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Data
@RedisHash
@Builder
public class TagR {
    @Id
    private Long id;

    private String tag;
}
