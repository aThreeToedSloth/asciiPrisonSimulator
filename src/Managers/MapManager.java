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

    //creates and sets up the Movement manager
    public void setup(){
        movementManager = new MovementManager(this, playerManager, blockManager, renderer);
        movementManager.setup();
    }

    //Creates a grid of a certain block
    public void placeFlooring(Block block){
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0;j < MAP_WIDTH; j++){
                grid[i][j] = block;
            }
        }
    }


    //Places blocks on the edges of the grid
    public void placeOuterWalls(Block block){
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0;j < MAP_WIDTH; j++){
                if(i == 0 || i == MAP_HEIGHT - 1 || j == 0 || j == MAP_WIDTH - 1){
                    grid[i][j] = block;
                }
            }
        }
    }

    //Places metal bars along the bottom of the grid
    public  void placeMetalBars(){
        for(int i = 0; i < MAP_WIDTH; i++){
            grid[MAP_HEIGHT - 1][i] = blockManager.getMetalBar();
        }
    }

    //Places a fire at a coordinate
    public void placeFire(int h, int l){
        grid[h][l] = blockManager.getFire();
    }

    //Uses the renderer class to draw the map
    //First, clears the grid, then loop through each position on the grid and draws it onto the screen.
    public void drawMap(){
        renderer.clearGrid();
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0;j < MAP_WIDTH; j++){
                renderer.updateGrid(String.valueOf(grid[i][j].getTexture()));
            }
            renderer.updateGrid("<br/>");
        }
    }

    //Places a player on the grid as a specified coordinate
    public void spawnPlayer(Player player, int h, int l){
        grid[h][l] = player;
        playerManager.setPlayerCoords(player, h, l);
    }

    public Entity[][] getGrid(){
        return this.grid;
    }
}