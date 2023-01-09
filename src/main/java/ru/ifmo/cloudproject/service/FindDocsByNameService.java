package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.DocIdDTO;
import ru.ifmo.cloudproject.model.entites.DocumentPG;
import ru.ifmo.cloudproject.repository.DocumentPGRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindDocsByNameService {
    private final DocumentPGRepository documentPGRepository;

    public List<DocIdDTO> findDocsByName(String name) {
        Optional<List<DocumentPG>> optionalDocumentPGS = documentPGRepository.findAllByFilename(name);
        return optionalDocumentPGS.map(documentPGS -> documentPGS.stream()
                .map(x -> DocIdDTO.builder().docId(Long.toHexString(x.getId())).build())
                .collect(Collectors.toList())).orElseGet(List::of);
    }
}
