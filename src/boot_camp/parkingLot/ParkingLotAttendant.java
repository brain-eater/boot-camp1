package boot_camp.parkingLot;

import java.util.ArrayList;
import java.util.List;

class ParkingLotAttendant {

    private List<ParkingLot> freeParkingLots;
    private List<ParkingLot> filledParkingLots;

    ParkingLotAttendant() {
        this.freeParkingLots = new ArrayList<>();
        this.filledParkingLots = new ArrayList<>();
    }

    void addParkingLot(ParkingLot parkingLot) {
        parkingLot.registerAttendant(this);
        List<ParkingLot> respectiveParkingLots = freeParkingLots;
        if (parkingLot.isFull()) respectiveParkingLots = filledParkingLots;
        respectiveParkingLots.add(parkingLot);
    }

    boolean park(Car car) {
        if (freeParkingLots.isEmpty()) return false;
        ParkingLot parkingLot = freeParkingLots.iterator().next();
        parkingLot.park(car);
        return true;
    }

    void notifyLotFull(ParkingLot parkingLot) {
        freeParkingLots.remove(parkingLot);
        filledParkingLots.add(parkingLot);
    }

    void notifyLotFree(ParkingLot parkingLot) {
        filledParkingLots.remove(parkingLot);
        freeParkingLots.add(parkingLot);
    }
}
