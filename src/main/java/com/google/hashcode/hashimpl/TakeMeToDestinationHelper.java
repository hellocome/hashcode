package com.google.hashcode.hashimpl;

public class TakeMeToDestinationHelper {
    public static int countSteps(int startX, int startY, int endX, int endY){
        return Math.abs(startX - endX) + Math.abs(endY - startY);
    }
}
