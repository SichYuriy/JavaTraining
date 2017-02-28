package com.gmail.at.sichyuriyy.javatraining.homework3.task12;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yuriy on 22.02.2017.
 */
public class CachedFileContentReader implements FileContentReader {

    Map<Path, SoftReference<byte[]>> cache = new HashMap<>();

    @Override
    public byte[] readContent(File f) throws IOException {
        return readContent(f.toPath());
    }

    @Override
    public byte[] readContent(Path path) throws IOException {
        byte[] content = readFromCache(path);
        if (content != null) {
            return content;
        }
        content = Files.readAllBytes(path);
        cache.put(path, new SoftReference<>(content));
        return Arrays.copyOf(content, content.length);
    }

    public byte[] readFromCache(Path path) {
        byte [] result = null;
        SoftReference<byte[]> softContent = cache.get(path);
        if (softContent != null) {
            byte[] cachedContent = softContent.get();
            if (cachedContent != null) {
                result = Arrays.copyOf(cachedContent, cachedContent.length);
            }
        }
        return result;
    }
}
