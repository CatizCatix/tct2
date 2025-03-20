/**
 * Representa un marinero en la flota.
 */
public class Sailor {
    private Plane plane;
    private Fleet fleet;
    private String name;
    private int rank;

    public Sailor(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.plane = null;
        this.fleet = null;
    }

    public void assignPlane(Plane plane) {
        this.plane = plane;
    }
}
