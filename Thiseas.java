import java.io.*;
import java.util.StringTokenizer;

public class Thiseas {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader br = null;
		StringStackImpl stack = new StringStackImpl();

		try {
			String line;
			int counterOfExit = 0; // counts how many exits the labyrinth has

			// Running in eclipse, replace this path with your own
			String FILENAME = "C:\\\\Users\\\\melde_000\\\\Desktop\\\\java\\\\Maze\\\\src\\\\text.txt";
			br = new BufferedReader(new FileReader(FILENAME));

			/*
			 * RUNNING ON CMD!!
			 * 
			 * //compilation on cmd : javac *.java 
			 *  running on cmd : java Thiseas text.txt /
			 *  delete the line 25 from comment to run on cmd
			 *  and make comment lines 15 and 16
			 * new BufferedReader(new FileReader(args[0]));
			 * 
			 */

			int[] data = new int[4];
			int counter = 0;

			// reads the text line by line and splits it by space with
			// StringTokenizer and put
			// the dimensions of the labyrinth and the coordinates of the
			// entrance (E) to data array
			for (int i = 0; i < 2; i++) {
				line = br.readLine();
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					data[counter] = Integer.parseInt(st.nextToken());
					counter++;
				}
			}

			// prints the dimensions of the labyrinth and the coordinates of the
			// entrance E
			System.out.println("The dimensions of the labyrinth are : (" + data[0] + "," + data[1] + ")");
			System.out.println("The coordinates of Entrance E are : (" + data[2] + "," + data[3] + ")");

			char[][] labyrinth = new char[data[0]][data[1]]; // initializes a
																// char array
																// labyrinth
																// with the
																// given
																// dimensions
																// from the text
			for (int i = 0; i < data[0]; i++) {
				line = br.readLine().trim();
				StringTokenizer s = new StringTokenizer(line.trim(), " ");
				for (int j = 0; j < data[1]; j++) {
					labyrinth[i][j] = s.nextToken().charAt(0); // put the
																// labyrinth to
																// a char array
																// labyrinth
					System.out.print(labyrinth[i][j] + " "); // prints the
																// labyrinth
					if (j == data[1] - 1) {
						System.out.print("\n");
					}
				}
			}
			System.out.println("-----------------------------");

			int i = data[2];
			int j = data[3];
			String pos;
			// if the labyrinth has entrance finds the exit/s
			// else prints that the labyrinth has not an entrance
			if (labyrinth[i][j] == 'E') {
				while (true) {

					// it goes right from the current position and if it founds
					// 0 then pushes the coordinates to stack
					if (j < data[1] - 1) {
						if (labyrinth[i][j + 1] == '0') {
							stack.push(i + " " + (j + 1));

						}
					}
					// it goes left from the current position and if it founds 0
					// then pushes the coordinates to stack
					if (j > 0) {
						if (labyrinth[i][j - 1] == '0') {
							stack.push(i + " " + (j - 1));

						}
					}
					// it goes down from the current position and if it founds 0
					// then pushes the coordinates to stack
					if (i < data[0] - 1) {
						if (labyrinth[i + 1][j] == '0') {
							stack.push((i + 1) + " " + j);

						}
					}
					// it goes up from the current position and if it founds 0
					// then pushes the coordinates to stack
					if (i > 0) {
						if (labyrinth[i - 1][j] == '0') {
							stack.push((i - 1) + " " + j);

						}

					}

					// we have exit to positions in first and last row and in
					// first and last column
					if ((i == 0 || i == data[0] - 1 || j == 0 || j == data[1] - 1)) {
						// We found an exit/s
						if (labyrinth[i][j] != 'E') {
							counterOfExit++; // counts the number of exits
							System.out.println(
									"The coordinates of exit " + counterOfExit + " are : (" + i + "," + j + ")");

						}
					}

					labyrinth[i][j] = 'x'; // changes the 0 to x in order not to
											// push again to the stack the
											// previous coordinates
					if (!stack.isEmpty()) {
						pos = stack.pop(); // pop the coordinates
						// splits pos with StringTokenizer by space and returns
						// to while statement with the coordinates that popped
						// from stack
						StringTokenizer s = new StringTokenizer(pos, " ");
						i = Integer.parseInt(s.nextToken());
						j = Integer.parseInt(s.nextToken());
					} else {
						// if counterOfExit =0 then the labyrinth has not an
						// exit
						// else it prints the coordinates of the exits
						if (counterOfExit == 0) {

							System.out.println(" No exit!");

							break;
						} else {
							System.out.println("We found " + counterOfExit + " exit/s !");
							break;
						}

					}

				}
			} else {
				System.out.println("The labyrinth has not entrance!");
			}

		} catch (FileNotFoundException e) {
			System.err.println("Error opening file!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
