import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Summary Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Fix input issue

            switch (choice) {

                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter student grade: ");
                    double grade = sc.nextDouble();

                    names.add(name);
                    grades.add(grade);

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (names.isEmpty()) {
                        System.out.println("No student data available.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (int i = 0; i < names.size(); i++) {
                            System.out.println(names.get(i) + " - " + grades.get(i));
                        }
                    }
                    break;

                case 3:
                    if (grades.isEmpty()) {
                        System.out.println("No data to generate report.");
                    } else {
                        double sum = 0;
                        double highest = grades.get(0);
                        double lowest = grades.get(0);

                        for (double g : grades) {
                            sum += g;
                            if (g > highest) highest = g;
                            if (g < lowest) lowest = g;
                        }

                        double average = sum / grades.size();

                        System.out.println("\n--- Summary Report ---");
                        System.out.println("Total Students: " + grades.size());
                        System.out.println("Average: " + average);
                        System.out.println("Highest: " + highest);
                        System.out.println("Lowest: " + lowest);
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}