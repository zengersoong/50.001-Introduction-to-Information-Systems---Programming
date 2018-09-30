// Homework Question 2
// total: 10 points

//===============================================
// todo: complete the following program
//===============================================
package PartB;

import java.util.*;
public class Scheduler {
	/**
	 * @param args
	 *            the command line arguments
	 * @throws TimeInUseException
	 * @throws InvalidTimeException
	 */

	public void make_appointment() {
		System.out.println("Welcome to the Appointment Scheduler.");
		System.out.println("You can schedule an appointment " + "at 1 or 2 pm.");
		Scanner reader = new Scanner(System.in);
		String appointments[] = new String[3];
		int appointmentsMade = 0;

		while (appointmentsMade < 2) {
			try {
				System.out.println("Enter time (space) and name ");
				int timeslot = reader.nextInt();
				String name = reader.nextLine();
				if (timeslot != 1 && timeslot != 2)
					throw new InvalidTimeException();
				if (appointments[timeslot] != null)
					throw new TimeInUseException();
				appointments[timeslot] = name;
				appointmentsMade += 1;
				
			} catch (InvalidTimeException e) {
				System.out.println("Invalid Time slot!");
			} catch (TimeInUseException e) {
				System.out.println("Time slot in used!");
			}


		}
		for (int timeslot = 1; timeslot < 3; timeslot++) {
			System.out.println(timeslot + "pm " + appointments[timeslot]);
		}

	}

	public static void main(String[] args) {
		
		Scheduler scheduler = new Scheduler();
		scheduler.make_appointment();

	}

public class InvalidTimeException extends Exception{
            //Type your codes here

}

public class TimeInUseException extends Exception{
            //Type your codes here
       
}

}