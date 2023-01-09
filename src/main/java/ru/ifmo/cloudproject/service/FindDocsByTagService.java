package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.DocIdDTO;
import ru.ifmo.cloudproject.model.entites.Docs2TagsPG;
import ru.ifmo.cloudproject.model.entites.TagPG;
import ru.ifmo.cloudproject.repository.Docs2TagsPGRepository;
import ru.ifmo.cloudproject.repository.TagsPGRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindDocsByTagService {
    private final Docs2TagsPGRepository docs2TagsPGRepository;
    private final TagsPGRepository tagsPGRepository;

    public List<DocIdDTO> findDocsByTag(String tag) {
        Optional<List<TagPG>> optionalTagPGList = tagsPGRepository.findByText(tag);
        if (optionalTagPGList.isPresent()) {
            List<TagPG> tagPGList = optionalTagPGList.get();
            if (tagPGList.size() > 0) {
                TagPG tagPG = tagPGList.get(0);
                Optional<List<Docs2TagsPG>> optionalDocs2TagsPGS = docs2TagsPGRepository.findByTagId(tagPG);
                if (optionalDocs2TagsPGS.isPresent()) {
                    return optionalDocs2TagsPGS.get().stream()
                            .map(x -> DocIdDTO.builder().docId(Long.toHexString(x.getDocId().getId())).build())
                            .collect(Collectors.toList());
                }
            }
        }
        return List.of();
    }
}
