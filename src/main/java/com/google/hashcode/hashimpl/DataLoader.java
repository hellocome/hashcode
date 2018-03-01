package com.google.hashcode.hashimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataLoader {
    private final int row;
    private final int column;
    private final int vehicleNumber;
    private final int rides;
    private final int bonus;
    private final int simulationStep;
    private final List<Ride> rideList = new ArrayList<>();
    private final List<Vehicle> vehicles = new ArrayList<>();

    public DataLoader(final String path) throws Exception{
        try(final BufferedReader reader = new BufferedReader(new FileReader(path))){
            final List<Integer> globalData = Stream.of(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
            String line;
            int index = 0;

            row = globalData.get(0);
            column = globalData.get(1);
            vehicleNumber = globalData.get(2);
            rides = globalData.get(3);
            bonus = globalData.get(4);
            simulationStep = globalData.get(5);

            while((line = reader.readLine()) != null) {
                final List<Integer> riderData = Stream.of(line.split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
                rideList.add(new Ride(index++, riderData.get(0), riderData.get(1), riderData.get(2), riderData.get(3), riderData.get(4), riderData.get(5)));
            }

            for (int i = 0; i < vehicleNumber; i++) {
                vehicles.add(new Vehicle(0,0));
            }
        }
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d rows, %d columns, %d vehicles, %d rides, %d bonus and %d steps\n", row, column, vehicleNumber,
                rideList.size(), bonus, simulationStep));
        rideList.forEach( rider -> sb.append(rider.toString() + "\n"));
        return sb.toString();
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public int getRides() {
        return rides;
    }

    public int getBonus() {
        return bonus;
    }

    public int getSimulationStep() {
        return simulationStep;
    }

    public List<Ride> getRideList() {
        return rideList;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
