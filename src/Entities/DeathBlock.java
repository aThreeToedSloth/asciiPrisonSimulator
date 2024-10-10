package Entities;

import Managers.BlockManager;
import Managers.PlayerManager;
import Managers.Renderer;

public class DeathBlock extends Block{

    private Renderer renderer;
    private BlockManager blockManager;
    private PlayerManager playerManager;

    public DeathBlock (Renderer renderer, BlockManager blockManager, PlayerManager playerManager){
        this.renderer = renderer;
        this.blockManager = blockManager;
        this.playerManager = playerManager;
    }

    public void onTouch(Player p, String message){
        renderer.displayText(message);
        playerManager.updatePlayer(p, 'X', true, false);
    }
}
