public class NFA {    
    private State[] Q; //set of states
    private char[] sigma = {'0', '1'}; //set of alphabet symbols
    private State[][] transitions = new State[sigma.length + 1][]; //set of sets of transitions (alphabet + 1 for epsilon)
    private State q0; //initial state
    private State[] F; //set of accepting states
    
}
