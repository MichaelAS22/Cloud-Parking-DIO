package one.digitalinnovation.service;

import one.digitalinnovation.model.Parking;

import java.time.LocalDateTime;

public class ParkingCheckout {

    public static Double getBill(Parking parking){
        return getBill(parking.getEntryDate(), parking.getExitDate());
    }

    private static Double getBill(LocalDateTime entryDate, LocalDateTime exitDate) {
        return null;
    }
}
