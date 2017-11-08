/**
 * 1x1 Test für Meine Chance. This is Public Domain.
 */
package de.itter.school.math;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Erik Itter
 *
 */
public class OneTimesOne {

	private int[][] results = new int[10][10];
	String fileName = null;

	private void run(String fileName) {
		int numberOfExercises = 0;
		long time = 0;
		int correctAnswers = 0;
		this.fileName = fileName;

		if (fileName != null) {
			try {
				FileInputStream fis;
				fis = new FileInputStream(fileName);
				ObjectInputStream iis;
				iis = new ObjectInputStream(fis);
				results = (int[][]) iis.readObject();
				iis.close();
			} catch (ClassNotFoundException | IOException e) {
				init();
			}
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (;;) {
			try {

				int[] problem = theHardestOnePlease();
				int a = problem[0];
				int b = problem[1];

				System.out.print(a + " mal " + b + " = ");
				numberOfExercises++;
				long start = System.currentTimeMillis();

				String s = in.readLine();

				long end = System.currentTimeMillis();
				time += end - start;

				if (s.equals("exit")) {
					if (fileName == null) {
						return;
					}
					FileOutputStream fos = new FileOutputStream(fileName);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(results);
					oos.close();
					return;
				}

				if (!(Integer.parseInt(s) == a * b)) {// wrong
					System.out.println("nein, " + a + " mal " + b + " ist: " + a * b + ".");
					results[a - 1][b - 1] += 3;
				} else {// correct
					correctAnswers++;
					results[a - 1][b - 1] += 11;
				}

				System.out.println(correctAnswers + "/" + numberOfExercises + " richtig, " + time / numberOfExercises
						+ "ms/Antwort");
			} catch (NumberFormatException | IOException e) {
				System.out.println("keine Zahl oder Systemfehler");
			}

		}

	}

	/**
	 * 
	 */
	private void init() {
		for (int m = 0; m < 10; m++) {
			for (int n = 0; n < 10; n++) {
				results[m][n] = (int) (Math.random() * 10 + 1);
			}
		}
	}

	private int[] theHardestOnePlease() {
		int[] hardest = { 0, 0 };
		int worst = Integer.MAX_VALUE;

		for (int m = 0; m < 10; m++) {
			for (int n = 0; n < 10; n++) {
				if (results[m][n] < worst) {
					worst = results[m][n];
					hardest[0] = m + 1;
					hardest[1] = n + 1;
				}
			}
		}

		return hardest;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OneTimesOne o = new OneTimesOne();
		o.run(args.length > 0 ? args[0] : null);
	}

}
