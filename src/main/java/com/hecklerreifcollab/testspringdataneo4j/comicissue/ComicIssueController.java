package com.hecklerreifcollab.testspringdataneo4j.comicissue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping("/comicissues")
public class ComicIssueController {
    private final ComicIssueRepo repo;

    public ComicIssueController(ComicIssueRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    String getIssuesPage(Model model) {
        model.addAttribute("ComicIssues", repo.findAll());
        return "comicissues";
    }

    @GetMapping("/json")
    @ResponseBody
    Iterable<ComicIssue> getAllComicIssues() {
        return repo.findAll();
    }

    @GetMapping("/characters")
    @ResponseBody
    public Collection<ComicIssue> graph(@RequestParam(value = "limit",required = false) Integer limit) {
        return repo.graph(limit == null ? 100 : limit);
    }
}
