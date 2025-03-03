//package seproject.apis.computestore;
package implementations;

import java.util.ArrayList;
import java.util.List;
import seproject.apis.enginemanager.EngineManagerAPI;

public class EngineManagerImpl implements EngineManagerAPI {
	// Attributes
	int input;
	
	// Constructors
	public EngineManagerImpl(int input) {
		this.input = input;
	}
	//methods
	@Override
	public int sumOfNthEvenFibbonaciNums(int input) {
		//Holds Even Fibbonacci Numbers
		List<Integer> evenFibonacciNums = new ArrayList<>();
		
		int sum = 0;
		
		//Set up first step of the sequence
		int first = 0;
		int second =1;
		while(input > 1) {
			input--;
			
			int next = first + second; 
			
			//Assign values for next step of the sequence
			first = second;
			second = next;
			
				//add even numbers to list;
			if (next % 2 == 0) {
					
					evenFibonacciNums.add(next);
			}
				
		}
		return calculateSum(evenFibonacciNums);
	}
		
	
	//helper method to calculate sum
	public int calculateSum(List<Integer> evenNums) {
		int sum = 0;
		for (int currentNumber : evenNums) {
			sum += currentNumber;
		}

		return sum;

	}

}