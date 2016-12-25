package com.logicbig.example;


import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentRegexTest {

    public static void main (String[] args) throws Exception {

        String source = getJavaSource();
        Pattern pattern = Pattern.compile("(?s)/\\*(.)*?\\*/");
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    public static String getJavaSource () throws Exception {
        URL url = Thread.currentThread()
                        .getContextClassLoader()
                        .getResource("TestSource.java");
        return new String(Files.readAllBytes(
                  new File(url.toURI()).toPath()));

    }
}
