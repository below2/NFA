public class NFA {
    private State[] states;
    private String input;
    private State startState;
    private State currentState;
    private char currentInput;
    private State[] currentTransitions;
    private int inputPointer;

    public NFA(State[] states, String input) {
        this.states = states;
        this.input = input;
    }

    public void Compute() throws Exception {
        init();

        for (int i = 0; i < input.length(); i++) {
            currentInput = input.charAt(i);
            currentTransitions = null;

            if (currentInput == '0') {
                currentTransitions = currentState.getZeroTransitions();
                if (currentTransitions == null) {
                    currentTransitions = currentState.getEpsilonTransitions();
                    if (currentTransitions == null && currentState.getF() && i == input.length() - 1) {
                        System.out.println("Rejected");
                    } else {
                        System.out.println("Rejected? : curentInput = 0 but no 0 or epsilon transitions");
                    }
                    transition();
                }
                inputPointer++;
                transition();
            } else if (currentInput == '1') {
                currentTransitions = currentState.getOneTransitions();
                if (currentTransitions == null) {
                    currentTransitions = currentState.getEpsilonTransitions();
                    if (currentTransitions == null) {
                        System.out.println("Rejected? : curentInput = 1 but no 1 or epsilon transitions");
                    }
                    transition();
                }
                inputPointer++;
                transition();
            }
        }
    }

    public void transition() throws Exception {
        for (int i = 0; i < currentTransitions.length; i++) {
            if (inputPointer >= input.length()) {
                if (currentState.getF() && currentState.getEpsilonTransitions() == null) {
                    System.out.println("ACCEPT");
                    return;
                } // TODO: check for case where input is exhausted but nfa may have an epsilon
                  // link to an acc state
            } else {
                currentInput = input.charAt(inputPointer);
                currentState = currentTransitions[i];

                if (currentInput == '0') {
                    currentTransitions = currentState.getZeroTransitions();
                    if (currentTransitions == null) {
                        currentTransitions = currentState.getEpsilonTransitions();
                        if (currentTransitions == null) {
                            System.out.println("Rejected? : curentInput = 0 but no 0 or epsilon transitions");
                        }
                        transition();
                    }
                    inputPointer++;
                    transition();
                } else if (currentInput == '1') {
                    currentTransitions = currentState.getOneTransitions();
                    if (currentTransitions == null) {
                        currentTransitions = currentState.getEpsilonTransitions();
                        if (currentTransitions == null) {
                            System.out.println("Rejected? : curentInput = 1 but no 1 or epsilon transitions");
                        }
                        transition();
                    }
                    inputPointer++;
                    transition();
                }
            }
        }
    }

    // for (int i = 0; i < input.length(); i++) { // "010"
    // char currentInput = input.charAt(inputPointer); // '0'
    // State[] currentTransitions = null;

    // if (currentInput == '0') { // true
    // currentTransitions = currentState.getZeroTransitions(); // {q0}
    // if (currentTransitions == null) {
    // currentTransitions = currentState.getEpsilonTransitions();
    // if (currentTransitions == null) {
    // System.out.println("Rejected? : curentInput = 0 but no 0 or epsilon
    // transitions");
    // }
    // }
    // } else if (currentInput == '1') {
    // currentTransitions = currentState.getOneTransitions();
    // if (currentTransitions == null) {
    // currentTransitions = currentState.getEpsilonTransitions();
    // if (currentTransitions == null) {
    // System.out.println("Rejected? : curentInput = 1 but no 1 or epsilon
    // transitions");
    // }
    // }
    // }

    // if (currentTransitions != null) { // true
    // for (int j = 0; j < currentTransitions.length; j++) {
    // inputPointer++; //1 //2 //3
    // currentState = currentTransitions[j]; // q0 //q1 //q2
    // if (inputPointer < input.length()) { //true //true //false
    // currentInput = input.charAt(inputPointer); // '1' //'0'
    // } else {
    // if(currentState.getF() && currentState.getEpsilonTransitions() == null) {
    // System.out.println("ACCEPT");
    // }
    // // else {
    // // if(currentState.getEpsilonTransitions() != null) {
    // // currentTransitions = currentState.getEpsilonTransitions();
    // // for (int x = 0; x < currentTransitions.length; x++) {

    // // }
    // // }
    // // }
    // }

    // if (currentInput == '0') { //false //true
    // currentTransitions = currentState.getZeroTransitions(); //null
    // if (currentTransitions == null) { //true
    // currentTransitions = currentState.getEpsilonTransitions(); //{q2}
    // if(currentTransitions == null) { //false
    // throw new Exception("Error: no further transitions available");
    // }
    // }
    // } else if (currentInput == '1') { //true
    // currentTransitions = currentState.getOneTransitions(); //null
    // if (currentTransitions == null) { //true
    // currentTransitions = currentState.getEpsilonTransitions(); //{q1}
    // if(currentTransitions == null) { //false
    // throw new Exception("Error: no further transitions available");
    // }
    // }
    // }

    // j = 0;
    // }
    // } else {
    // throw new Exception("Error: no further transitions available");
    // }
    // }

    // Get starting state (q0)
    private void init() throws Exception {

        for (State state : states) {
            if (state.getQ0() == true) {
                startState = state;
            }
        }
        if (startState != null) {
            currentState = startState;
        } else {
            throw new Exception("Error: no q0");
        }

        inputPointer = 0;
    }
}
