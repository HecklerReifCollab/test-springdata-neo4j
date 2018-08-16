package com.hecklerreifcollab.testspringdataneo4j.series;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SeriesController {
    private final SeriesRepo repo;

    public SeriesController(SeriesRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Series> findAllSeries() {
        return repo.findAll();
    }
}
