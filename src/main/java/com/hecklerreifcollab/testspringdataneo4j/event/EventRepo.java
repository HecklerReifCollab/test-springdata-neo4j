package com.hecklerreifcollab.testspringdataneo4j.event;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EventRepo extends Neo4jRepository<Event, Long> {
}
