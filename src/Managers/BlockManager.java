package Managers;

import Entities.Block;

public class BlockManager {
    private Block floor;
    private Block wall;

    public void initializeBlocks(){
        floor = createBlock(0, "Floor", '=', false);
        wall = createBlock(1, "Wall", '+', true);
    }

    private Block createBlock(int id, String name, char texture, boolean collision){
        Block block = new Block();
        block.setId(id);
        block.setName(name);
        block.setTexture(texture);
        block.setCollision(collision);
        return  block;
    }

    public Block getFloor(){
        return this.floor;
    }

    public Block getWall(){
        return this.wall;
    }
}
