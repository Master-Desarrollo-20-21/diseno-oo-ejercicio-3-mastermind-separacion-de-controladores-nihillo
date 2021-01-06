package mastermind.view;

import mastermind.controller.StartController;
import mastermind.utils.Console;

import static mastermind.view.Message.TITLE;

public class StartView {

    private final StartController startController;

    public StartView(StartController startController) {
        this.startController = startController;
    }

    public void start() {
        startController.initGame();
        Console.getInstance().write(TITLE.getMessage());
    }
}
