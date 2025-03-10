package application;

import dao.StudentDao;
import entity.Student;
import entity.TimeSpent;

public class StudentApp {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        // Add a student
        Student student1 = new Student("Ilmari E", "Ilmari.e@example.com");
        TimeSpent timeSpent1 = new TimeSpent(5, 3, 2);
        student1.addTimeSpent(timeSpent1);
        studentDao.addStudent(student1);

        // Find a student
        Student foundStudent = studentDao.findStudent(1L);
        System.out.println(foundStudent.getName());

        // Update a student
        foundStudent.setEmail("Ilmari.updated@example.com");
        studentDao.updateStudent(foundStudent);

        studentDao.deleteStudent(1L);
    }
}