package com.shashank.ps.lld.trafficLightManagement;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Intersection {

    private Map<Direction, TrafficLight> directionTrafficLightMap;

    public Intersection() {
        directionTrafficLightMap = new HashMap<>();
        directionTrafficLightMap.put(Direction.NORTH, new TrafficLight());
        directionTrafficLightMap.put(Direction.SOUTH, new TrafficLight());
        directionTrafficLightMap.put(Direction.EAST, new TrafficLight());
        directionTrafficLightMap.put(Direction.WEST, new TrafficLight());
    }

    public TrafficLight getTrafficLight(Direction direction) {
        return this.directionTrafficLightMap.get(direction);
    }

    public void controlTraffic(Direction directionForGreen) throws InterruptedException {
        directionTrafficLightMap.entrySet().stream()
                .filter(entry -> entry.getValue().getColor().equals(Color.GREEN))
                .forEach(entry -> directionTrafficLightMap.replace(entry.getKey(), new TrafficLight(Color.YELLOW)));

        directionTrafficLightMap.replace(directionForGreen, new TrafficLight(Color.YELLOW));
        Thread.sleep(5000);
        directionTrafficLightMap.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(directionForGreen)
                        && entry.getValue().getColor().equals(Color.YELLOW))
                .forEach(entry -> directionTrafficLightMap.replace(entry.getKey(), new TrafficLight(Color.RED)));
        directionTrafficLightMap.replace(directionForGreen, new TrafficLight(Color.GREEN));
    }
}
