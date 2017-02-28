package com.gmail.at.sichyuriyy.javatraining.homework3.task12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Yuriy on 24.02.2017.
 */
public class CachedFileContentReaderTest {

    private CachedFileContentReader contentReader;

    private final String TEST_FILE = "test.bin";
    private final byte[] TEST_DATA = new byte[]{1, 2, 3};



    @Before
    public void setUp() throws Exception {
        createTestFile();
        contentReader = new CachedFileContentReader();
    }

    @After
    public void tearDown() throws Exception {
        deleteTestFile();
    }

    @Test
    public void readContentFile() throws Exception {
        byte[] content = contentReader.readContent(new File(TEST_FILE));
        byte[] expected = TEST_DATA;
        assertArrayEquals(expected, content);
    }

    @Test
    public void readContentPath() throws Exception {
        byte[] content = contentReader.readContent(Paths.get(TEST_FILE));
        byte[] expected = TEST_DATA;
        assertArrayEquals(expected, content);
    }

    @Test
    public void readFromCache() throws Exception {
        byte[] content = contentReader.readContent(Paths.get(TEST_FILE));
        byte[] cachedContent = contentReader.readFromCache(Paths.get(TEST_FILE));
        byte[] expected = TEST_DATA;
        assertArrayEquals(expected, cachedContent);
    }

    @Test
    public void readRepeat() throws Exception {
        byte[] content = contentReader.readContent(Paths.get(TEST_FILE));
        byte[] cachedContent = contentReader.readContent(Paths.get(TEST_FILE));
        byte[] expected = TEST_DATA;
        assertArrayEquals(expected, cachedContent);
    }

    private void createTestFile() {
        try {
            Files.write(Paths.get(TEST_FILE), TEST_DATA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteTestFile() {
        try {
            Files.deleteIfExists(Paths.get(TEST_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}