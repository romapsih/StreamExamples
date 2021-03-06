package org.streams.example;

import org.streams.data.StudentsDataForParallelExample;
import org.streams.entity.Game;
import org.streams.entity.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rdovgan on 09.02.2017.
 */
public class GameExample {

	public static void studentsExample() {
		List<Student> students = StudentsDataForParallelExample.studentList;
		double bestGpa = students
				.stream()
				.filter(s -> (s.getGraduationYear() == Student.THIS_YEAR))
				.mapToDouble(s -> s.getGpa())
				.max().getAsDouble();
		System.out.println(bestGpa);
	}

	public static void playersExample() {
		List<String> names = Arrays.asList("Joe", "Bob", "Kris");

		Game.PlayerPoints highestPlayer = names.stream().map(name -> new Game.PlayerPoints(name, Game.getPoints(name)))
				.reduce(new Game.PlayerPoints("", 0), (s1, s2) -> (s1.points > s2.points) ? s1 : s2);

		System.out.println(highestPlayer);
	}

	public static void main(String[] args) {
		//studentsExample();
		playersExample();
	}

}
