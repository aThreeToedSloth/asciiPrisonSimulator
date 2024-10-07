package Managers;

import Entities.Block;
import Entities.Entity;
import Entities.Player;

public class MapManager {

    PlayerManager playerManager;
    BlockManager blockManager;
    public MovementManager movementManager;

    public MapManager(PlayerManager playerManager, BlockManager blockManager){
        this.playerManager = playerManager;
        this.blockManager = blockManager;
    }

    private final int MAP_HEIGHT = 10;
    private final int MAP_WIDTH = 10;

    private Entity[][] grid = new Entity[MAP_HEIGHT][MAP_WIDTH];

    public void setup(){
        movementManager = new MovementManager(this, playerManager, blockManager);
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

    public void drawMap(){
        for(int i = 0; i < MAP_HEIGHT; i++){
            for(int j = 0;j < MAP_WIDTH; j++){
                System.out.print(grid[i][j].getTexture());
            }
            System.out.println();
        }
    }

    public void spawnPlayer(Player player, int h, int l){
        grid[h][l] = player;
        movementManager.setPlayerCoords(h,l);
    }

    public Entity[][] getGrid(){
        return this.grid;
    }
}