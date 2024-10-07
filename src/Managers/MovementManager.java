package Managers;

import Entities.Entity;

public class MovementManager {

    MapManager mapManager;
    PlayerManager playerManager;
    BlockManager blockManager;

    private int playerH;
    private int playerL;

    private Entity temp;

    public MovementManager(MapManager mapManager, PlayerManager playerManager, BlockManager blockManager){
        this.mapManager = mapManager;
        this.playerManager = playerManager;
        this.blockManager = blockManager;
    }

    public void setup(){
        temp = blockManager.getFloor();
    }

    public void playerMove(Controls controls){
        switch (controls){
            case UP:
                if (!(mapManager.getGrid())[playerH - 1][playerL].getCollision()) {
                    (mapManager.getGrid())[playerH][playerL] = temp;
                    temp = (mapManager.getGrid())[playerH - 1][playerL];
                    mapManager.spawnPlayer(playerManager.getPlayer(), playerH - 1, playerL);
                }
                break;
            case DOWN:
                if (!(mapManager.getGrid())[playerH + 1][playerL].getCollision()) {
                    (mapManager.getGrid())[playerH][playerL] = temp;
                    temp = (mapManager.getGrid())[playerH + 1][playerL];
                    mapManager.spawnPlayer(playerManager.getPlayer(), playerH + 1, playerL);
                }
                break;
            case LEFT:
                if (!(mapManager.getGrid())[playerH][playerL - 1].getCollision()) {
                    (mapManager.getGrid())[playerH][playerL] = temp;
                    temp = (mapManager.getGrid())[playerH][playerL - 1];
                    mapManager.spawnPlayer(playerManager.getPlayer(), playerH, playerL - 1);
                }
                break;
            case RIGHT:
                if (!(mapManager.getGrid())[playerH][playerL + 1].getCollision()) {
                    (mapManager.getGrid())[playerH][playerL] = temp;
                    temp = (mapManager.getGrid())[playerH][playerL + 1];
                    mapManager.spawnPlayer(playerManager.getPlayer(), playerH, playerL + 1);
                }
                break;
        }
    }

    public void setPlayerCoords(int h, int l){
        this.playerH = h;
        this.playerL = l;
    }
}
