package mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int MAX_ATTEMPTS = 10;

    private SecretCombination secretCombination;
    private Attempt currentAttempt;
    private List<Attempt> playedAttempts;

    public Game() {
        playedAttempts = new ArrayList<>();
        secretCombination = new SecretCombination();
    }

    public void playCombination(ProposedCombination proposedCombination) {
        currentAttempt = new Attempt(proposedCombination, secretCombination);
        playedAttempts.add(currentAttempt);
    }

    public boolean isContinuePlaying() {
        return playedAttempts.size() < MAX_ATTEMPTS && !currentAttempt.isWinnerAttempt();
    }

    public boolean isWinnerGame() {
        return currentAttempt.isWinnerAttempt();
    }

    public int getAttemptsCount() {
        return playedAttempts.size();
    }

    public List<Attempt> getPlayedAttempts() {
        return playedAttempts;
    }

    public void init() {
        this.playedAttempts = new ArrayList<>();
        this.currentAttempt = null;
        this.secretCombination = new SecretCombination();
    }
}
