package boot_camp.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParkingLotTest {

    @Test
    void shouldParkACarInTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(5);
        Car car = new Car();
        assertTrue(parkingLot.park(car));
    }

    @Test
    void shouldNotParkWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot.park(car1);
        assertFalse(parkingLot.park(car2));
    }

    @Test
    void shouldNotifyAttendantWhenTheLotIsFull() {

        ParkingLot parkingLot = new ParkingLot(2);
        TestAttendant testAttendant = new TestAttendant();
        parkingLot.registerAttendant(testAttendant);

        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertTrue(testAttendant.isNotifiedFull);
    }

    @Test
    void shouldNotifyTheAttendantWhenAFullLotBecomesFree() {

        ParkingLot parkingLot = new ParkingLot(2);
        TestAttendant testAttendant = new TestAttendant();
        parkingLot.registerAttendant(testAttendant);

        Car car = new Car();
        parkingLot.park(new Car());
        parkingLot.park(car);
        parkingLot.unPark(car);
        assertTrue(testAttendant.isNotifiedFree);


    }

}

class TestAttendant extends ParkingLotAttendant {
    boolean isNotifiedFull = false;
    boolean isNotifiedFree = false;

    @Override
    void notifyLotFull(ParkingLot parkingLot) {
        isNotifiedFull = true;
    }

    @Override
    void notifyLotFree(ParkingLot parkingLot) {
        isNotifiedFree = true;
    }
}