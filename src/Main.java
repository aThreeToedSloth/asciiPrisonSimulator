import Managers.BlockManager;
import Managers.Controls;
import Managers.MapManager;
import Managers.PlayerManager;

import java.util.Scanner;

public class Main {

    static PlayerManager playerManager;
    static BlockManager blockManager;
    static MapManager mapManager;
    public static void main(String[] args) {
        initializeManagers();
        createMap();
        gameLoop();
    }

    public static void initializeManagers(){
        playerManager = new PlayerManager();
        blockManager = new BlockManager();
        mapManager = new MapManager(playerManager, blockManager);

        blockManager.initializeBlocks();
        playerManager.initializePlayer();

        mapManager.setup();

    }

    public static void createMap(){

        mapManager.placeFlooring(blockManager.getFloor());
        mapManager.placeOuterWalls(blockManager.getWall());
        mapManager.spawnPlayer(playerManager.getPlayer(), 5, 5);
        mapManager.drawMap();
    }

    public static void gameLoop(){
        Scanner scanner = new Scanner(System.in);
        String key = "";
        while(!key.equals("q")){
            key = scanner.next();

            switch (key){
                case "w":
                    mapManager.movementManager.playerMove(Controls.UP);
                    break;
                case "a":
                    mapManager.movementManager.playerMove(Controls.LEFT);
                    break;
                case "s":
                    mapManager.movementManager.playerMove(Controls.DOWN);
                    break;
                case "d":
                    mapManager.movementManager.playerMove(Controls.RIGHT);
                    break;
            }
            mapManager.drawMap();

        }
    }
}