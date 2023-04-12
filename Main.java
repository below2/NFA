public class Main {
    public static void main(String[] args) {
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

        // q0 = new State(new State[]{q0}, null, new State[]{q1}, true, false);
        // q1 = new State(null, new State[]{q1}, new State[]{q2}, false, false);
        // q2 = new State(new State[]{q2}, null, null, false, true);

        for (State state : q0.getEpsilonTransitions()) {
            System.out.println(state.toString(state));
        }
    }
}