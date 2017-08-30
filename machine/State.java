package machine;

import java.util.HashSet;
import java.util.Set;


public class State {
	private String symbol;
	private Set<TransitionFunction> transitions;
	
	public State(String symbol){
		this.symbol = symbol;
		this.transitions = new HashSet<TransitionFunction>();
	}

	
	public TransitionFunction getTransition(String tapeSymbol){
		TransitionFunction result = null;
		for (TransitionFunction transition : transitions) {
			if(transition.getCurrentSymbol().equals(tapeSymbol)){
				result = transition;
			}
		}
		return result;
	}
	
	
	public void addTransition(TransitionFunction transition){
		transitions.add(transition);
	}
	
	
	public String getSymbol() {
		return symbol;
	}

	
}