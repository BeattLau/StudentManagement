package org.example;

import java.io.*;
import java.util.List;

public class DataPersistence {
    void saveData(List<Student> students, List<User> users, String studentFileName, String userFileName) {
        try (ObjectOutputStream studentOutput = new ObjectOutputStream(new FileOutputStream(studentFileName));
             ObjectOutputStream userOutput = new ObjectOutputStream(new FileOutputStream(userFileName))) {
            studentOutput.writeObject(students);
            userOutput.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadData(List<Student> students, List<User> users, String studentFileName, String userFileName) {
        try (ObjectInputStream studentInput = new ObjectInputStream(new FileInputStream(studentFileName));
             ObjectInputStream userInput = new ObjectInputStream(new FileInputStream(userFileName))) {
            students.clear();
            users.clear();

            List<Student> loadedStudents = (List<Student>) studentInput.readObject();
            List<User> loadedUsers = (List<User>) userInput.readObject();

            students.addAll(loadedStudents);
            users.addAll(loadedUsers);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
