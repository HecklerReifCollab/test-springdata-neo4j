package com.hecklerreifcollab.testspringdataneo4j.character;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CharacterRepo extends Neo4jRepository<Character, Long> {
    @Query("match (c:Character) return c limit 10")
    Iterable<Character> findFirstById();
}
