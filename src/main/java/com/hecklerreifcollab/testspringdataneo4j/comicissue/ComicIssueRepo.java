package com.hecklerreifcollab.testspringdataneo4j.comicissue;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ComicIssueRepo extends Neo4jRepository<ComicIssue, Long> {
}
