import java.util.ArrayList;

/**
 * Representa un barco en la flota.
 */
public class Ship extends Machine {
    private ArrayList<Sailor> sailors;

    public Ship() {
        this.sailors = new ArrayList<>();
    }

    public void addSailor(Sailor sailor) {
        sailors.add(sailor);
    }

    public ArrayList<Sailor> getSailors() {
        return sailors;
    }

    @Override
    public boolean isWeak() {
        return sailors.size() < 5;
    }
}
