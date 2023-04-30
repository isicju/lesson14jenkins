package org.example.functional;

import java.util.List;

public class Closest5CoffeeShop {
    interface Location {
        long distanceBetween(Location other);
    }

    public List<String> findCoffeeNearMe(Location you, List<CoffeeShop> shops) {
        //return 5 names of closest cofeeshops.
        return null;
    }

    static class CoffeeShop {
        private String name;
        private Location location;

        public CoffeeShop(String name, Location location) {
            this.name = name;
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public Location getLocation() {
            return location;
        }
    }
}
