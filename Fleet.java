import java.util.ArrayList;

/**
 * Flota
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fleet
{
    // instance variables - replace the example below with your own
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
