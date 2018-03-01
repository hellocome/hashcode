package com.google.hashcode.hashimpl;

public class TakeMeToDestinationHelper {
    public static int countSteps(final int startX, final int startY, final int endX, final int endY){
        return Math.abs(startX - endX) + Math.abs(endY - startY);
    }

    public static int countSteps(final Vehicle v, final Ride r){
        return Math.abs(v.getX() - r.getStartX()) + Math.abs(v.getY() - r.getStartY());
    }

    // if can arrive on time, we just return the time when the vehicle is free otherwise return 0
    public static int canArriveOnTime(final Vehicle v, final Ride r, final int currentStep, final int simulationStep){
        final int vToRSteps = countSteps(v, r);
        final int waitToStart = r.getEarliestStartTime() > (currentStep + vToRSteps) ?
                r.getEarliestStartTime() - (currentStep + vToRSteps) : 0;

        final int willBeArrive = currentStep + vToRSteps + waitToStart + r.getStartToEndDistance();

        if(willBeArrive > r.getLatestFinish()){
            return 0;
        }

        return willBeArrive;
    }

    public static boolean alreadyTooLate(final Ride r, final int currentStep) {
        return r.getLatestFinish() <= currentStep;
    }
}
