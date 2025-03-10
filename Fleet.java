import java.util.ArrayList;

/**
 * Flota
 *
 * @author (Diana Hernández y Raquel Selma)
 * @version (10 de Marzo del 2025)
 */
public class Fleet
{
    private String name;
    private ArrayList<Machine> machines;

    /**
     * Constructor de la clase Fleet
     */
    public Fleet()
    {
        this.name = name;
        this.machines= new ArrayList();
    }

    /**
     * Este método permite mover una flota al norte
     */
    public void moveNorth(){
        for (Machine m:machines){
            m.setLatitude(m.getLatitude()+1);
        }
    }

}
