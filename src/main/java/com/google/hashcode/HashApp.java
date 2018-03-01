package com.google.hashcode;

import com.google.hashcode.hashimpl.DataLoader;
import com.google.hashcode.hashimpl.TakeMeToDestinationGreedy;

public class HashApp {
    public static final String HASHCODE_FILE = "com.google.hashcode.file";


    public static void main(String[] args) {
        try {
            System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\a_example.in");

            DataLoader loader = new DataLoader(System.getProperty(HASHCODE_FILE));
            TakeMeToDestinationGreedy greedy = new TakeMeToDestinationGreedy(loader);

            System.out.print(greedy.start());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
