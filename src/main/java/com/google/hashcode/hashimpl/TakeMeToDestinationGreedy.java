package com.google.hashcode.hashimpl;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TakeMeToDestinationGreedy {
    private final ConcurrentLinkedQueue<Ride> rideList;
    private final ConcurrentLinkedQueue<Vehicle> vehicles;
    private final int simulationStep;

    public TakeMeToDestinationGreedy(DataLoader data){
        rideList = new ConcurrentLinkedQueue(data.getRideList());
        vehicles = new ConcurrentLinkedQueue(data.getVehicles());
        simulationStep = data.getSimulationStep();
    }


    public void start() {
        for (int currentStep = 0; currentStep <= simulationStep; currentStep++) {
            for (Vehicle vehicle : vehicles) {
                if (!vehicle.getOnDuty()) {
                    for (Ride ride : rideList) {
                        // It's already too late, we should remove it from the list and do nothing
                        // process next ride.
                        if(TakeMeToDestinationHelper.alreadyTooLate(ride, currentStep)){
                            rideList.remove(ride);
                        }
                        else{
                            if(TakeMeToDestinationHelper.canArriveOnTime(vehicle, ride, currentStep, simulationStep)){
                                vehicle.setOnDuty(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
