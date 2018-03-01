package com.google.hashcode.hashimpl;

public class Ride {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final int earliestStartTime;
    private final int latestFinish;
    private final int getStartToEndDistance;

    public Ride(int startX, int startY, int endX, int endY, int earliestStartTime, int latestFinish){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.earliestStartTime = earliestStartTime;
        this.latestFinish = latestFinish;

        getStartToEndDistance = TakeMeToDestinationHelper.countSteps(startX, startY, endX, endY);
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public int getEarliestStartTime() {
        return earliestStartTime;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public int getStartToEndDistance() {
        return getStartToEndDistance;
    }

    @Override
    public String toString(){
        return String.format("ride from [%d, %d] to [%d, %d], earliest start %d, latest finish %d",
                startX, startY, endX, endY, earliestStartTime, latestFinish);
    }
}
