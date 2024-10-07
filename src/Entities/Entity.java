package Entities;

public class Entity {
    //Unique ID for the entity
    private int id;
    //Name of the entity
    private String name;
    //What character is the entity represented by?
    private char texture;
    //Does the entity have collision?
    private boolean collision;

    //Get and set ID
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    //Get and set name
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    //Get and set texture
    public char getTexture(){
        return this.texture;
    }
    public void setTexture(char texture){
        this.texture = texture;
    }

    //Get and set collision
    public boolean getCollision(){
        return this.collision;
    }
    public void setCollision(boolean collision){
        this.collision = collision;
    }
}
