package boot_camp.parkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotAttendantTest {

    @Test
    void shouldParkACarAndReturnToken() {
        ParkingLot parkingLot = new ParkingLot(1, 4);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car = new Car();
        assertEquals(Token.class, parkingLotAttendant.park(car).getClass());
    }


    @Test
    void shouldNotParkWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1, 2);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        assertNull(parkingLotAttendant.park(car3));
    }

    @Test
    void shouldParkInAnyOneOfParkingLot() {
        ParkingLot parkingLot1 = new ParkingLot(1, 2);
        ParkingLot parkingLot2 = new ParkingLot(1, 2);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot1);
        parkingLotAttendant.addParkingLot(parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        assertEquals(Token.class, parkingLotAttendant.park(car3).getClass());
    }

    @Test
    void shouldParkACarWhenAFullLotBecomesFree() {

        ParkingLot parkingLot = new ParkingLot(1, 1);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car = new Car();
        Token token = parkingLotAttendant.park(car);
        parkingLot.unPark(token);
        assertEquals(Token.class, parkingLotAttendant.park(new Car()).getClass());
    }

    @Test
    void shouldCallAddParkingLotOfDisplayWhenNewDisplayIsAdded() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        TestDisplay testDisplay = new TestDisplay();
        parkingLotAttendant.addDisplay(testDisplay);
        assertTrue(testDisplay.called);
    }

    @Test
    void shouldCallIncrementCarCountOfDisplay() {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        TestDisplay testDisplay = new TestDisplay();
        parkingLotAttendant.addDisplay(testDisplay);
        parkingLotAttendant.notifyCarParked(1);
        assertTrue(testDisplay.incrementCarCountCalled);
    }

    @Test
    void shouldCallDecrementCarCountOfDisplay() {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        TestDisplay testDisplay = new TestDisplay();
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.park(new Car());
        parkingLotAttendant.addParkingLot(parkingLot);
        parkingLotAttendant.addDisplay(testDisplay);
        parkingLotAttendant.notifyCarUnParked(parkingLot.getId());
        assertTrue(testDisplay.decrementCarCountCalled);
    }


    @Test
    void shouldRegisterDisplayManagerWhenAssistantGetAdded() {
        ParkingLotAssistant parkingLotAssistant = new ParkingLotAssistant();
        TestParkingLot parkingLot = new TestParkingLot(1, 2);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        parkingLot.registerDisplayManager(parkingLotAssistant);

        assertEquals(parkingLot.displayManager, parkingLotAssistant);
    }

    private class TestParkingLot extends ParkingLot {
        DisplayManager displayManager;

        TestParkingLot(int id, int size) {
            super(id, size);
        }

        @Override
        void registerDisplayManager(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }
    }

    private class TestDisplay extends Display {
        boolean called;
        boolean incrementCarCountCalled;
        boolean decrementCarCountCalled;

        TestDisplay() {
            super();
            this.called = false;
            this.incrementCarCountCalled = false;
            this.decrementCarCountCalled = false;
        }

        @Override
        void addParkingLot(Integer parkingLotId, Integer carCount) {
            called = true;
        }

        @Override
        void incrementCarCount(Integer parkingLotId) {
            this.incrementCarCountCalled = true;
        }

        @Override
        void decrementCarCount(Integer parkingLotId) {
            this.decrementCarCountCalled = true;
        }
    }
}