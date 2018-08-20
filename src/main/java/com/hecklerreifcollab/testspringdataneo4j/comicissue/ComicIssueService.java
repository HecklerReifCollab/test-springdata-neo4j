package com.hecklerreifcollab.testspringdataneo4j.comicissue;

import com.hecklerreifcollab.testspringdataneo4j.character.Character;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ComicIssueService {
    private final ComicIssueRepo issueRepo;

    public ComicIssueService(ComicIssueRepo issueRepo) {
        this.issueRepo = issueRepo;
    }

    private Map<String, Object> toD3Format(Collection<ComicIssue> issues) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<ComicIssue> result = issues.iterator();
        while (result.hasNext()) {
            ComicIssue issue = result.next();
            nodes.add(map("name", issue.getName(), "label", "issue"));
            int target = i;
            i++;
            for (Character character : issue.getCharacters()) {
                Map<String, Object> comicChar = map("name", character.getName(), "label", "character");
                int source = nodes.indexOf(comicChar);
                if (source == -1) {
                    nodes.add(comicChar);
                    source = i++;
                }

                rels.add(map("source", source, "target", target));
            }
        }
        return map("nodes", nodes, "links", rels);
    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<ComicIssue> findAll() {
        return issueRepo.findAll();
    }

    @Transactional(readOnly = true)
    public ComicIssue findByName(String name) {
        return issueRepo.findByName(name);
    }

    @Transactional(readOnly = true)
    public Iterable<ComicIssue> findByNameLike(String name) {
        return issueRepo.findByNameLike(name);
    }

    @Transactional(readOnly = true)
    public Map<String, Object>  graph(int limit) {
        return toD3Format(issueRepo.graph(limit));
    }
}
