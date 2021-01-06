package mastermind.controller;

import mastermind.model.Game;

public class StartController extends Controller {


    public StartController(Game game) {
        super(game);
    }

    public void initGame() {
        game.init();
    }
}
