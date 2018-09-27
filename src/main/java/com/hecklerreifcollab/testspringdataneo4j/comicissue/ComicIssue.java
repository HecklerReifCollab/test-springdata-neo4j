package com.hecklerreifcollab.testspringdataneo4j.comicissue;

import com.hecklerreifcollab.testspringdataneo4j.creator.Creator;
import com.hecklerreifcollab.testspringdataneo4j.event.Event;
import com.hecklerreifcollab.testspringdataneo4j.series.Series;
import com.hecklerreifcollab.testspringdataneo4j.story.Story;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import com.hecklerreifcollab.testspringdataneo4j.character.Character;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@NodeEntity
public class ComicIssue {
    @Id
    @GeneratedValue
    private Long neoId;
    @NonNull
    private Long id;
    @NonNull
    private Integer pageCount;
    @NonNull
    private Double issueNumber;
    @NonNull
    private String name, thumbnail, resourceURI;

    @Relationship(type = "INCLUDES")
    private List<Character> characters = new ArrayList<>();

    @Relationship(type = "CREATED_BY")
    private List<Creator> creators = new ArrayList<>();

    @Relationship(type = "PART_OF")
    private List<Event> events = new ArrayList<>();

    @Relationship(type = "BELONGS_TO")
    private List<Series> series = new ArrayList<>();

    @Relationship(type = "MADE_OF")
    private List<Story> stories = new ArrayList<>();

    public List<Character> getCharacters() {
        return characters;
    }

    public List<Creator> getCreators() { return creators; }

    public List<Event> getEvents() { return events; }

    public List<Series> getSeries() { return series; }

    public List<Story> getStories() { return stories; }
}
