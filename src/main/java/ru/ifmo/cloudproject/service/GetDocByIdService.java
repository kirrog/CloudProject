package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.DocumentDTO;
import ru.ifmo.cloudproject.model.entites.DocumentM;
import ru.ifmo.cloudproject.repository.DocumentMRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetDocByIdService {
    private final DocumentMRepository documentMRepository;

    public DocumentDTO getDocByDocId(String docId) {
        Optional<DocumentM> optionalDocumentM = documentMRepository.findById(docId);
        if (optionalDocumentM.isPresent()) {
            return DocumentDTO.builder().data(optionalDocumentM.get().getDocument()).build();
        }
        return DocumentDTO.builder().data("").build();
    }
}
