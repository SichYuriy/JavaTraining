package com.gmail.at.sichyuriyy.javatraining.homework3.task12;

import java.io.IOException;
import java.nio.file.Path;
import java.io.File;

/**
 * Created by Yuriy on 24.02.2017.
 */
public interface FileContentReader {

    byte[] readContent(File file) throws IOException;
    byte[] readContent(Path path) throws IOException;
}
