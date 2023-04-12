public class NFA {
    private State[] states;
    private String input;

    public NFA(State[] states, String input) {
        this.states = states;
        this.input = input;
    }

    public void Compute() throws Exception {
        State startState = null;

        for (State state : states) {
            if (state.getQ0() == true) {
                startState = state;
            }
        }

        State currentState = null;
        if (startState != null) {
            currentState = startState;
        } else {
            throw new Exception("Error: no q0");
        }

        int inputPointer = 0;

        for (int i = 0; i < input.length(); i++) { // "010"
            char currentInput = input.charAt(inputPointer); // '0'
            State[] currentTransitions = null;

            if (currentInput == '0') { // true
                currentTransitions = currentState.getZeroTransitions(); // {q0}
                if (currentTransitions == null) {
                    currentTransitions = currentState.getEpsilonTransitions();
                }
            } else if (currentInput == '1') {
                currentTransitions = currentState.getOneTransitions();
                if (currentTransitions == null) {
                    currentTransitions = currentState.getEpsilonTransitions();
                }
            }

            if (currentTransitions != null) { // true
                for (int j = 0; j < currentTransitions.length; j++) {
                    inputPointer++; //1 //2 //3
                    currentState = currentTransitions[j]; // q0 //q1 //q2
                    if (inputPointer < input.length()) { //true //true //false
                        currentInput = input.charAt(inputPointer); // '1' //'0'
                    } else {
                        if(currentState.getF() && currentState.getEpsilonTransitions() == null) {
                            System.out.println("ACCEPT");
                        } 
                        // else {
                        //     if(currentState.getEpsilonTransitions() != null) {
                        //         currentTransitions = currentState.getEpsilonTransitions();
                        //         for (int x = 0; x < currentTransitions.length; x++) {
                                    
                        //         }
                        //     }
                        // }
                    }

                    if (currentInput == '0') { //false //true
                        currentTransitions = currentState.getZeroTransitions(); //null
                        if (currentTransitions == null) { //true
                            currentTransitions = currentState.getEpsilonTransitions(); //{q2}
                            if(currentTransitions == null) { //false
                                throw new Exception("Error: no further transitions available");
                            }   
                        }
                    } else if (currentInput == '1') { //true
                        currentTransitions = currentState.getOneTransitions(); //null
                        if (currentTransitions == null) { //true
                            currentTransitions = currentState.getEpsilonTransitions(); //{q1}
                            if(currentTransitions == null) { //false
                                throw new Exception("Error: no further transitions available");
                            }   
                        } 
                    }

                    j = 0;
                }
            } else {
                throw new Exception("Error: no further transitions available");
            }
        }
    }
}
