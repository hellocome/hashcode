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
        rideList = new ConcurrentLinkedQueue();
        vehiclesRideMap = new HashMap<Vehicle, ArrayList<Integer>>();
        data.getVehicles().forEach(vehicle -> vehiclesRideMap.put(vehicle, new ArrayList<>()));
        simulationStep = data.getSimulationStep();
    }

    public void start() {
        for (int currentStep = 0; currentStep <= simulationStep; currentStep++) {
            for (Vehicle vehicle : vehiclesRideMap.keySet()) {
                if (!vehicle.isVehicleOnDuty(currentStep)) {
                    for (Ride ride : rideList) {
                        // It's already too late, we should remove it from the list and do nothing
                        // process next ride.
                        if (TakeMeToDestinationHelper.alreadyTooLate(ride, currentStep)) {
                            rideList.remove(ride);
                        } else {
                            final int lastStepOnDuty = TakeMeToDestinationHelper.canArriveOnTime(vehicle, ride, currentStep, simulationStep);
                            if (lastStepOnDuty > 0) {
                                vehicle.setStepToFree(lastStepOnDuty + 1);
                            }
                        }
                    }
                } else {

                }
            }
        }
    }
}
