package bin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cztery_trzy {
	public static void main(String[] args) {
		int[] ln = new luckyNumbers().toArray();
		int[] dane = new int[2526];
		
		File f = new File("src/bin/dane.txt");
		try {
			Scanner plik = new Scanner(f);
			int i = 0;
			while (plik.hasNextLine()) {
				dane[i++] = Integer.parseInt(plik.nextLine());
			}
			plik.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int counter = 0;
		for (int x : dane) {
			if (contains(x, ln) && czyPierwsza(x))
				counter++;
		}
		System.out.print(counter);
	}
	
	public static boolean czyPierwsza(int x) {
		if (x < 2)
			return false;
		else if (x == 2)
			return true;
		
		for (int i = 2; i<=Math.sqrt(x); i++) {
			if (x % i == 0) 
				return false;
		}
		return true;
	}
	
	public static boolean contains(int x, int arr[]) {
		for (int y : arr) {
			if (x == y) 
				return true;
		}
		return false;
	}
}
