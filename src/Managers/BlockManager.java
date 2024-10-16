package Managers;

import Entities.Block;
import Entities.DeathBlock;

public class BlockManager {
    /*----Blocks-used-in-the-game----*/
    private Block floor;
    private Block wall;
    private Block metalBar;
    private DeathBlock fire;
    /*-------------------------------*/

    private Renderer renderer;
    private PlayerManager playerManager;

    public BlockManager(Renderer renderer, PlayerManager playerManager){
        this.renderer = renderer;
        this.playerManager = playerManager;
    }

    //Initializes the Blocks
    public void initializeBlocks(){
        floor = createBlock(0, "Floor", '=', false);
        wall = createBlock(1, "Wall", '+', true);
        metalBar = createBlock(3, "Metal Bar", '`', true);
        fire = createDeathBlock(4, "Fire", '#', false);
    }

    //sets data for the blocks
    private Block createBlock(int id, String name, char texture, boolean collision){
        Block block = new Block();
        block.setId(id);
        block.setName(name);
        block.setTexture(texture);
        block.setCollision(collision);
        return  block;
    }

    //sets data for death blocks (death blocks kill players when touched)
    private DeathBlock createDeathBlock(int id, String name, char texture, boolean collision){
        DeathBlock block = new DeathBlock(this.renderer, this, playerManager);
        block.setId(id);
        block.setName(name);
        block.setTexture(texture);
        block.setCollision(collision);
        return block;
    }

    //Getters and setters
    public Block getFloor(){
        return this.floor;
    }

    public Block getWall(){
        return this.wall;
    }
    public Block getFire(){
        return this.fire;
    }
    public Block getMetalBar(){
        return this.metalBar;
    }
}
