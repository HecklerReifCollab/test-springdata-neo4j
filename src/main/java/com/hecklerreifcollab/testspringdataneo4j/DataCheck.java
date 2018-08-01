package com.hecklerreifcollab.testspringdataneo4j;

import com.hecklerreifcollab.testspringdataneo4j.character.CharacterRepo;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class DataCheck {
    private final CharacterRepo repo;

    public DataCheck(CharacterRepo repo) {
        this.repo = repo;
    }

    @PostConstruct
    private void run() {
        repo.findFirstById().forEach(System.out::println);
    }
}
