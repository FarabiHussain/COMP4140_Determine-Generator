import java.io.*;
import java.lang.Math;

public class Main {

	static int[] factors;
	static int ind = 0;

	public static void main(String[] args) {
		// enter value here
		int x = 1, number = 31;

//		for (int i = 1; i < number; i++) {
//			findGenerators(number, i);
//		}

//		findGenerators(number, 25);
	}

	static void primeFactors(int n) {
		factors = new int[10];
		ind = 0;

		while (n % 2 == 0) {
			// System.out.print(2 + " ");
			factors[ind] = 2;
			n /= 2;
			ind++;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				// System.out.print(i + " ");
				factors[ind] = i;
				n /= i;
				ind++;
			}
		}

		if (n > 2)
			//System.out.print(n);
			factors[ind] = n;
		ind++;
	}

	static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) System.out.println(arr[i] + " ");
		}
	}

	static void findGenerators(int target, int guess) {
		primeFactors(target - 1);
		printArray(factors);

		boolean isGenerator = false;

		for (int j = 0; j < ind - 1; j++) {
			int exponent = (target - 1) / factors[j];
//			System.out.print(guess + "^(" + (target-1) + "/" + factors[j] + ") = ");
			System.out.print(guess + "^" + exponent + " = ");
			System.out.println(Math.pow(guess, exponent) % target + " mod " + target);
			if (Math.pow(guess, exponent) % target != 1) {
				isGenerator = true;
				System.out.println("true");
			} else {
				isGenerator = false;
				System.out.println("false");
				break;
			}
		}

		if (isGenerator) System.out.println(guess + " is a generator");
//		else System.out.println(guess + " is NOT a generator");
	}
}
