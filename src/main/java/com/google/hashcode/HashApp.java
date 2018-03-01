package com.google.hashcode;

import com.google.hashcode.hashimpl.DataLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class HashApp {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String HASHCODE_FILE = "com.google.hashcode.file";

    private static void loadPizza() throws Exception {
        final Properties props = new Properties();
        final InputStream in = new FileInputStream("zip-install.properties");

        try {
            props.load(in);
            for (final Map.Entry<Object, Object> entry : props.entrySet()) {
                System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                System.out.println(entry.getKey().toString() + " = " + entry.getValue().toString());
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties", e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // don't care
            }
        }
    }

    public static void main(String[] args) {
        try {
            System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\a_example.in");

            DataLoader loader = new DataLoader(System.getProperty(HASHCODE_FILE));
            System.out.print(loader.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
