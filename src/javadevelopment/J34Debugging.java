package javadevelopment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J34Debugging {

	public static void main(String[] args) {
		List<String> studentNames = new ArrayList<>();
		List<Double> studentGrades = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name or press 'Enter' to finish");
		String name;

		do {
			name = scan.nextLine();
			if(!name.equals("")){
				studentNames.add(name);
			}
		}while(!name.equals(""));

		for(String w:studentNames){
			System.out.print("Grade for " + w + ": ");
			Double grade = scan.nextDouble();
			studentGrades.add(grade);
		}

		System.out.println("\nClass roster:");//roster=liste
		double sum = 0.0;

		for(int i=0; i<studentNames.size(); i++){
			System.out.println(studentNames.get(i) + ": " + studentGrades.get(i));
			/*
			  Alttaki satirda bir hata yapildi. Bu hatayi debugging yaparak bulacagiz.
			  30 numarali satira debugging koy ve goster...
			 */
			sum = studentGrades.get(i);
		}

		double average = sum / studentNames.size();
		System.out.println("Class Average Grade is " + average);

	}

}
