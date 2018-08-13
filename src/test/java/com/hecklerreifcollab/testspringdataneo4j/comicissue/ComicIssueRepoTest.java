package com.hecklerreifcollab.testspringdataneo4j.comicissue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ComicIssueRepoTest {

    @Autowired
    private ComicIssueRepo repo;

    @Test
    public void findAll() {
        repo.findAll().forEach(comicIssue -> System.out.println(comicIssue.getCharacters()));
    }

}