package Entities;

public class Player extends Entity{
    //Can the user control the player?
    private boolean controllable;
    private int coordH;
    private  int coordL;

    //Get and set whether the player can be controlled?
    public boolean getControllable(){
        return controllable;
    }
    public void setControllable(boolean controllable){
        this.controllable = controllable;
    }

    public int getCoordH(){
        return  coordH;
    }

    public void setCoordH(int coordH){
        this.coordH = coordH;
    }

    public int getCoordL(){
        return  coordL;
    }

    public void setCoordL(int coordL){
        this.coordL = coordL;
    }
}
