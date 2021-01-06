package mastermind.model;

public class Attempt {

    private final ProposedCombination proposedCombination;
    private final SecretCombination secretCombination;

    public Attempt(ProposedCombination proposedCombination, SecretCombination secretCombination) {
        this.proposedCombination = proposedCombination;
        this.secretCombination = secretCombination;
    }

    public boolean isWinnerAttempt() {
        return this.secretCombination.isCorrectCombination(this.proposedCombination);
    }

    public int getWhites() {
        return this.secretCombination.getWhites(this.proposedCombination);
    }

    public int getBlacks() {
        return this.secretCombination.getBlacks(this.proposedCombination);
    }

    public String getProposedCombinationCode() {
        return this.proposedCombination.getColorsCode();
    }

}
