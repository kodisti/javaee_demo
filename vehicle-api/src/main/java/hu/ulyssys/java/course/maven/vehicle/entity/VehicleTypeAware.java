package hu.ulyssys.java.course.maven.vehicle.entity;

public interface VehicleTypeAware {
    //nem kell kiírni, de nem gond a public jelzőt/láthatósági módosítót. Mert defaultban public.
    VehicleType getVehicleType();
}
