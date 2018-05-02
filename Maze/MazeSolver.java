import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeSolver {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner kb = new Scanner(System.in);
		System.out.print("Map File: ");
		String[][] wow = FileUt.fileToArray(kb.nextLine());
		FileUt.printArray(wow);
		System.out.println("\n////////////SOLVED////////////\n");
		FileUt.printArray(solveMaze(wow));
	}

	public static String[][] solveMaze(String[][] maze) {
		String[][] sol = maze;
		checkPos(1, 0, sol);
		return sol;
	}

	public static boolean checkPos(int x, int y, String[][] map) {
		if (x < 0 || y < 0) return false;
		if (x >= map.length || y >= map[0].length) return false;
		if (map[x][y].equals("-") || map[x][y].equals("|") || map[x][y].equals("#")) return false;
		if (map[x][y].equals("•") || map[x][y].equals("◦")) return false;
		if (map[x][y].equals("G")) return true;
		map[x][y] = "•";
		if (checkPos(x, y-1, map)) return true;
		if (checkPos(x+1, y, map)) return true;
		if (checkPos(x, y+1, map)) return true;
		if (checkPos(x-1, y, map)) return true;
		map[x][y] = "◦";
		return false;
	}
}
