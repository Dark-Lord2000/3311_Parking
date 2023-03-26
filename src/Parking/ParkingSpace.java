package Parking;
import Utilities.Sensor;

public class ParkingSpace {
    private final int spaceNum;
    private final ParkingLot inLot;
    private boolean enabled;
    private final Sensor sensor;
    private boolean booked;
    private final int location;

    // Private constructor that takes a builder object
    private ParkingSpace(Builder builder) {
        this.spaceNum = builder.spaceNum;
        this.inLot = builder.inLot;
        this.sensor = builder.sensor;
        this.location = builder.location;
        this.booked = builder.booked;
        this.enabled = builder.enabled;
    }

    // Static inner Builder class
    public static class Builder {
        private int spaceNum;
        private ParkingLot inLot;
        private boolean enabled = true;
        private Sensor sensor;
        private boolean booked = false;
        private int location;

        // Setters that return the builder instance
        public Builder spaceNum(int spaceNum) {
            this.spaceNum = spaceNum;
            return this;
        }

        public Builder inLot(ParkingLot inLot) {
            this.inLot = inLot;
            return this;
        }

        public Builder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder sensor(Sensor sensor) {
            this.sensor = sensor;
            return this;
        }

        public Builder booked(boolean booked) {
            this.booked = booked;
            return this;
        }

        public Builder location(int location) {
            this.location = location;
            return this;
        }

        // Build method that returns a new ParkingSpace instance
        public ParkingSpace build() {
            return new ParkingSpace(this);
        }
    }

    // Getters for the class variables
    public int getSpaceNumber() {
        return this.spaceNum;
    }

    public ParkingLot getParkingLot() {
        return this.inLot;
    }

    public Sensor getSensor() {
        return this.sensor;
    }

    public int getLocation() {
        return this.location;
    }

    public boolean isBooked() {
        return this.booked;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
    
    // enable, disable and setBooked methods are same as in the original code
    public void enable() {
        this.enabled = true;
    }
    
    public void disable() {
        this.enabled = false;
    }
    
    public void setBooked(boolean book) {
        this.booked = book;
    }
}
