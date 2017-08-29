package machine;

public class TransitionFunction {
	
	private State nextState;
	private String nextSymbol;
	private String currentSymbol;
	private String direction; // i love one direction
	
	public TransitionFunction(String currentState, String nextSymbol, String direction, 
			State nextState){
		this.setCurrentSymbol(currentSymbol);
		this.setNextSymbol(nextSymbol);
		this.setDirection(direction);
		this.setNextState(nextState);
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	public String getNextSymbol() {
		return nextSymbol;
	}

	public void setNextSymbol(String nextSymbol) {
		this.nextSymbol = nextSymbol;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getCurrentSymbol() {
		return currentSymbol;
	}

	public void setCurrentSymbol(String currentSymbol) {
		this.currentSymbol = currentSymbol;
	}
	
	
	
	
	
}
