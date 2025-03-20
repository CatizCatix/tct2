
/**
 * Representa un portaaviones en la flota.
 */
public class AircraftCarrier extends Ship {
    private int number;
    private int capacity;
    private ArrayList<Plane> planes;

    public AircraftCarrier(int number, int capacity) {
        super();
        this.number = number;
        this.capacity = capacity;
        this.planes = new ArrayList<>();
    }

    public void addPlane(Plane plane) {
        if (planes.size() < capacity) {
            planes.add(plane);
        }
    }

    public boolean hasWeakPlanes() {
        for (Plane p : planes) {
            if (!p.hasMainPilot()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isWeak() {
        return super.isWeak() || hasWeakPlanes();
    }
}
