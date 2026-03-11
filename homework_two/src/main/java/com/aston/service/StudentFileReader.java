package com.aston.service;

import com.aston.exception.StudentFileReadException;
import com.aston.model.Book;
import com.aston.model.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class StudentFileReader {

    public List<Student> readStudents(String fileName) {

        Map<String, List<Book>> studentBooks = new LinkedHashMap<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new StudentFileReadException("File not found: " + fileName);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] tokens = line.split(";");
                String studentName = tokens[0];
                Book book = new Book(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));

                studentBooks.computeIfAbsent(studentName, k -> new ArrayList<>()).add(book);
            }
        } catch (IOException e) {
            throw new StudentFileReadException("Failed to read file", e);
        }

        List<Student> students = new ArrayList<>();
        for (Map.Entry<String, List<Book>> entry : studentBooks.entrySet()) {
            students.add(new Student(entry.getKey(), entry.getValue()));
        }

        return students;
    }
}