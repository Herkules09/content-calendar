package com.herkules09.contentcalendar.service;

import com.herkules09.contentcalendar.model.Content;
import com.herkules09.contentcalendar.model.Status;
import com.herkules09.contentcalendar.repository.ContentRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }


    public List<Content> findAll() {
       return contentRepository.findAll();
    }

    public Optional<Content> findById(Integer id) {
        return contentRepository.findById(id);
    }

    public void save(Content content) {
        contentRepository.save(content);
    }

    public void update(Content content){
        contentRepository.save(content);
    }

    public boolean existsById(Integer id) {
        return contentRepository.findById(id).isPresent();
    }

    public void delete(Integer id) {
       contentRepository.deleteById(id);
    }

    public List<Content> findAllByTitleContains(String keyword) {
      return contentRepository.findAllByTitleContains(keyword);
    }

    public List<Content>findByStatus( Status status){
        return contentRepository.listByStatus(status);
    }


    public void saveAll(List<Content> contents) {
        contentRepository.saveAll(contents);
    }
}
