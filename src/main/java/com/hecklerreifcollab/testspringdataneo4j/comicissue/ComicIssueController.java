package com.hecklerreifcollab.testspringdataneo4j.comicissue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comicissues")
public class ComicIssueController {

    private final ComicIssueRepo repo;

    public ComicIssueController(ComicIssueRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/comicissue")
    @ResponseBody
    public ComicIssue findByName(@RequestParam String name) {
        return repo.findByName(name);
    }


    @GetMapping
    String getIssuesPage(Model model) {
        model.addAttribute("ComicIssues", repo.findAll());
        return "comicissues";
    }
}
