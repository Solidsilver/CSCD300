import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class FileUt {
	public static String[][] fileToArray(String fname) throws FileNotFoundException {
		String[][] ret;
		Scanner fin = new Scanner(new File(fname));
		int x = countRecX(fin);
		fin = new Scanner(new File(fname));
		int y = countRecY(fin);
		fin = new Scanner(new File(fname));
		ret = new String[x][y];
		int ix = 0;
		String[] parse;
		while (fin.hasNextLine()) {
			parse = fin.nextLine().split("(?!^)");
			for (int iy = 0; iy < parse.length; iy++) {
				ret[ix][iy] = parse[iy];
			}
			ix++;
		}
		return ret;

	}

	public static int countRecY(Scanner fin) {
		char[] cnt = fin.nextLine().toCharArray();
		return cnt.length;
	}

	public static int countRecX(Scanner fin) {
		int cntr = 0;
		while (fin.hasNextLine()) {
			fin.nextLine();
			cntr++;
		}
		return cntr;
	}

	public static void printArray(String[][] arr) {
		for (int ix = 0; ix < arr.length; ix++) {
			for (int iy = 0; iy < arr[0].length; iy++) {
				System.out.print(arr[ix][iy]);
			}
			System.out.println();
		}
	}
}


