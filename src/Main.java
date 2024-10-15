import Entities.Player;
import Managers.*;
import Managers.Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    static PlayerManager playerManager;
    static BlockManager blockManager;
    static MapManager mapManager;

    //Listens for key presses, puts it into the gameLoop method as an argument.
    static KeyListener listener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            gameLoop(mapManager, keyEvent, playerManager.getPlayer());
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    };

    //Initialises a number of managers, then calls methods to set up the game.
    public static void main(String[] args) {

        Renderer renderer = new Renderer(listener);
        renderer.createFrame();
        playerManager = new PlayerManager();
        blockManager = new BlockManager(renderer, playerManager);
        mapManager = new MapManager(playerManager, blockManager, renderer);

        setup(playerManager, blockManager, mapManager);
        createMap(playerManager, blockManager, mapManager);
    }

    //Calls methods in the Block and Player managers to initialise entities.
    public static void setup(PlayerManager playerManager, BlockManager blockManager, MapManager mapManager){

        blockManager.initializeBlocks();
        playerManager.initializePlayer();

        mapManager.setup();

    }

    //Calls methods from the Map manager to build the map.
    public static void createMap(PlayerManager playerManager, BlockManager blockManager, MapManager mapManager){
        mapManager.placeFlooring(blockManager.getFloor());
        mapManager.placeOuterWalls(blockManager.getWall());
        mapManager.placeMetalBars();
        mapManager.placeFire(1,8);
        mapManager.spawnPlayer(playerManager.getPlayer(), 5, 5);
        mapManager.drawMap();
    }

    //Decides what to do when certain keys are pressed. Uses the Movement manager.
    //Redraws the grid after the player moves.
    public static void gameLoop(MapManager mapManager, KeyEvent e, Player p){
        switch (e.getKeyChar()){
            case 'w':
                mapManager.movementManager.playerMove(Controls.UP, p);
                break;
            case 'a':
                mapManager.movementManager.playerMove(Controls.LEFT, p);
                break;
            case 's':
                mapManager.movementManager.playerMove(Controls.DOWN, p);
                break;
            case 'd':
                mapManager.movementManager.playerMove(Controls.RIGHT, p);
                break;
        }
        mapManager.drawMap();
    }
}