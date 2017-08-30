package machine;

public class TransitionFunction {
	
	private String currentSymbol;
	private String nextSymbol;
	private String direction;
	private State nextState;
	
	public TransitionFunction(String currentSymbol, String nextSymbol, String direction, State nextState ){
		this.currentSymbol = currentSymbol;
		this.nextSymbol = nextSymbol;
		this.direction = direction;
		this.nextState = nextState;
	}

	public String getCurrentSymbol() {
		return currentSymbol;
	}

	public void setCurrentSymbol(String currentSymbol) {
		this.currentSymbol = currentSymbol;
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

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}
	
	
	
	
	
}
