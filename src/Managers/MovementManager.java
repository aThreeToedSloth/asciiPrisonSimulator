package Managers;

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

    public void setup(){
        temp = blockManager.getFloor();
    }

    public void playerMove(Controls controls, Player player){
        switch (controls){
            case UP:
                if ((mapManager.getGrid())[player.getCoordH() - 1][player.getCoordL()].getCollision()) {
                    renderer.displayText(warningMessage((mapManager.getGrid())[player.getCoordH() - 1][player.getCoordL()].getName()));
                }
                else{
                    (mapManager.getGrid())[player.getCoordH()][player.getCoordL()] = temp;
                    temp = (mapManager.getGrid())[player.getCoordH() - 1][player.getCoordL()];
                    mapManager.spawnPlayer(player, player.getCoordH() - 1, player.getCoordL());
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
                }
                break;
        }
    }

    private String warningMessage(String entity){
        return String.format("<html>You are trying to run into a %s. You can't do that!</html>", entity);
    }
}
