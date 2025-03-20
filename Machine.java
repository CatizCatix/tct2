import java.util.ArrayList;

/**
 * Representa una máquina en la flota.
 */
public class Machine {
    private Position position;
    
    public Machine() {
        this.position = new Position();
    }

    public int getLatitude() {
        return position.getLatitude();
    }

    public int getLongitude() {
        return position.getLongitude();
    }

    public void setLatitude(int latitude) {
        position.setLatitude(latitude);
    }

    public void setLongitude(int longitude) {
        position.setLongitude(longitude);
    }

    public boolean isWeak() {
        return false;
    }

    public boolean canBeDestroyed() {
        return true;
    }
}
