/**
 * Representa un avión dentro de la flota.
 */
public class Plane extends Machine {
    private AircraftCarrier aircraftCarrier;
    private int plate;
    private boolean inAir;
    private Sailor mainPilot;

    public Plane(AircraftCarrier aircraftCarrier, int plate) {
        this.aircraftCarrier = aircraftCarrier;
        this.plate = plate;
        this.inAir = false;
        this.mainPilot = null;
    }

    public boolean hasMainPilot() {
        return mainPilot != null;
    }

    public boolean isInAir() {
        return inAir;
    }

    public void takeOff() {
        this.inAir = true;
    }

    public void land() {
        this.inAir = false;
    }
}
