package mastermind.controller;

import mastermind.model.Attempt;
import mastermind.model.Color;
import mastermind.model.Error;
import mastermind.model.Game;
import mastermind.model.ProposedCombination;

import java.util.ArrayList;
import java.util.List;

public class ProposeCombinationController extends Controller {

    public ProposeCombinationController(Game game) {
        super(game);
    }

    public int getAttemptsCount() {
        return game.getAttemptsCount();
    }

    public List<Attempt> getPlayerAttempts() {
        return game.getPlayedAttempts();
    }

    public void playCombination(ProposedCombination proposedCombination) {
        game.playCombination(proposedCombination);
    }

    public boolean isContinuePlaying() {
        return game.isContinuePlaying();
    }

    public boolean isWinnerGame() {
        return game.isWinnerGame();
    }

    public Error checkIfValidProposedCombination(String proposedCombinationCode) {
        if (proposedCombinationCode.isBlank()) {
            return Error.WRONG_PROPOSED_COMBINATION_LENGTH;
        }
        if (proposedCombinationCode.length() != ProposedCombination.COMBINATION_SIZE) {
            return Error.WRONG_PROPOSED_COMBINATION_LENGTH;
        }
        if (!isValidColors(proposedCombinationCode)) {
            return Error.WRONG_PROPOSED_COMBINATION_COLORS;
        }
        if (duplicateColors(proposedCombinationCode)) {
            return Error.DUPLICATE_PROPOSED_COMBINATION_COLORS;
        }
        return Error.NULL;
    }

    private boolean duplicateColors(String proposedCombinationCode) {
        List<Character> uniqueColors = new ArrayList<>();
        for (char colorCode : proposedCombinationCode.toCharArray()) {
            if (uniqueColors.contains(colorCode)) {
                return true;
            }
            uniqueColors.add(colorCode);
        }
        return false;
    }

    private boolean isValidColors(String proposedCombination) {
        for (char colorCode : proposedCombination.toCharArray()) {
            if (!Color.isValidColor(colorCode)) {
                return false;
            }
        }
        return true;
    }
}
