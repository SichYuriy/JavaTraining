package com.gmail.at.sichyuriyy.javatraining.homework4.task19;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class ArticleTest {

    @Test
    public void addPart() {
        Article article = new Article("article");
        String part = "part1";
        article.addPart(part);

        List<String> expected = Collections.singletonList(part);
        List<String> actual = article.getParts();

        assertEquals(expected, actual);
    }

    @Test
    public void removePart() {
        Article article = new Article(
                "article",
                Arrays.asList("part1", "part2")
        );

        article.removePart(0);
        List<String> expected = Collections.singletonList("part2");
        List<String> actual = article.getParts();

        assertEquals(expected, actual);
    }

    @Test
    public void clear() {
        Article article = new Article(
                "article",
                Arrays.asList("part1", "part2")
        );

        article.clear();

        assertTrue(article.getParts().isEmpty());
    }

}