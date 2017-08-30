package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.INITIALIZE;

import files.FileReader;
import machine.TuringMachine;

public class Main {
	
	private static FileReader files = new FileReader();
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
		System.out.println("To start, type a syntax to the Turing Machine, for exemple:"
				+ "2 * * r 2");
		files.readFromConsole();
		
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
}
