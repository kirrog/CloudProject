package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.model.dto.UpdateDocRequestDTO;
import ru.ifmo.cloudproject.model.entites.DocumentM;
import ru.ifmo.cloudproject.repository.DocumentMRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateDocByIdService {
    private final DocumentMRepository documentMRepository;

    public TextResponseDTO updateDocById(UpdateDocRequestDTO updateDocRequestDTO) {
        Optional<DocumentM> optionalDocumentM = documentMRepository.findById(updateDocRequestDTO.getDocId());
        if (optionalDocumentM.isPresent()) {
            DocumentM documentM = optionalDocumentM.get();
            documentM.setDocument(updateDocRequestDTO.getText());
            documentMRepository.save(documentM);
            return TextResponseDTO.builder().code(0)
                    .text("Success: doc updated: docId: " + updateDocRequestDTO.getDocId()).build();
        }
        return TextResponseDTO.builder().code(-1)
                .text("Error: doc dn exists: docId: " + updateDocRequestDTO.getDocId()).build();
    }
}
