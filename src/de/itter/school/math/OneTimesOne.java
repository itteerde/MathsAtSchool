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

	/**
	 * @param args
	 */
	public static void main(String[] args) {

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

}
