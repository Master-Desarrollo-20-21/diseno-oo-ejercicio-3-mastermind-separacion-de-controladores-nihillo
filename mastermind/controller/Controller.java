package mastermind.controller;

import mastermind.model.Game;

public abstract class Controller {

    protected Game game;

    protected Controller(Game game) {
        this.game = game;
    }


}
