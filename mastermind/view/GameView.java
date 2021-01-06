package mastermind.view;


import mastermind.controller.ProposeCombinationController;
import mastermind.model.Attempt;
import mastermind.model.ProposedCombination;
import mastermind.utils.Console;


public class GameView {

    private final ProposedCombinationView proposedCombinationView;
    private final ProposeCombinationController proposeCombinationController;

    public GameView(ProposeCombinationController proposeCombinationController) {
        this.proposedCombinationView = new ProposedCombinationView(proposeCombinationController);
        this.proposeCombinationController = proposeCombinationController;
    }

    public void interact() {
        do {
            Console.getInstance().writeln(String.format(Message.ATTEMPTS_COUNT.getMessage(), proposeCombinationController.getAttemptsCount()));
            Console.getInstance().writeln(Message.SECRET_COMBINATION_HIDDEN.getMessage());
            for (Attempt attempt : proposeCombinationController.getPlayerAttempts()) {
                Console.getInstance()
                        .writeln(String.format(Message.ATTEMPT.getMessage(), attempt.getProposedCombinationCode(), attempt.getBlacks(), attempt.getWhites()));
            }
            ProposedCombination proposedCombination = proposedCombinationView.readProposedCombination();
            proposeCombinationController.playCombination(proposedCombination);
        } while (proposeCombinationController.isContinuePlaying());
        if (proposeCombinationController.isWinnerGame()) {
            Console.getInstance().writeln(Message.WIN_MESSAGE.getMessage());
        } else {
            Console.getInstance().writeln(Message.LOST_MESSAGE.getMessage());
        }
    }

    public boolean isEndGame() {
        return !proposeCombinationController.isContinuePlaying();
    }
}
