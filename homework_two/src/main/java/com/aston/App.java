package com.aston;

import com.aston.model.Book;
import com.aston.model.Student;
import com.aston.service.StudentFileReader;

import java.util.Comparator;
import java.util.List;


public class App {
    public static void main(String[] args) {

        StudentFileReader reader = new StudentFileReader();

        List<Student> students = reader.readStudents("students.txt");

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(year -> System.out.println("Year: " + year),
                        () -> System.out.println("Такая книга отсутствует"));
    }
}
