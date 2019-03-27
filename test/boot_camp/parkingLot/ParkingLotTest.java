package boot_camp.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ParkingLotTest {

    @Test
    void shouldParkACarInTheParkingLot() {
        ParkingLot parkingLot = new ParkingLot(1, 5);
        Car car = new Car();
        assertEquals(Token.class, parkingLot.park(car).getClass());
    }

    @Test
    void shouldNotParkWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot.park(car1);
        assertNull(parkingLot.park(car2));
    }

    @Test
    void shouldNotifyAttendantWhenTheLotIsFull() {

        ParkingLot parkingLot = new ParkingLot(1, 2);
        TestAttendant testAttendant = new TestAttendant();
        parkingLot.registerAttendant(testAttendant);

        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertTrue(testAttendant.isNotifiedFull);
    }

    @Test
    void shouldNotifyTheAttendantWhenAFullLotBecomesFree() {

        ParkingLot parkingLot = new ParkingLot(1, 2);
        TestAttendant testAttendant = new TestAttendant();
        parkingLot.registerAttendant(testAttendant);

        Car car = new Car();
        parkingLot.park(new Car());
        Token token = parkingLot.park(car);
        parkingLot.unPark(token);
        assertTrue(testAttendant.isNotifiedFree);
    }

    @Test
    void shouldNotUnParkIfCarIsNotThereInLot() {
        ParkingLot parkingLot = new ParkingLot(1, 2);
        parkingLot.park(new Car());
        assertFalse(parkingLot.unPark(new Token(1)));
    }

    @Test
    void shouldReturnNumberOfCarsParked() {
        ParkingLot parkingLot = new ParkingLot(1, 3);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        assertEquals(2, parkingLot.getParkedCarsCount());
    }

    @Test
    void shouldUnPark() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        Token token = parkingLot.park(new Car());
        assertNull(parkingLot.park(new Car()));
        parkingLot.unPark(token);
        assertEquals(Token.class, parkingLot.park(new Car()).getClass());
    }

    @Test
    void shouldNotifyDisplayManagerWhenCarIsParked() {
        ParkingLot parkingLot = new ParkingLot(1, 3);
        TestAssistant testAssistant = new TestAssistant();
        parkingLot.registerDisplayManager(testAssistant);
        parkingLot.park(new Car());
        assertTrue(testAssistant.isNotifiedParked);
    }

    @Test
    void shouldNotifyDisplayManagerWhenCarIsUnParked() {
        ParkingLot parkingLot = new ParkingLot(1, 3);
        TestAssistant testAssistant = new TestAssistant();
        parkingLot.registerDisplayManager(testAssistant);
        Token token = parkingLot.park(new Car());
        parkingLot.unPark(token);
        assertTrue(testAssistant.isNotifiedUnParked);
    }

    @Test
    void shouldNotifyToAttendantWhenLotIsTwentyPercentOrLessOccupied() {

        ParkingLot parkingLot = new ParkingLot(1, 6);
        TestAttendant testAttendant = new TestAttendant();
        parkingLot.registerAttendant(testAttendant);
        parkingLot.park(new Car());
        assertTrue(testAttendant.isNotifiedForLotIsEightyPercentFree);
    }
}

class TestAttendant extends ParkingLotAttendant {
    boolean isNotifiedFull = false;
    boolean isNotifiedFree = false;
    boolean isNotifiedForLotIsEightyPercentFree = false;

    @Override
    void notifyLotFull(ParkingLot parkingLot) {
        isNotifiedFull = true;
    }

    @Override
    void notifyLotFree(ParkingLot parkingLot) {
        isNotifiedFree = true;
    }

    @Override
    void notifyEightyPercentLotFree(ParkingLot parkingLot) {
        this.isNotifiedForLotIsEightyPercentFree = true;
    }
}

class TestAssistant extends ParkingLotAssistant {
    boolean isNotifiedParked = false;
    boolean isNotifiedUnParked = false;

    @Override
    void notifyCarParked(Integer parkingLotId) {
        this.isNotifiedParked = true;
    }

    @Override
    void notifyCarUnParked(Integer parkingLotId) {
        this.isNotifiedUnParked = true;
    }
}