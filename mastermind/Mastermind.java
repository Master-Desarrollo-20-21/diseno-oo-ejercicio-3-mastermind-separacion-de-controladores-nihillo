package mastermind;


import mastermind.controller.ProposeCombinationController;
import mastermind.controller.StartController;
import mastermind.model.Game;
import mastermind.view.View;
import mastermind.view.ConsoleView;

public abstract class Mastermind {

    private final Game game;
    private final View view;
    private final StartController startController;
    private final ProposeCombinationController proposeCombinationController;

    protected Mastermind() {
        this.game = new Game();
        this.startController = new StartController(game);
        this.proposeCombinationController = new ProposeCombinationController(game);
        this.view = this.createView(startController, resumeController, proposeCombinationController);
    }

    protected View createView(StartController startController, ProposeCombinationController proposeCombinationController) {
        return new ConsoleView(startController, resumeController, proposeCombinationController);
    }

    protected void play() {
        this.view.interact();
    }
}