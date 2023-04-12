import java.util.Arrays;

public class State {
    private static final char[] sigma = { '0', '1' }; // set of alphabet symbols
    private State[] zeroTransitions;
    private State[] oneTransitions;
    private State[] epsilonTransitions;
    private boolean isQ0; // initial state
    private boolean isF; // set of accepting states

    public State(boolean isQ0, boolean isF) {
        this.isQ0 = isQ0;
        this.isF = isF;
    }

    public char[] getSigma() {
        return sigma;
    }

    public State[] getZeroTransitions() {
        return zeroTransitions;
    }

    public State[] getOneTransitions() {
        return oneTransitions;
    }

    public State[] getEpsilonTransitions() {
        return epsilonTransitions;
    }

    public boolean getQ0() {
        return isQ0;
    }

    public boolean getF() {
        return isF;
    }

    public void setZeroTransitions(State[] zeroTransitions) {
        this.zeroTransitions = zeroTransitions;
    }

    public void setOneTransitions(State[] oneTransitions) {
        this.oneTransitions = oneTransitions;
    }

    public void setEpsilonTransitions(State[] epsilonTransitions) {
        this.epsilonTransitions = epsilonTransitions;
    }

    public String toString(State state) {
        return "Zero Transitions: " + Arrays.toString(zeroTransitions) + " One Transitions: "
                + Arrays.toString(oneTransitions) + " Epsilon Transitions: "
                + Arrays.toString(epsilonTransitions) + " isQ0: " + isQ0 + " isF: " + isF;
    }
}
