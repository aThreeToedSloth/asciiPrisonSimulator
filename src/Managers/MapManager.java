package Managers;

import Entities.Block;
import Entities.Entity;
import Entities.Player;

public class MapManager {

    PlayerManager playerManager;
    BlockManager blockManager;
    Renderer renderer;
    public MovementManager movementManager;


    public MapManager(PlayerManager playerManager, BlockManager blockManager, Renderer renderer){
        this.playerManager = playerManager;
        this.blockManager = blockManager;
        this.renderer = renderer;
    }

    private final int MAP_HEIGHT = 10;
    private final int MAP_WIDTH = 10;

    private Entity[][] grid = new Entity[MAP_HEIGHT][MAP_WIDTH];

    public void setup(){
        movementManager = new MovementManager(this, playerManager, blockManager, renderer);
        movementManager.setup();
    }

    public void placeFlooring(Block block){
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0;j < MAP_WIDTH; j++){
                grid[i][j] = block;
            }
        }
    }

    public void placeOuterWalls(Block block){
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0;j < MAP_WIDTH; j++){
                if(i == 0 || i == 9 || j == 0 || j == 9){
                    grid[i][j] = block;
                }
            }
        }
    }

    public  void placeMetalBars(){
        for(int i = 0; i < MAP_WIDTH; i++){
            grid[MAP_HEIGHT - 1][i] = blockManager.getMetalBar();
        }
    }

    public void placeFire(int h, int l){
        grid[h][l] = blockManager.getFire();
    }

    public void drawMap(){
        renderer.clearGrid();
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0;j < MAP_WIDTH; j++){
                renderer.updateGrid(String.valueOf(grid[i][j].getTexture()));
            }
            renderer.updateGrid("<br/>");
        }
    }

    public Player spawnPlayer(Player player, int h, int l){
        grid[h][l] = player;
        playerManager.setPlayerCoords(player, h, l);
        return player;
    }

    public Entity[][] getGrid(){
        return this.grid;
    }
}