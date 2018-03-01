package com.google.hashcode;

import com.google.hashcode.hashimpl.DataLoader;
import com.google.hashcode.hashimpl.TakeMeToDestinationGreedy;
import com.google.hashcode.hashimpl.TakeMeToDestinationHelper;

public class HashApp {
    public static final String HASHCODE_FILE = "com.google.hashcode.file";

    public static void main(String[] args) {
        try {
            //final String result = "E:\\SourceControl\\MyGitHub\\hashcode\\result\\c";
            //final String result = "E:\\SourceControl\\MyGitHub\\hashcode\\result\\d";
            final String result = "E:\\SourceControl\\MyGitHub\\hashcode\\result\\e";
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\b_should_be_easy.in");
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\c_no_hurry.in");
            System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\d_metropolis.in");
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\a_example.in");

            for(int i=0; i<100; i++) {
                DataLoader loader = new DataLoader(System.getProperty(HASHCODE_FILE));
                TakeMeToDestinationGreedy greedy = new TakeMeToDestinationGreedy(loader);
                TakeMeToDestinationHelper.resultWritter(greedy.start(), result + "_" + greedy.getNotAccurateScore() + ".txt");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
