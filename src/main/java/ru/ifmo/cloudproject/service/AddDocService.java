package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.AddDocRequestDTO;
import ru.ifmo.cloudproject.model.dto.TextResponseDTO;
import ru.ifmo.cloudproject.model.entites.DocumentM;
import ru.ifmo.cloudproject.model.entites.DocumentPG;
import ru.ifmo.cloudproject.repository.DocumentMRepository;
import ru.ifmo.cloudproject.repository.DocumentPGRepository;

@Service
@RequiredArgsConstructor
public class AddDocService {
    private final DocumentPGRepository documentPGRepository;
    private final DocumentMRepository documentMRepository;

    public TextResponseDTO addDoc(AddDocRequestDTO addDocRequestDTO) {
        long newId = (long) (Math.random() * Long.MAX_VALUE);
        DocumentPG documentPG = DocumentPG.builder().id(newId).filename(addDocRequestDTO.getFilename()).build();
        DocumentM documentM = DocumentM.builder().id(Long.toHexString(newId)).document(addDocRequestDTO.getText()).build();
        documentMRepository.save(documentM);
        documentPGRepository.save(documentPG);
        return TextResponseDTO.builder().code(0).text("Success: docId: " + Long.toHexString(newId)).build();
    }

}
