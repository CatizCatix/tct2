/**
 * Representa la posición de una máquina en el mapa.
 */
public class Position {
    private int longitude;
    private int latitude;

    public Position() {
        this.longitude = 0;
        this.latitude = 0;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
}
