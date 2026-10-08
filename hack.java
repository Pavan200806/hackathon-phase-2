import java.util.Scanner;

class Student {
    // Data members
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor to initialize all details
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to check registration eligibility
    public boolean checkEligibility() {
        return this.marks >= 50;
    }

    // Method to calculate course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return this.courseCredits * 1500;
    }

    // Method to calculate scholarship percentage based on marks
    public double calculateScholarship() {
        if (this.marks >= 85) {
            return 20.0; // 20% scholarship
        } else if (this.marks >= 70 && this.marks <= 84) {
            return 10.0; // 10% scholarship
        } else {
            return 0.0;  // No scholarship
        }
    }

    // Method to calculate final fee after deducting scholarship
    public double calculateFinalFee() {
        double totalFee = calculateFee();
        double scholarshipPercent = calculateScholarship();
        double scholarshipAmount = totalFee * (scholarshipPercent / 100);
        return totalFee - scholarshipAmount;
    }

    // Method to display all student and course details
    public void displayDetails() {
        double totalFee = calculateFee();
        double scholarshipPercent = calculateScholarship();
        double scholarshipAmount = totalFee * (scholarshipPercent / 100);
        double finalFee = calculateFinalFee();

        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Registered  : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);
        System.out.println("Eligibility Status : Eligible");
        System.out.println("Total Course Fee   : Rs. " + totalFee);
        System.out.println("Scholarship %      : " + scholarshipPercent + "% (Rs. " + scholarshipAmount + ")");
        System.out.println("Final Payable Fee  : Rs. " + finalFee);
    }
}

public class hack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading student and course details from user
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over

        System.out.print("Enter Course Name: ");
        String course = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();

        // Create student object using the parameterized constructor
        Student student = new Student(name, roll, marks, course, credits);

        // First check whether the student is eligible for registration
        if (student.checkEligibility()) {
            // Display details (this internally invokes calculation methods as required)
            student.displayDetails();
        } else {
            // Display appropriate message if not eligible
            System.out.println("\nRegistration Failed: Student is not eligible for registration (Marks are below 50).");
        }

        scanner.close();
    }
}