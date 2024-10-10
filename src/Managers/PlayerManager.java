package Managers;

import Entities.Player;

public class PlayerManager {

    private Player player;

    public void initializePlayer(){
        player = createPlayer(2, "Player", '@', true, true);
    }

    private Player createPlayer(int id, String name, char texture, boolean collision, boolean controllable){
        Player player = new Player();
        player.setId(id);
        player.setName(name);
        player.setTexture(texture);
        player.setCollision(collision);
        player.setControllable(controllable);
        return  player;
    }

    public void setPlayerCoords(Player player, int coordH, int coordL){
        player.setCoordH(coordH);
        player.setCoordL(coordL);
    }

    public Player getPlayer(){
        return this.player;
    }
}
