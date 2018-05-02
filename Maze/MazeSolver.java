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
		checkPos(0, 0, sol);
		return sol;
	}

	public static boolean checkPos(int x, int y, String[][] map) {
		boolean tap = false;
		if (x < 0 || y < 0) return false;
		if (y >= map.length || x >= map[0].length) return false;
		if (map[y][x].equals("#")) return false;
		if (map[y][x].equals("•") || map[y][x].equals("◦")) return false;
		if (map[y][x].equals("G")) return true;
		map[y][x] = "•";
		if (checkPos(x+1, y, map)) return true;
		if (checkPos(x, y+1, map)) return true;
		if (checkPos(x-1, y, map)) return true;
		if (checkPos(x, y-1, map)) return true;
		map[y][x] = "◦";
		return false;
	}
}
