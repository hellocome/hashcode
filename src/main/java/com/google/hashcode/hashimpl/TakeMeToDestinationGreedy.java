package com.google.hashcode.hashimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TakeMeToDestinationGreedy {
    private final ConcurrentLinkedQueue<Ride> rideList;
    private final Map<Vehicle, ArrayList<Integer>> vehiclesRideMap;
    private final int simulationStep;

    public TakeMeToDestinationGreedy(DataLoader data){
        rideList = new ConcurrentLinkedQueue(data.getRideList());
        vehiclesRideMap = new HashMap<>();
        data.getVehicles().forEach(vehicle -> vehiclesRideMap.put(vehicle, new ArrayList<>()));
        simulationStep = data.getSimulationStep();
    }

    public String start() {
        for (int currentStep = 0; currentStep <= simulationStep && rideList.size() > 0; currentStep++) {
            for (Vehicle vehicle : vehiclesRideMap.keySet()) {
                if (!vehicle.isVehicleOnDuty(currentStep)) {
                    for (Ride ride : rideList) {
                        // It's already too late, we should remove it from the list and do nothing
                        // process next ride.
                        if (TakeMeToDestinationHelper.alreadyTooLate(ride, currentStep)) {
                            rideList.remove(ride);
                        } else {
                            final int lastStepOnDuty = TakeMeToDestinationHelper.canArriveOnTime(vehicle, ride, currentStep, simulationStep);
                            // Can arrive on time and return the last step the vehicle is on duty
                            // so the lastStepOnDuty + 1 step, the vehicle is free.
                            if (lastStepOnDuty > 0) {
                                vehicle.setStepToFree(lastStepOnDuty + 1);
                                vehiclesRideMap.get(vehicle).add(ride.getIndex());
                                rideList.remove(ride);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return buildResult();
    }

    private String buildResult(){
        final StringBuilder allLines = new StringBuilder();

        vehiclesRideMap.forEach( (v, rides) ->{
            final StringBuilder oneLine = new StringBuilder();
            rides.forEach(ride -> oneLine.append(ride + " "));

            allLines.append(oneLine.toString().trim() + "\n");
        });

        return allLines.toString();
    }
}
