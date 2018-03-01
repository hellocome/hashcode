package com.google.hashcode.hashimpl;

public class TakeMeToDestinationHelper {
    public static int countSteps(int startX, int startY, int endX, int endY){
        return Math.abs(startX - endX) + Math.abs(endY - startY);
    }

    public static int countSteps(Vehicle v, Ride r){
        return Math.abs(v.getX() - r.getStartX()) + Math.abs(v.getY() - r.getStartY());
    }
}
