package Entities;

public class Player extends Entity{
    //Can the user control the player?
    private boolean controllable;

    //Get and set whether the player can be controlled?
    public boolean getControllable(){
        return controllable;
    }
    public void setControllable(boolean controllable){
        this.controllable = controllable;
    }
}
