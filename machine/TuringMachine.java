package machine;

import java.util.HashSet;
import java.util.Set;

public class TuringMachine {
	public Set<State> states;
	public int steps;
	public Tape tape;
	public State initialState;
	public State currentState;
	public Set<State> finalStates;
	
	public TuringMachine(){
		this.states = new HashSet<State>();
		this.initialState = new State("0");
		this.currentState = this.initialState;
		this.finalStates = new HashSet<State>();
		this.steps = 0;
		this.tape = new Tape();
		this.states.add(initialState);
	}
	
	private void createState(String state){
		if(this.findState(state).equals(null)){
			State newState = new State(state);
			states.add(newState);
			
			String[] words = state.split(" ");
			if(words.length >= 4){
				String halt = words[0] + words[1] + words[2] + words[3];
				if(halt.equals("halt")){ // AQUI O PROGRAMA PARAAAA eu acho
					finalStates.add(newState);
				}
			}
		}
	}
	
	private State findState(String findState){
		State result = null;
		for (State state: states) {
			if(state.getSymbol().equals(findState)){
				result = state;
			}
		}
		return result;
	}
	
	public void addTransition(String currentState, String currentSymbol, String nextSymbol, String direction, String nextState){
		this.createState(currentState);
		this.createState(nextState);
		
		State current = this.findState(currentState);
		State next = this.findState(nextState);
		
		TransitionFunction transition = new TransitionFunction(currentSymbol, nextSymbol, direction, next);
		
		current.addTransition(transition);
	}
	
	public void writeOnTape(String word){
		this.steps = 0;
		this.currentState = this.initialState;
		this.tape = new Tape();
		this.tape.writeWord(word);
	}
	
	
	public void runFullSpeed() throws Exception {
		while(!this.finalStates.contains(currentState)){
			this.stepByStep();
		}
		
	}

	public void stepByStep() throws Exception {
		if(finalStates.contains(this.currentState)){return;}
		TransitionFunction transition = this.currentState.getTransition(this.tape.getSymbol());
		if(transition == null){
			transition = this.currentState.getTransition("*"); // <- mudar isso
			if(transition == null){
				throw new Exception("nao da bb"); // mudar isso dps
			}
		}
		if(!transition.getNextSymbol().equals("*")){
			tape.writeSymbol(transition.getNextSymbol());
		}
		tape.walk(transition.getDirection());
		if(!transition.getNextState().equals("*")){
			this.currentState = transition.getNextState();
		}
		this.steps ++;
	}

	

	public void restartMachine() {
		this.states = new HashSet<State>();
		this.initialState = new State("0");
		this.currentState = this.initialState;
		this.finalStates = new HashSet<State>();
		this.steps = 0;
		this.tape = new Tape();
		this.states.add(initialState);
	}

	public void readFromConsole() {
		// TODO Auto-generated method stub
		
	}
}