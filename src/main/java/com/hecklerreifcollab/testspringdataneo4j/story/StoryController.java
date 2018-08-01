package com.hecklerreifcollab.testspringdataneo4j.story;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stories")
public class StoryController {
    private final StoryRepo repo;

    public StoryController(StoryRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Story> findAllStories() {
        return repo.findAll();
    }
}
