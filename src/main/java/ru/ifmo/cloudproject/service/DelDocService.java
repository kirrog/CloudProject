package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.DelDocRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.model.entites.Docs2TagsPG;
import ru.ifmo.cloudproject.model.entites.DocumentM;
import ru.ifmo.cloudproject.model.entites.DocumentPG;
import ru.ifmo.cloudproject.repository.Docs2TagsPGRepository;
import ru.ifmo.cloudproject.repository.DocumentMRepository;
import ru.ifmo.cloudproject.repository.DocumentPGRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DelDocService {
    private final Docs2TagsPGRepository docs2TagsPGRepository;
    private final DocumentPGRepository documentPGRepository;
    private final DocumentMRepository documentMRepository;

    public TextResponseDTO delDocByDocId(DelDocRequestDTO delDocRequestDTO) {
        Optional<DocumentPG> optionalDocumentPG = documentPGRepository.findById(Long.decode(delDocRequestDTO.getDocId()));
        if (optionalDocumentPG.isPresent()) {
            DocumentPG documentPG = optionalDocumentPG.get();
            Optional<DocumentM> optionalDocumentM = documentMRepository.findById(delDocRequestDTO.getDocId());
            if (optionalDocumentM.isEmpty()) {
                return TextResponseDTO.builder()
                        .code(-1)
                        .text("Error: doc dn exists in mongodb: docId: " + delDocRequestDTO.getDocId())
                        .build();
            }
            Optional<List<Docs2TagsPG>> optionalDocs2TagsPGList = docs2TagsPGRepository.findByDocId(documentPG);
            int tagsCount = 0;
            if (optionalDocs2TagsPGList.isPresent()) {
                List<Docs2TagsPG> docs2TagsPGList = optionalDocs2TagsPGList.get();
                tagsCount = docs2TagsPGList.size();
                docs2TagsPGRepository.deleteAll(docs2TagsPGList);
            }
            documentMRepository.delete(optionalDocumentM.get());
            documentPGRepository.delete(documentPG);
            return TextResponseDTO.builder()
                    .code(0)
                    .text("Success: doc deleted: " + delDocRequestDTO.getDocId() + " num of tags: " + tagsCount).build();
        } else {
            return TextResponseDTO.builder()
                    .code(-1)
                    .text("Error: document dn exists: docId: " + delDocRequestDTO.getDocId()).build();
        }
    }
}
