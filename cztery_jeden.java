package bin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cztery_jeden {
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
			for (int n : ln) {
				if (x == n) {
					counter++;
					break;
				}
			}
		}
		System.out.print(counter);
	}
}
