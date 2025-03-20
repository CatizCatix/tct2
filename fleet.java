import java.util.ArrayList;

/**
 * Flota
 *
 * @author (Diana Hernández y Raquel Selma)
 * @version (10 de Marzo del 2025)
 */
public class Fleet{
    private String name;
    private ArrayList<Machine> machines;
    private boolean weak;

    /**
     * Constructor de la clase Fleet
     */
    public Fleet(String name){
        this.name = name;
        this.machines = new ArrayList<>();
    }

    /**
     * Este método permite mover una flota al norte
     */
    public void moveNorth(){
        for (Machine m : machines){
            Position position = m.getLocation();
            int newLat = position.getLatitude() + 1;
            if (newLat > 90){
                newLat = -90;
            }
            position.setLatitude(newLat);
        }
    }

    /**
     * Mueve todas las máquinas la distancia definida, considerando un mundo circular.
     */
    public void advance(int dLon, int dLat){
        for (Machine m : machines){
            Position position = m.getLocation();
            int newLon = (position.getLongitude() + dLon) % 181;
            int newLat = position.getLatitude() + dLat;

            if (newLat > 90){
                newLat = -90 + (newLat - 90);
            }else if (newLat < -90){
                newLat = 90 - (-90 - newLat);
            }
            
            position.setLatitude(newLat);
            position.setLongitude(newLon);
        }
    }

    /**
     * Consulta las máquinas afectadas por una explosión, excluyendo aviones en el aire.
     */
    public ArrayList<Machine> willBeDestroyed(int longitude, int latitude) {
        ArrayList<Machine> affected = new ArrayList<>();
        for (Machine m : machines) {
            Position position = m.getLocation();
            if (position.getLongitude() == longitude && position.getLatitude() == latitude) {
                if (!(m instanceof Plane && ((Plane) m).isInAir())) {
                    affected.add(m);
                }
            }
        }
        return affected;
    }

    /**
     * Devuelve las máquinas débiles.
     */
    public ArrayList<Machine> weakMachines() {
        ArrayList<Machine> weak = new ArrayList<>();
        for (Machine m : machines) {
            if (m instanceof AircraftCarrier) {
                AircraftCarrier carrier = (AircraftCarrier) m;
                if (carrier.getSailors().size() < 5) {
                    weak.add(m);
                    continue;
                }
                
                // Verificar si algún avión en el aire es débil
                for (Plane plane : carrier.getAirplanes()) {
                    if (plane.isInAir() && plane.getPilot() == null) {
                        weak.add(m);
                        break;
                    }
                }
            } else if (m instanceof Ship) {
                if (((Ship) m).getSailors().size() < 5) {
                    weak.add(m);
                }
            } else if (m instanceof Plane) {
                if (((Plane) m).getPilot() == null) {
                    weak.add(m);
                }
            }
        }
        return weak;
    } 

    /**
     * Verifica si una posición de ataque es adecuada.
     */
    public boolean isGoodAttack(int longitude, int latitude) {
        ArrayList<Machine> affected = willBeDestroyed(longitude, latitude);
        for (Machine m : affected) {
            if (machines.contains(m)) { 
                return false;
            }
        }
        return !affected.isEmpty();
    }

    /**
     * Mueve todas las máquinas no débiles hacia la posición del ataque.
     */
    public void attack(int lon, int lat) {
        ArrayList<Machine> weakOnes = weakMachines();
        for (Machine m : machines) {
            if (!weakOnes.contains(m)) {
                Position position = m.getLocation();
                int dLon = lon - position.getLongitude();
                int dLat = lat - position.getLatitude();
                position.setLongitude(position.getLongitude() + Integer.signum(dLon));
                position.setLatitude(position.getLatitude() + Integer.signum(dLat));
            }
        }
    }

    /**
     * Agrega una máquina a la flota.
     */
    public void addMachine(Machine machine) {
        machines.add(machine);
    }
    
    // Getters y setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<Machine> getMachines() {
        return machines;
    }
}
