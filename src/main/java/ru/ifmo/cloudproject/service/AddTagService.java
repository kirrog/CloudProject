package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.AddTagRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.model.entites.Docs2TagsPG;
import ru.ifmo.cloudproject.model.entites.DocumentPG;
import ru.ifmo.cloudproject.model.entites.TagPG;
import ru.ifmo.cloudproject.repository.Docs2TagsPGRepository;
import ru.ifmo.cloudproject.repository.DocumentPGRepository;
import ru.ifmo.cloudproject.repository.TagsPGRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddTagService {
    private final DocumentPGRepository documentPGRepository;
    private final Docs2TagsPGRepository docs2TagsPGRepository;
    private final TagsPGRepository tagsPGRepository;

    public TextResponseDTO addTagToDoc(AddTagRequestDTO addTagRequestDTO) {
        long newId = (long) (Math.random() * Long.MAX_VALUE);
        Optional<DocumentPG> optionalDocumentPG = documentPGRepository.findById(Long.decode(addTagRequestDTO.getDocId()));
        if (optionalDocumentPG.isPresent()) {
            DocumentPG documentPG = optionalDocumentPG.get();
            Optional<List<TagPG>> optionalListOfTags = tagsPGRepository.findByText(addTagRequestDTO.getTagName());
            if (optionalListOfTags.isPresent()) {
                List<TagPG> listOfTags = optionalListOfTags.get();
                if (listOfTags.size() > 0) {
                    TagPG first = listOfTags.get(0);
                    Docs2TagsPG result = Docs2TagsPG.builder()
                            .id(newId)
                            .docId(documentPG)
                            .tagId(first).build();
                    docs2TagsPGRepository.save(result);
                    return TextResponseDTO.builder().code(0).
                            text("Success: pairId: " + Long.toHexString(newId)).build();
                }
            }
            TagPG newOne = TagPG.builder().id((long) (Math.random() * Long.MAX_VALUE))
                    .text(addTagRequestDTO.getTagName()).build();
            tagsPGRepository.save(newOne);
            Docs2TagsPG result = Docs2TagsPG.builder()
                    .id(newId)
                    .docId(documentPG)
                    .tagId(newOne).build();
            docs2TagsPGRepository.save(result);
            return TextResponseDTO.builder().code(0)
                    .text("Success: pairId: " + Long.toHexString(newId) + " new tag id: " + Long.toHexString(newOne.getId())).build();
        } else {
            return TextResponseDTO.builder().code(-1).
                    text("Document doesn't exists: docId: " + addTagRequestDTO.getDocId()).build();
        }
    }
}
