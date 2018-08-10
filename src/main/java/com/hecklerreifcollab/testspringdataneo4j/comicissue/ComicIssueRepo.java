package com.hecklerreifcollab.testspringdataneo4j.comicissue;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Map;

public interface ComicIssueRepo extends Neo4jRepository<ComicIssue, Long> {

    @Query("MATCH (c:Character)<-[r:INCLUDES]-(i:ComicIssue) RETURN c,r,i LIMIT {limit}")
    Collection<ComicIssue> graph(@Param("limit") int limit);
}