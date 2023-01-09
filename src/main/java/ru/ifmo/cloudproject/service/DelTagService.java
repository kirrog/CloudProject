package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.DelTagRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.model.entites.Docs2TagsPG;
import ru.ifmo.cloudproject.model.entites.TagPG;
import ru.ifmo.cloudproject.repository.Docs2TagsPGRepository;
import ru.ifmo.cloudproject.repository.TagsPGRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DelTagService {
    private final Docs2TagsPGRepository docs2TagsPGRepository;
    private final TagsPGRepository tagsPGRepository;

    public TextResponseDTO delTagByName(DelTagRequestDTO delTagRequestDTO) {
        Optional<List<TagPG>> optionalTagPGList = tagsPGRepository.findByText(delTagRequestDTO.getTagName());
        if (optionalTagPGList.isPresent()) {
            List<TagPG> tagPGS = optionalTagPGList.get();
            if (tagPGS.size() == 0){
                return TextResponseDTO.builder()
                        .code(-1)
                        .text("Error: tag dn exists: tagname: " + delTagRequestDTO.getTagName())
                        .build();
            }
            TagPG tagPG = tagPGS.get(0);
            Optional<List<Docs2TagsPG>> optionalDocs2TagsPGList = docs2TagsPGRepository.findByTagId(tagPG);
            int docsCount = 0;
            if (optionalDocs2TagsPGList.isPresent()) {
                List<Docs2TagsPG> docs2TagsPGList = optionalDocs2TagsPGList.get();
                docsCount = docs2TagsPGList.size();
                docs2TagsPGRepository.deleteAll(docs2TagsPGList);
            }
            tagsPGRepository.delete(tagPG);
            return TextResponseDTO.builder()
                    .code(0)
                    .text("Success: tag deleted: " + tagPG.getId() + " num of docs: " + docsCount).build();
        } else {
            return TextResponseDTO.builder()
                    .code(-1)
                    .text("Error: tag dn exists: tagname: " + delTagRequestDTO.getTagName()).build();
        }
    }
}
