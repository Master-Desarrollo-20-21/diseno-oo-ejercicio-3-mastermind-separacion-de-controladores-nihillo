package mastermind.view;

import mastermind.controller.ProposeCombinationController;
import mastermind.model.Error;
import mastermind.model.ProposedCombination;
import mastermind.utils.Console;

import static mastermind.view.Message.PROPOSE_COMBINATION;

public class ProposedCombinationView {

    private final ProposeCombinationController proposeCombinationController;

    public ProposedCombinationView(ProposeCombinationController proposeCombinationController) {
        this.proposeCombinationController = proposeCombinationController;
    }

    public ProposedCombination readProposedCombination() {
        String proposedCombinationCode = "";
        Error error;
        do {
            proposedCombinationCode = Console.getInstance().readString(PROPOSE_COMBINATION.getMessage());
            Console.getInstance().writeln();
            Console.getInstance().writeln();
            error = proposeCombinationController.checkIfValidProposedCombination(proposedCombinationCode);
            ErrorView.of(error).writeln();

        } while (!error.isNull());
        return new ProposedCombination(proposedCombinationCode.toCharArray());
    }


}
