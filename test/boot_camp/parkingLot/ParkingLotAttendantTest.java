package boot_camp.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingLotAttendantTest {

    @Test
    void shouldParkACar() {
        ParkingLot parkingLot = new ParkingLot(4);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car = new Car();
        assertTrue(parkingLotAttendant.park(car));
    }


    @Test
    void shouldNotParkWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        assertFalse(parkingLotAttendant.park(car3));
    }

    @Test
    void shouldParkInAnyOneOfParkingLot() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot1);
        parkingLotAttendant.addParkingLot(parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        assertTrue(parkingLotAttendant.park(car3));
    }

    @Test
    void shouldParkACarWhenAFullLotBecomesFree() {

        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car = new Car();
        parkingLotAttendant.park(car);
        parkingLot.unPark(car);
        assertTrue(parkingLotAttendant.park(new Car()));
    }
}