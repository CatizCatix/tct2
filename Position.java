public class Position
{
    // instance variables - replace the example below with your own
    private int longitude;
    private int latitude;

    /**
     * Constructor for objects of class Position
     */
    public Position()
    {

    }

    public int getLongitude(){
        return this.longitude;
    }

    public int getLatitude(){
        return this.latitude;
    }

    public void setLatitude(int latitude){
        this.latitude = latitude;
    }
}
