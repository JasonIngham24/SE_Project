//package seproject.apis.computestore;
package seproject.apis.enginemanager;

public class EngineManagerImpl implements EngineManagerAPI {
	// Attributes
	int n;
	int[] fibonacci = new int[n];

	// Constructors
	public EngineManagerImpl(int n) {
		this.n = n;
	}

	@Override
	public int sumOfNthEvenFibbonaciNums(int n) {

		int[] evenNums = new int[n / 2];
		// base case
		if (n <= 1) {
			return n;
		}

		// adds fibonacci sequence to array.
		fibonacci[n] = sumOfNthEvenFibbonaciNums(n - 1) + sumOfNthEvenFibbonaciNums(n - 2);

		if (fibonacci[n] % 2 == 0) {
			int count = 0;
			while (evenNums[count] != 0) {
				count++;
			}
			evenNums[count] = fibonacci[n];
		}

		return calculateSum(evenNums);
	}

	public int calculateSum(int[] evenNums) {
		int sum = 0;
		for (int currentNumber : evenNums) {
			sum += currentNumber;
		}

		return sum;

	}

}