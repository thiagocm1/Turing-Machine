package main;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.INITIALIZE;

import machine.TuringMachine;

public class Main {

	private static TuringMachine machine = new TuringMachine();
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String option;
		initialize();
		do {
			System.out.println("Chose a number that correspond to an option below:");
			System.out.println("1 - Run at full speed ");
			System.out.println("2 - Run step by step");
			System.out.println("3 - Change words");
			System.out.println("4 - end machine");
			option = input.nextLine();
			run(option.trim());

		} while (option != "4");

	}

	public static void initialize() {
		System.out.println("-- initialized machine --");

	}

	private static void run(String option) {
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
			machine.changeWord(word);
		case 4:
			option = "4";
			machine.end();
		}
	}
	public static void printAll(){
		printTape();
		printHead();
		printCurrentState();
		printSteps();
		
	}

	private static void printSteps() {
		System.out.println("Number of Steps [ " + machine.steps() + " ]");
	}

	private static void printCurrentState() {
		System.out.println("Current State [ " + machine.currentState()+ " ]");	
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
