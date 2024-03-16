package com.nicmsaraiva.utils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.apache.commons.io.FileUtils.readFileToString;

public class JsonUtils {
    public static String json2String(String fileName) {
        String filePath = "src/test/resources/payloads/" + fileName;
        try {
            return readFileToString(new File(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
