package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			if(this.findState(state)==null){
				State newState = new State(state);
				states.add(newState);
				
				String[] words = state.split("");
				if(words.length >= 4){
					String halt = words[0] + words[1] + words[2] + words[3];
					if(halt.equals("halt")){
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
		
		
		public void runFullSpeed() throws Exception	 {
			
			while(!this.finalStates.contains(this.currentState)){
				this.stepByStep();
			}
			
		}

		public void stepByStep() throws Exception {
			if(finalStates.contains(this.currentState)){
				return;
			}
			
			TransitionFunction transition = this.currentState.getTransition(this.tape.getSymbol());
			
			if(transition == null){
			
				transition = this.currentState.getTransition("*");
					
					if(transition == null){
						throw new Exception("I'm sorry Kyller. I'm afraid i can't do that. Please, change your words ( 3 ) or syntax ( 4 ) : ");
					}
				
			}
			if(!transition.getNextSymbol().equals("*")){
				tape.writeSymbol(transition.getNextSymbol());
			}
			tape.walk(transition.getDirection());
			if(!transition.getNextState().equals("*")){
				this.currentState = transition.getNextState();
			}
			this.steps++;
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

	public void readFromConsole() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nType an syntax follow by ' end ': ");
		String in;

		while (!(in = reader.readLine()).trim().equalsIgnoreCase("end")) {
			if (!in.isEmpty() && !in.trim().equals("")) {
				String[] read = in.split(" ");
				if (!read[0].equals(";")) {
					addTransition(read[0], read[1], read[2], read[3], read[4]);
				}

			}
		}
	}


}