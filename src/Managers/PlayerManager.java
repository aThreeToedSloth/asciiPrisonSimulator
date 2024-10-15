package Managers;

import Entities.Player;

public class PlayerManager {

    private Player player;

    //Initializes the player
    public void initializePlayer(){
        player = createPlayer(2, "Player", '@', true, true);
    }

    //Sets data for an instance of the player object;
    private Player createPlayer(int id, String name, char texture, boolean collision, boolean controllable){
        Player player = new Player();
        player.setId(id);
        player.setName(name);
        player.setTexture(texture);
        player.setCollision(collision);
        player.setControllable(controllable);
        return  player;
    }

    //Updates the data of a player
    public void updatePlayer(Player p, char texture, boolean collision, boolean controllable){
        p.setTexture(texture);
        p.setCollision(collision);
        p.setControllable(controllable);
    }

    //sets the coordinates of the player
    public void setPlayerCoords(Player player, int coordH, int coordL){
        player.setCoordH(coordH);
        player.setCoordL(coordL);
    }

    public Player getPlayer(){
        return this.player;
    }
}
