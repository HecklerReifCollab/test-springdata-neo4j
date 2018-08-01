package com.hecklerreifcollab.testspringdataneo4j.comicissue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comicissues")
public class ComicIssueController {
    private final ComicIssueRepo repo;

    public ComicIssueController(ComicIssueRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    Iterable<ComicIssue> getAllComicIssues() {
        return repo.findAll();
    }
}
