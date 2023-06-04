package com.herkules09.contentcalendar.controller;

import com.herkules09.contentcalendar.model.Content;
import com.herkules09.contentcalendar.model.Status;
import com.herkules09.contentcalendar.service.ContentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {


    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }


    @GetMapping("")
    public List<Content> findAll(){
        return contentService.findAll();
    }


    @GetMapping("/{id}")
    public Content findById(@PathVariable("id")Integer id){
        return contentService.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        contentService.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Content content){
        if(!contentService.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
        }
        Content contentToUpdate = contentService.findById(id).get();
        if(content.getTitle()!=null)contentToUpdate.setTitle(content.getTitle());
        if(content.getDescription()!=null)contentToUpdate.setDescription(content.getDescription());
        if(content.getContentType()!=null)contentToUpdate.setContentType(content.getContentType());
        if(content.getStatus()!=null)contentToUpdate.setStatus(content.getStatus());
        if(content.getDateCreated()!=null)contentToUpdate.setDateCreated(content.getDateCreated());
        if(content.getUrl()!=null)contentToUpdate.setUrl(content.getUrl());
        contentToUpdate.setDateUpdated(LocalDateTime.now());
        contentService.update(contentToUpdate);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){
        if(!contentService.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
        }
        contentService.delete(id);
    }

    @GetMapping("filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return contentService.findAllByTitleContains(keyword);
    }

    @GetMapping("filter/status/{status}")
    public List<Content>findByStatus(@PathVariable Status status){
        return contentService.findByStatus(status);
    }
}
