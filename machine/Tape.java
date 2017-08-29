package machine;

import java.util.ArrayList;

public class Tape {
	
	public ArrayList<String> words;
	public int head;
	
	public Tape(){
		this.words = new ArrayList<String>();
		this.head = 0;
	}
	
	public void writeWord(String word){
		String[] result = word.split("");
		for (int i = 0; i < result.length; i++) {
			if(result[i].equals(" ")){
				this.words.add("_");
			}else{
				this.words.add(result[i]);
			}
		}
		this.head = 0;
	}
	
	public void writeSymbol(String symbol){
		words.set(head, symbol);
	}
	// mudar o r e o 1
	public void walk(String walk){
		if(walk.equals("1")){
				this.walkLeft();
		}if(walk.equals("r")){
			this.walkRight();	
		}
	}

	//escolher outro simbolo para o _
	private void walkLeft() {
		if(head == 0){
			this.head++;
			this.words.add(0, "_");
		}
		head--;
		
	}
	
	public ArrayList<String> getWords() {
		return words;
	}

	public int getHead() {
		return head;
	}

	public String getSymbol(){
			return words.get(head);
	}
	private void walkRight() {
		if(head == this.words.size() -1){
			this.words.add("_");
		}
		head++;
	}

	
}