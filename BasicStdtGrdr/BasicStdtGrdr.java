import java.util.ArrayList;
import java.util.Scanner;

/**
 * BasicStdtGrdr - Basic Student Grader
 * 
 * Features:
 * - Input student names and five test scores
 * - Calculates average score for each student
 * - Assigns letter grade (A-F) based on average
 * - Outputs formatted results table
 */
public class BasicStdtGrdr {
    
    /**
     * Main method - Entry point of the application
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        try {
            displayWelcomeMessage();
            
            // Get number of students
            System.out.print("Enter number of students: ");
            int numStudents = scanner.nextInt();
            scanner.nextLine(); // Clear newline
            
            // Input data for each student
            for (int i = 0; i < numStudents; i++) {
                System.out.println("\n--- Student " + (i + 1) + " ---");
                
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                
                double[] scores = new double[5];
                System.out.println("Enter 5 test scores:");
                
                boolean validScores = true;
                for (int j = 0; j < 5; j++) {
                    System.out.print("Score " + (j + 1) + ": ");
                    scores[j] = scanner.nextDouble();
                    
                    if (scores[j] < 0 || scores[j] > 100) {
                        System.out.println("Error: Score must be between 0 and 100! Please re-enter data for this student.");
                        validScores = false;
                        break;
                    }
                }
                scanner.nextLine(); // Clear newline
                
                if (!validScores) {
                    i--; // Retry this student
                    continue;
                }
                
                Student student = new Student(name, scores);
                students.add(student);
            }
            
            // Display results
            displayResults(students);
            
        } catch (Exception e) {
            System.err.println("Error: Invalid input. Please enter valid data.");
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Displays welcome message
     */
    private static void displayWelcomeMessage() {
        System.out.println("=========================================");
        System.out.println("     Basic Student Grader System        ");
        System.out.println("=========================================");
        System.out.println("This system calculates student averages");
        System.out.println("and assigns letter grades (A-F).");
        System.out.println();
    }
    
    /**
     * Displays formatted results table for all students
     */
    private static void displayResults(ArrayList<Student> students) {
        System.out.println("\n\n=========================================");
        System.out.println("           STUDENT GRADE REPORT          ");
        System.out.println("=========================================");
        
        // Table header
        System.out.printf("%-20s %-8s %-8s %-8s %-8s %-8s %-10s %-6s%n",
            "Name", "Score1", "Score2", "Score3", "Score4", "Score5", "Average", "Grade");
        System.out.println("=========================================================================================================");
        
        // Print each student's data
        for (Student student : students) {
            double[] scores = student.getScores();
            System.out.printf("%-20s %-8.1f %-8.1f %-8.1f %-8.1f %-8.1f %-10.2f %-6s%n",
                student.getName(),
                scores[0], scores[1], scores[2], scores[3], scores[4],
                student.getAverage(),
                student.getLetterGrade());
        }
        
        System.out.println("=========================================================================================================");
        
        // Display statistics
        displayStatistics(students);
    }
    
    /**
     * Displays class statistics
     */
    private static void displayStatistics(ArrayList<Student> students) {
        if (students.isEmpty()) {
            return;
        }
        
        double classTotal = 0;
        double highest = students.get(0).getAverage();
        double lowest = students.get(0).getAverage();
        
        for (Student student : students) {
            double avg = student.getAverage();
            classTotal += avg;
            if (avg > highest) highest = avg;
            if (avg < lowest) lowest = avg;
        }
        
        double classAverage = classTotal / students.size();
        
        System.out.println("\nClass Statistics:");
        System.out.printf("Class Average: %.2f%n", classAverage);
        System.out.printf("Highest Average: %.2f%n", highest);
        System.out.printf("Lowest Average: %.2f%n", lowest);
        System.out.println("=========================================");
    }
}

/**
 * Student class - Represents a student with scores and grade information
 */
class Student {
    private String name;
    private double[] scores;
    private double average;
    private String letterGrade;
    
    /**
     * Constructor to create a new student
     */
    public Student(String name, double[] scores) {
        this.name = name;
        this.scores = scores;
        this.average = calculateAverage();
        this.letterGrade = calculateLetterGrade();
    }
    
    /**
     * Calculates the average of the five scores
     */
    private double calculateAverage() {
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.length;
    }
    
    /**
     * Determines the letter grade based on average
     * A: 90-100
     * B: 80-89
     * C: 70-79
     * D: 60-69
     * F: Below 60
     */
    private String calculateLetterGrade() {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public double[] getScores() {
        return scores;
    }
    
    public double getAverage() {
        return average;
    }
    
    public String getLetterGrade() {
        return letterGrade;
    }
}
