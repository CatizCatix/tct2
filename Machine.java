

public class Machine
{
    private Position position;
    private boolean isWeak;

    /**
     * Constructor for objects of class Machine
     */
    public Machine()
    {

    }

    public int getLatitude(){
        return position.getLatitude();
    }

    public int getLongitude(){
        return position.getLongitude();
    }

    public void setLatitude(int  getLatitude){ ;
        position.setLatitude(getLatitude);
    }
}