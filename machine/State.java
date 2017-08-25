package machine;

import java.util.HashSet;
import java.util.Set;

public class State {
	private String symbol;
	private Set<TransitionFuction> transitions;
	
	public State(String symbol){
		this.symbol = symbol;
		this.transitions = new HashSet<TransitionFuction>();
	}

	
	public TransitionFuction getTransition(String tapeSymbol){
		TransitionFuction result = null;
		for (TransitionFuction transition : transitions) {
			if(transition.getCurrentSymbol().equals(tapeSymbol)){
				result = transition;
			}
		}
		return result;
	}
	
	
	public void addTransition(TransitionFuction transition){
		transitions.add(transition);
	}
	
	
	public String getSymbol() {
		return symbol;
	}

	
}
