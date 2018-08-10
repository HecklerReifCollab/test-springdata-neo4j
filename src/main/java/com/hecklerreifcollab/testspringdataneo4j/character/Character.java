package com.hecklerreifcollab.testspringdataneo4j.character;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@NodeEntity
public class Character {
    @Id
    @GeneratedValue
    private Long neoId;
    @NonNull
    private Long id;
    @NonNull
    private String name, description, resourceURI, thumbnail;
}
