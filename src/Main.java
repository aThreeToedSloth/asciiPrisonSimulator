import Managers.*;
import Managers.Renderer;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Renderer renderer = new Renderer();
        renderer.render();
        PlayerManager playerManager = new PlayerManager();
        BlockManager blockManager = new BlockManager();
        MapManager mapManager = new MapManager(playerManager, blockManager, renderer);


        setup(playerManager, blockManager, mapManager);
        createMap(playerManager, blockManager, mapManager);

        gameLoop(playerManager, blockManager, mapManager);


    }

    public static void setup(PlayerManager playerManager, BlockManager blockManager, MapManager mapManager){

        blockManager.initializeBlocks();
        playerManager.initializePlayer();

        mapManager.setup();

    }

    public static void createMap(PlayerManager playerManager, BlockManager blockManager, MapManager mapManager){

        mapManager.placeFlooring(blockManager.getFloor());
        mapManager.placeOuterWalls(blockManager.getWall());
        mapManager.spawnPlayer(playerManager.getPlayer(), 5, 5);
        mapManager.drawMap();
    }

    public static void gameLoop(PlayerManager playerManager, BlockManager blockManager, MapManager mapManager){
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