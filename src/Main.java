import Entities.Player;
import Managers.*;
import Managers.Renderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    PlayerManager playerManager;
    BlockManager blockManager;
    MapManager mapManager;

    //Listens for key presses, puts it into the gameLoop method as an argument.
    KeyListener listener = new KeyListener() {
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
        Main main = new Main();

        main.setup();
    }

    //Calls methods in the Block and Player managers to initialise entities.
    public void setup(){

        Renderer renderer = new Renderer(listener);
        renderer.createFrame();
        playerManager = new PlayerManager();
        blockManager = new BlockManager(renderer, playerManager);
        mapManager = new MapManager(playerManager, blockManager, renderer);

        blockManager.initializeBlocks();
        playerManager.initializePlayer();

        createMap(playerManager, blockManager, mapManager);

        mapManager.setup();

    }

    //Calls methods from the Map manager to build the map.
    public void createMap(PlayerManager playerManager, BlockManager blockManager, MapManager mapManager){
        mapManager.placeFlooring(blockManager.getFloor());
        mapManager.placeOuterWalls(blockManager.getWall());
        mapManager.placeMetalBars();
        mapManager.placeFire(1,8);
        mapManager.spawnPlayer(playerManager.getPlayer(), 5, 5);
        mapManager.drawMap();
    }

    //Decides what to do when certain keys are pressed. Uses the Movement manager.
    //Redraws the grid after the player moves.
    public void gameLoop(MapManager mapManager, KeyEvent e, Player p){
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