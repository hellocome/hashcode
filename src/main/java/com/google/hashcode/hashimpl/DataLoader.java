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
    private final int vechicles;
    private final int rides;
    private final int bonus;
    private final int simulationStep;
    private final List<Rider> riders = new ArrayList<>();

    public DataLoader(final String path) throws Exception{
        try(final BufferedReader reader = new BufferedReader(new FileReader(path))){
            final List<Integer> globalData = Stream.of(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
            String line;

            row = globalData.get(0);
            column = globalData.get(0);
            vechicles = globalData.get(0);
            rides = globalData.get(0);
            bonus = globalData.get(0);
            simulationStep = globalData.get(0);;

            while((line = reader.readLine()) != null) {
                final List<Integer> riderData = Stream.of(line.split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
                riders.add(new Rider(riderData.get(0), riderData.get(1), riderData.get(2), riderData.get(3), riderData.get(4), riderData.get(5)));
            }
        }
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d rows, %d columns, %d vehicles, %d rides, %d bonus and %d steps\n", row, column, vechicles,
                riders, bonus, simulationStep));
        riders.forEach( rider -> sb.append(rider.toString() + "\n"));
        return sb.toString();
    }
}
