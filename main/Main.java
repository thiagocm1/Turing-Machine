// REBECA MIRANDA BELTRAO DE OLIVEIRA - 115210857
// THIAGO CUNHA MONTENEGRO - 115211060
package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.INITIALIZE;

import files.File;
import machine.TuringMachine;
public class Main {
	
	private static TuringMachine turingMachine = new TuringMachine();
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		init();
		String opcao;
		do {
			System.out.println("Now, chose a number that correspond to an option below: ");
			System.out.println("1 - Run at full speed ");
			System.out.println("2 - Run step by step ");
			System.out.println("3 - Change input ");
			System.out.println("4 - Change syntax ");
			System.out.println("5 - End machine ");
			System.out.print("Option: ");
			System.out.println("");
			opcao = input.nextLine();
			run(opcao.trim());
		} while (!opcao.equals("5"));
		
	}
	
	public static void init() throws IOException {
		System.out.println("-- initialized machine --");
		turingMachine.readFromConsole();
		System.out.println("Type initial input: ");
		turingMachine.writeOnTape(input.nextLine());
		printAll();
	}
	
	
	public static void run(String option) throws IOException {
		switch(option){
		case "1":
			try {
				turingMachine.runFullSpeed();
				printAll();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case "2":
			try {
				turingMachine.stepByStep();
				printAll();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case "3":
			System.out.println("");
			System.out.print("Type new input: "); 
			String word = input.nextLine();
			turingMachine.writeOnTape(word);
			printAll();
			break;
		case "4":
			turingMachine.restartMachine();
			turingMachine.readFromConsole();
			System.out.println("");
			System.out.print("Type new syntax: ");
			String word1 = input.nextLine();
			turingMachine.writeOnTape(word1);
			printAll();
			break;
			
		}
		
	
	}
	
	public static void printAll() {
		printTape();
		printHead();
		printCurrentState();
		printSteps();
	}

	private static void printTape() {
		String result = "";
		ArrayList<String> tape = turingMachine.tape.words;
		for(String string : tape) {
			if(string.equals("_")) 
				result += " ";
			else result += string;
		}
		System.out.println("TAPE: " + result);
	}
	
	private static void printHead() {
		String result = "";
		
		String[] array = new String[turingMachine.tape.words.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = " ";
		}
		array[turingMachine.tape.getHead()] = "^";
		
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		
		System.out.println("HEAD: " + result);
	}
	
	private static void printCurrentState() {
		System.out.println("CURRENT STATE: [ " + turingMachine.currentState.getSymbol()+ " ]");
	}
	
	private static void printSteps() {
		System.out.println("NUMBER OF STATES: [ " + turingMachine.steps + " ]");
	}
}
