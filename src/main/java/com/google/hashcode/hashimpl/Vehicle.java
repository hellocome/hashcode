package com.google.hashcode.hashimpl;

public class Vehicle {
    private int x;
    private int y;
    private boolean onDuty;
    private int stepToFree;

    public Vehicle(int x, int y) {
        this.x = x;
        this.y = y;
        onDuty = false;
        stepToFree = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVehicleOnDuty(final int currentStep) {
        if (this.stepToFree > currentStep) {
            return false;
        } else {
            return onDuty;
        }
    }

    public void setStepToFree(int stepToFree) {
        this.stepToFree = stepToFree;
    }
}
