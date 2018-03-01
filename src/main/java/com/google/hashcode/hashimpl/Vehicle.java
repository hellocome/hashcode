package com.google.hashcode.hashimpl;

public class Vehicle {
    private int x;
    private int y;
    private boolean onDuty;

    public Vehicle(int x, int y) {
        this.x = x;
        this.y = y;
        onDuty = false;
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

    public boolean getOnDuty() {
        return onDuty;
    }

    public void setOnDuty(boolean y) {
        this.onDuty = onDuty;
    }
}
