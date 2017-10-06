/**
 * 
 */
package de.itter.school.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author eriki
 *
 */
public class Multiplikation {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numberOfExercises = 0;
		long time = 0;
		int correctAnswers = 0;
		int lowerLimit = 0;
		int upperLimit = Integer.MAX_VALUE;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Minimum für die Faktoren:");
			String limit = in.readLine();
			lowerLimit = Integer.parseInt(limit);
			System.out.println("Maximum für die Faktoren:");
			limit = in.readLine();
			upperLimit = Integer.parseInt(limit);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}

		for (;;) {
			try {

				int a = (int) ((Math.random() * upperLimit) + lowerLimit);
				int b = (int) ((Math.random() * upperLimit) + lowerLimit);

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
