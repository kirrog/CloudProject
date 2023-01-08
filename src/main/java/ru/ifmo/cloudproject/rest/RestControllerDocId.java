package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.DocumentDTO;

@RestController
@RequestMapping(path = "/docId")
@RequiredArgsConstructor
public class RestControllerDocId {
    @GetMapping
    public ResponseEntity<DocumentDTO> getDocByDocId(@RequestParam String docId) {
        return ResponseEntity.ok(DocumentDTO.builder().data("text").build());
    }
}
