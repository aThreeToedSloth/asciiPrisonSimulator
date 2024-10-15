package Managers;

import Entities.DeathBlock;
import Entities.Entity;
import Entities.Player;

public class MovementManager {

    MapManager mapManager;
    PlayerManager playerManager;
    BlockManager blockManager;
    Renderer renderer;

    private Entity temp;

    public MovementManager(MapManager mapManager, PlayerManager playerManager, BlockManager blockManager, Renderer renderer){
        this.mapManager = mapManager;
        this.playerManager = playerManager;
        this.blockManager = blockManager;
        this.renderer = renderer;
    }

    //Assumes that when the game starts, the player is standing on a floor block
    public void setup(){
        temp = blockManager.getFloor();
    }

    //Moves the player's position on the grid
    //If the player tries to walk into an entity with collision, they don't move and a warning message is sent
    //If the player walks into an entity without collision, it replaces it's position on the grid and the entity is placed in the temp variable.
    public void playerMove(Controls controls, Player player){
        //Ensure that the player is allowed to be controlled before controlling them.
        if(!player.getControllable()){
            return;
        }
        switch (controls){
            case UP:
                if ((mapManager.getGrid())[player.getCoordH() - 1][player.getCoordL()].getCollision()) {
                    renderer.displayText(warningMessage((mapManager.getGrid())[player.getCoordH() - 1][player.getCoordL()].getName()));
                }
                else{
                    (mapManager.getGrid())[player.getCoordH()][player.getCoordL()] = temp;
                    temp = (mapManager.getGrid())[player.getCoordH() - 1][player.getCoordL()];
                    mapManager.spawnPlayer(player, player.getCoordH() - 1, player.getCoordL());
                    renderer.displayText("");
                }
                break;
            case DOWN:
                if ((mapManager.getGrid())[player.getCoordH() + 1][player.getCoordL()].getCollision()) {
                    renderer.displayText(warningMessage((mapManager.getGrid())[player.getCoordH() + 1][player.getCoordL()].getName()));
                }
                else{
                    (mapManager.getGrid())[player.getCoordH()][player.getCoordL()] = temp;
                    temp = (mapManager.getGrid())[player.getCoordH() + 1][player.getCoordL()];
                    mapManager.spawnPlayer(player, player.getCoordH() + 1, player.getCoordL());
                    renderer.displayText("");
                }
                break;
            case LEFT:
                if ((mapManager.getGrid())[player.getCoordH()][player.getCoordL() - 1].getCollision()) {
                    renderer.displayText(warningMessage((mapManager.getGrid())[player.getCoordH()][player.getCoordL() - 1].getName()));
                }
                else{
                    (mapManager.getGrid())[player.getCoordH()][player.getCoordL()] = temp;
                    temp = (mapManager.getGrid())[player.getCoordH()][player.getCoordL() - 1];
                    mapManager.spawnPlayer(player, player.getCoordH(), player.getCoordL() - 1);
                    renderer.displayText("");
                }
                break;
            case RIGHT:
                if ((mapManager.getGrid())[player.getCoordH()][player.getCoordL() + 1].getCollision()) {
                    renderer.displayText(warningMessage((mapManager.getGrid())[player.getCoordH()][player.getCoordL() + 1].getName()));
                }
                else {
                    (mapManager.getGrid())[player.getCoordH()][player.getCoordL()] = temp;
                    temp = (mapManager.getGrid())[player.getCoordH()][player.getCoordL() + 1];
                    mapManager.spawnPlayer(player, player.getCoordH(), player.getCoordL()+ 1);
                    renderer.displayText("");
                }
                break;
        }
        //The player can walk onto the fireplace, but they will die.
        if(temp instanceof DeathBlock){
            ((DeathBlock) temp).onTouch(player ,"You walked into a fireplace and died - Game Over");
        }
    }

    private String warningMessage(String entity){
        return String.format("<html>You are trying to run into a %s. You can't do that!</html>", entity);
    }
}
