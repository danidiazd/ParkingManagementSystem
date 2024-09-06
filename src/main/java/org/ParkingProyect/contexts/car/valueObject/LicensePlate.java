package org.ParkingProyect.contexts.car.valueObject;

public class LicensePlate {

        private final String plate;

        public LicensePlate(String plate) {
            if (plate == null || plate.isEmpty()) {
                throw new IllegalArgumentException("Invalid plate");
            }
            this.plate = plate;
        }

        public String getPlate() {
            return plate;
        }

        // 1 plate is valid if had 4 numbers and 3 letters
        public boolean isValid() {
            return this.plate.matches("[0-9]{4}[A-Z]{3}");
        }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LicensePlate that = (LicensePlate) obj;
        return plate.equals(that.plate);
    }

    @Override
    public int hashCode() {
        return plate.hashCode();
    }

    @Override
    public String toString() {
        return plate;
    }
}
