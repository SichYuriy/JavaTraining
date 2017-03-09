package com.gmail.at.sichyuriyy.javatraining.homework4.task19;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/9/2017.
 */
public class ArticleStorageTest {
    @Test
    public void getArticle() {
        ArticleStorage storage = new ArticleStorage();
        List<String> expected = storage.getArticle("article1").getParts();

        Article articleToEdit = storage.getArticle("article1");
        articleToEdit.clear();

        List<String> actual = storage.getArticle("article1").getParts();

        assertEquals(expected, actual);
    }

}