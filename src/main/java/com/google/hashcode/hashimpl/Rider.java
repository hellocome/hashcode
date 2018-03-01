package com.google.hashcode.hashimpl;

public class Rider {
    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;
    private final int earliestStartTime;
    private final int latestFinish;

    public Rider(int startX, int startY, int endX, int endY, int earliestStartTime, int latestFinish){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.earliestStartTime = earliestStartTime;
        this.latestFinish = latestFinish;
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

    @Override
    public String toString(){
        return String.format("ride from [%d, %d] to [%d, %d], earliest start %d, latest finish %d",
                startX, startY, endX, endY, earliestStartTime, latestFinish);
    }
}
