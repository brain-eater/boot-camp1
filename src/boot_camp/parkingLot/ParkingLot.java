package boot_camp.parkingLot;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private List<Car> parkedCars;
    private int size;
    private ParkingLotAttendant attendant;

    ParkingLot(int size) {
        this.size = size;
        this.parkedCars = new ArrayList<>();
    }

    boolean park(Car car) {
        if (isFull()) return false;
        parkedCars.add(car);
        if (isFull() && attendant != null) {
            attendant.notifyLotFull(this);
        }
        return true;
    }

    void registerAttendant(ParkingLotAttendant attendant) {
        this.attendant = attendant;
    }

    boolean isFull() {
        return size == parkedCars.size();
    }

    boolean unPark(Car car) {
        if(!parkedCars.contains(car)) return false;
        if(isFull()) attendant.notifyLotFree(this);
        parkedCars.remove(car);
        return true;
    }
}
