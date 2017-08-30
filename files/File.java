package files;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

import machine.State;
import machine.TuringMachine;

public class File {
	private Map<String, State> turingMachine;
	private String fileName;
	private TuringMachine machine;
	
	public void readFromConsole() throws IOException{
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nDigite a sintaxe desejada seguida de 'end' para continuar: ");
		String line;

		while (!(line = file.readLine()).trim().equalsIgnoreCase("end")) {
			if(!line.isEmpty() && !line.trim().equals("")){
				String[] read = line.split(" ");
				if(!read[0].equals(";")){
					machine.addTransition(read[0], read[1], read[2], read[3], read[4]);
				}
			}
		}
	}
	
	public void reset(){
		machine.restartMachine();
	}
	
	protected void scan() {
		Scanner scan = new Scanner(System.in);
		machine.writeOnTape(scan.nextLine());
		scan.close();
	}

	public void readFile() throws IOException {
		
		BufferedReader file = new BufferedReader(new java.io.FileReader("syntax.txt"));
		String line;
		
		while((line = file.readLine()) != null){
			if(!line.matches("^;.*") && !line.isEmpty()){
				String[] readFile = line.split(" ");
				if(!line.matches("^;.*") && !line.isEmpty()) {
					machine.addTransition(readFile[0], readFile[1], readFile[2], readFile[3], readFile[4]);
				}
			}
		}
		file.close();
		
	}

	/*
	public FileReaderTXT(String fileName){
		turingMachine = new HashMap<String, State>();
		this.fileName = fileName;3
		
	}
	
	public void readState() throws Exception{
		if(!verifyMap()){
			throw new Exception("Sorry, machine wasn't initialized");
		}

		BufferedReader file = new BufferedReader(new FileReader( new File(this.fileName)));
		
		String line;

		while((line = file.readLine()) != null) {
			if(!line.matches("^;.*") && !line.isEmpty()) {
				createState(line, turingMachine);
			}
		}
		
		file.close();
		
	}
	

	private void createState(String line, Map<String, State> machine) {
		String state = line.split(" ")[0];
		if(!machine.containsKey(state)){
			if(state.equals("accept")){
				machine.put(state, new State(symbol))
			}
		}
		
	}

	private boolean verifyMap() {
		boolean result;
		if(this.turingMachine == null){
			result = true;
		}
		return false;
	}
	*/
}
