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
			System.out.println("Now,chose a number that correspond to an option below: ");
			System.out.println("1 - Run at full speed ");
			System.out.println("2 - Run step by step ");
			System.out.println("3 - Change words ");
			System.out.println("4 - Change sintax ");
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
		System.out.println("Type the word: ");
		turingMachine.writeOnTape(input.nextLine());
		printAll();
	}
	
	public static void run(String option) throws IOException {
		if (option.equals("1")) {
			try {
				turingMachine.runFullSpeed();
				printAll();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (option.equals("2")) {
			try {
				turingMachine.stepByStep();
				printAll();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		} else if(option.equals("3")) {
			System.out.println("");
			System.out.print("Please, type new word: ");
			String word = input.nextLine();
			turingMachine.writeOnTape(word);
			printAll();
		} else if (option.equals("4")) {
			turingMachine.restartMachine();
			turingMachine.readFromConsole();
			System.out.println("");
			System.out.print("Please, type new syntax: ");
			String word = input.nextLine();
			turingMachine.writeOnTape(word);
			printAll();
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
		System.out.println("Tape: " + result);
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
		
		System.out.println("Head: " + result);
	}
	
	private static void printCurrentState() {
		System.out.println("Current State: " + turingMachine.currentState.getSymbol());
	}
	
	private static void printSteps() {
		System.out.println("Number of Steps [ " + turingMachine.steps + " ]");
	}

	
	
	
	
	
/*
	private static File files = new File();
	private static TuringMachine machine = new TuringMachine();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String option;
		initialize();
		do {
			System.out.println("Now,chose a number that correspond to an option below:");
			System.out.println("1 - Run at full speed ");
			System.out.println("2 - Run step by step");
			System.out.println("3 - Change words");
			System.out.println("4 - Change sintax");
			System.out.println("5 - End machine");
			
			option = input.nextLine();
			try {
				run(option.trim());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (option != "4");

	}

	public static void initialize() throws IOException {
		System.out.println("-- initialized machine --");
		machine.readFromConsole();
		System.out.println("Type the word: ");
		machine.writeOnTape(input.nextLine());
		printAll();
	}
	/*
	 * public static void init() throws IOException {
		System.out.println("Bem vindo ao Simulador de Maquina de Turing.");
		turingMachine.readFromConsole();
		System.out.println("");
		System.out.print("Digite a palavra: ");
		turingMachine.escreverPalavra(scan.nextLine());
		printarFita();
		printarCabecote();
		printarEstadoAtual();
		printarPassos();
	 
	private static void run(String option) throws Exception {
		int teste = 6;
		switch (teste) {
		case 1:
			option = "1";
			machine.runFullSpeed();
		case 2:
			option = "2";
			machine.stepByStep();
		case 3:
			option = "3";
			System.out.println("Type new word:");
			String word = input.nextLine();
			machine.writeOnTape(word);
		case 4:
			option = "4";
			machine.restartMachine();
			machine.readFromConsole();
			System.out.println("Type new syntax:");
			String word2 = input.nextLine();
			machine.writeOnTape(word2);
		}
	}
	
	
	 
	public static void printAll(){
		printTape();
		printHead();
		printCurrentState();
		printSteps();
		
	}

	private static void printSteps() {
		System.out.println("Number of Steps [ " + machine.steps + " ]");
	}

	private static void printCurrentState() {
		System.out.println("Current State [ " + machine.currentState.getSymbol() + " ]");	
	}

	private static void printHead() {
		String result = "";
		String[] array = new String[machine.tape.words.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = " ";
		}
		
		array[machine.tape.head] = "^";
		
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		
		System.out.println("HEAD: " + result);
	}

	private static void printTape() {
		String result = "";
		ArrayList<String> tape = machine.tape.words;
		for(String string : tape) {
			if(string.equals("_")) 
				result += " ";
			else result += string;
		}
		System.out.println("TAPE:" + result);
	}
	private static File files = new File();
	private static TuringMachine machine = new TuringMachine();
	private static Scanner input = new Scanner(System.in);
	


	public static void main(String[] args) throws IOException {
		String option;
		initialize();
		do {
			System.out.println("Now,chose a number that correspond to an option below:");
			System.out.println("1 - Run at full speed ");
			System.out.println("2 - Run step by step");
			System.out.println("3 - Change words");
			System.out.println("4 - Change sintax");
			System.out.println("5 - End machine");
			
			option = input.nextLine();
			try {
				run(option.trim());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (option != "4");

	}

	public static void initialize() throws IOException {
		System.out.println("-- initialized machine --");
		files.readFromConsole();
		System.out.println("digite a palavra: ");
		machine.writeOnTape(input.nextLine());
		printAll();
	}
	
	private static void run(String option) throws Exception {
		int teste = 6;
		switch (teste) {
		case 1:
			option = "1";
			machine.runFullSpeed();
		case 2:
			option = "2";
			machine.stepByStep();
		case 3:
			option = "3";
			System.out.println("Type new word: ");
			String word = input.nextLine();
			machine.writeOnTape(word);
		case 4:
			option = "4";
			machine.reset();
			files.readFromConsole();
			System.out.println("Type new syntax: ");
			String word2 = input.nextLine();
			machine.writeOnTape(word2);
		}
	}
	
	
	 
	public static void printAll(){
		printTape();
		printHead();
		printCurrentState();
		printSteps();
		
	}

	private static void printSteps() {
		System.out.println("Number of Steps [ " + machine.steps + " ]");
	}

	private static void printCurrentState() {
		System.out.println("Current State [ " + machine.currentState.getSymbol() + " ]");	
	}

	private static void printHead() {
		String result = "";
		String[] array = new String[machine.tape.words.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = " ";
		}
		
		array[machine.tape.head] = "*";
		
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		
		System.out.println("HEAD: " + result);
	}

	private static void printTape() {
		String result = "";
		ArrayList<String> tape = machine.tape.words;
		for(String string : tape) {
			if(string.equals("_")) 
				result += " ";
			else result += string;
		}
		System.out.println("TAPE:" + result);
	}
	*/
}