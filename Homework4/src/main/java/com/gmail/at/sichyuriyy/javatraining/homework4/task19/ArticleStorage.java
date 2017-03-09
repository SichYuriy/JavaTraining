package com.gmail.at.sichyuriyy.javatraining.homework4.task19;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class ArticleStorage {

    private Map<String, Article> articleMap;

    public ArticleStorage() {
        articleMap = new HashMap<>();
        Article article1 = new Article(
                "article1",
                Arrays.asList("part1-1", "part1-2", "part1-3")
        );
        Article article2 = new Article(
                "article2",
                Arrays.asList("part2-1", "part2-2", "part2-3")
        );
        articleMap.put(article1.getName(), article1);
        articleMap.put(article2.getName(), article2);

    }

    public Article getArticle(String name) {
        return articleMap.get(name).cloneArticle();
    }
}
