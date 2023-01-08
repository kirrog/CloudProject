package ru.ifmo.cloudproject.model.entites;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.util.List;

@Data
@RedisHash
@Builder
public class TagsSetR {
    @Id
    private Long id;

    @Reference
    private List<TagR> tags;

    public void addTag(TagR tagR) {
        tags.add(tagR);
    }
}
