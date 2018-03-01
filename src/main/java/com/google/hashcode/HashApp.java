package com.google.hashcode;

import com.google.hashcode.hashimpl.DataLoader;
import com.google.hashcode.hashimpl.TakeMeToDestinationGreedy;
import com.google.hashcode.hashimpl.TakeMeToDestinationHelper;

public class HashApp {
    public static final String HASHCODE_FILE = "com.google.hashcode.file";

    public static void main(String[] args) {
        try {
            final String result = "E:\\SourceControl\\MyGitHub\\hashcode\\result\\c_no_hurry_1.res";
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\b_should_be_easy.in");
            System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\c_no_hurry.in");
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\d_metropolis.in");
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\e_high_bonus.in");

            DataLoader loader = new DataLoader(System.getProperty(HASHCODE_FILE));

            //System.out.print(loader);
            TakeMeToDestinationGreedy greedy = new TakeMeToDestinationGreedy(loader);

            TakeMeToDestinationHelper.resultWritter(greedy.start(), result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
