package bin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cztery_dwa {
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
		
		int i = 0;
		int pierwszy = 0;
		int maxDlugosc = 0;
		
		while(i < dane.length) {
			if (contains(dane[i], ln) && contains(dane[i+1], ln)) {
				int tmpPierwszy = dane[i];
				int counter = 0;
				while (i < dane.length && contains(dane[i], ln)) {
					counter++;
					i++;
				}
				if (counter > maxDlugosc) {
					maxDlugosc = counter;
					pierwszy = tmpPierwszy;
				}
			} else
				i++;
		}
		System.out.print(pierwszy + " " + maxDlugosc);
		
	}
	
	public static boolean contains(int x, int arr[]) {
		for (int y : arr) {
			if (y == x) 
				return true;
		}
		return false;
	}
}
