package mastermind.view;

import mastermind.controller.ProposeCombinationController;
import mastermind.controller.StartController;

public class ConsoleView extends View {

    private final GameView gameView;
    private final ResumeView resumeView;
    private final StartView startView;

    public ConsoleView(StartController startController, ProposeCombinationController proposeCombinationController) {
        super(startController, resumeController, proposeCombinationController);
        this.startView = new StartView(startController);
        this.resumeView = new ResumeView(resumeController);
        this.gameView = new GameView(proposeCombinationController);
    }

    @Override
    protected void start() {
        this.startView.start();
    }

    @Override
    protected void play() {
        gameView.interact();
    }

    @Override
    protected boolean isEndGame() {
        return gameView.isEndGame();
    }

    @Override
    protected boolean isResume() {
        return resumeView.isResume();
    }
}
