public class Main {
    public static void main(String[] args) throws Exception {
        State q0 = new State(true, false);
        State q1 = new State(false, false);
        State q2 = new State(false, true);

        q0.setZeroTransitions(new State[]{q0});
        q0.setOneTransitions(null);
        q0.setEpsilonTransitions(new State[]{q1});

        q1.setZeroTransitions(null);
        q1.setOneTransitions(new State[]{q1});
        q1.setEpsilonTransitions(new State[]{q2});

        q2.setZeroTransitions(new State[]{q2});
        q2.setOneTransitions(null);
        q2.setEpsilonTransitions(null);

        State[] states = new State[3];
        states[0] = q0;
        states[1] = q1;
        states[2] = q2;

        NFA nfa = new NFA(states, "010");

        nfa.Compute();
    }
}