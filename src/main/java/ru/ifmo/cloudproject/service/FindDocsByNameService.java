package ru.ifmo.cloudproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ifmo.cloudproject.model.dto.DocIdDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindDocsByNameService {
    public List<DocIdDTO> findDocsByName(String name) {
        return null;
    }
}
