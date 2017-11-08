/**
 * 1x1 Test für Meine Chance. This is Public Domain.
 */
package de.itter.school.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Erik Itter
 *
 */
public class OneTimesOne {

	private static final int MEMORY_LENGTH = 20;

	private int[][][] results = new int[10][10][MEMORY_LENGTH];
	private int[][] memory = new int[MEMORY_LENGTH][2];
	private int successStreak = 0;
	private int errorStreak = 0;

	private void run() {
		int numberOfExercises = 0;
		long time = 0;
		int correctAnswers = 0;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (;;) {
			try {

				int a = (int) ((Math.random() * 8) + 2);
				int b = (int) ((Math.random() * 8) + 2);

				System.out.print(a + " mal " + b + " = ");
				numberOfExercises++;
				long start = System.currentTimeMillis();

				String s = in.readLine();

				long end = System.currentTimeMillis();
				time += end - start;

				if (s.equals("exit")) {
					return;
				}

				if (!(Integer.parseInt(s) == a * b)) {// wrong
					System.out.println("nein, " + a + " mal " + b + " ist: " + a * b + ".");
				} else {// correct
					correctAnswers++;
				}

				System.out.println(correctAnswers + "/" + numberOfExercises + " richtig, " + time / numberOfExercises
						+ "ms/Antwort");
			} catch (NumberFormatException | IOException e) {
				System.out.println("keine Zahl oder Systemfehler");
			}

		}

	}

	private int compareTo(int[] a, int[] b) {
		return -1;
	}

	private void anEasyOnePlease() {

	}

	private void theHardestOnePlease() {

	}

	private int randomInt(int min, int max) {
		return (int) ((Math.random() * (max - min) + min));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		OneTimesOne o = new OneTimesOne();
		o.run();
	}

}
