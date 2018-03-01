package com.google.hashcode;

import com.google.hashcode.hashimpl.DataLoader;
import com.google.hashcode.hashimpl.TakeMeToDestinationGreedy;
import com.google.hashcode.hashimpl.TakeMeToDestinationHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashApp {
    public static final String HASHCODE_FILE = "com.google.hashcode.file";

    public static void main(String[] args) {
        try {
            //final String result = "E:\\SourceControl\\MyGitHub\\hashcode\\result\\c";
            //final String result = "E:\\SourceControl\\MyGitHub\\hashcode\\result\\d";
            final String result = "E:\\SourceControl\\MyGitHub\\hashcode\\result\\e";
            System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\e_high_bonus.in");
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\b_should_be_easy.in");
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\c_no_hurry.in");
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\d_metropolis.in");
            //System.setProperty(HASHCODE_FILE, "E:\\SourceControl\\MyGitHub\\hashcode\\DataSet\\a_example.in");

            ExecutorService taskExecutor = Executors.newFixedThreadPool(100);
            int i =0;
            while(i++<100) {
                taskExecutor.execute(() -> {
                    try {
                        DataLoader loader = new DataLoader(System.getProperty(HASHCODE_FILE));
                        TakeMeToDestinationGreedy greedy = new TakeMeToDestinationGreedy(loader);
                        String res = greedy.start();

                        String fileName = result + "_" + greedy.getNotAccurateScore() + ".txt";
                        TakeMeToDestinationHelper.resultWritter(res, fileName);
                        System.out.println("ok " + fileName);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
            }

            taskExecutor.shutdown();

            try {
                taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
