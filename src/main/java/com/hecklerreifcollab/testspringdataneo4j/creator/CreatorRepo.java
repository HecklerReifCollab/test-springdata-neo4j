package com.hecklerreifcollab.testspringdataneo4j.creator;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CreatorRepo extends Neo4jRepository<Creator, Long> {
    @Query("match (cre:Creator) return cre limit 10")
    Iterable<Creator> findFirstById();
}
