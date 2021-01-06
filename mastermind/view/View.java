package mastermind.view;

import mastermind.controller.ProposeCombinationController;
import mastermind.controller.StartController;

public abstract class View {

    protected StartController startController;
    protected ProposeCombinationController proposeCombinationController;

    protected View(StartController startController, ProposeCombinationController proposeCombinationController) {
        this.startController = startController;
        this.resumeController = resumeController;
        this.proposeCombinationController = proposeCombinationController;
    }

    public void interact() {
        do {
            this.start();
            do {
                this.play();
            } while (!this.isEndGame());
        } while (this.isResume());
    }

    protected abstract void start();

    protected abstract void play();

    protected abstract boolean isEndGame();

    protected abstract boolean isResume();
}
