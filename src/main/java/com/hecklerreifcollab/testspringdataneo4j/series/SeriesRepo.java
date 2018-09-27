package com.hecklerreifcollab.testspringdataneo4j.series;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SeriesRepo extends Neo4jRepository<Series, Long> {
    @Query("match (s:Series) return s limit 10")
    Iterable<Series> findFirstById();
}
