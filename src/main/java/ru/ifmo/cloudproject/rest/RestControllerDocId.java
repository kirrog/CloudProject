package ru.ifmo.cloudproject.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cloudproject.model.dto.DocumentDTO;
import ru.ifmo.cloudproject.service.GetDocByIdService;

@RestController
@RequestMapping(path = "/docId")
@RequiredArgsConstructor
public class RestControllerDocId {
    private final GetDocByIdService getDocByIdService;
    @GetMapping
    public ResponseEntity<DocumentDTO> getDocByDocId(@RequestParam String docId) {
        return ResponseEntity.ok(getDocByIdService.getDocByDocId(docId));
    }
}
