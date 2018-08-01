package com.hecklerreifcollab.testspringdataneo4j.series;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SeriesRepo extends Neo4jRepository<Series, Long> {
}
