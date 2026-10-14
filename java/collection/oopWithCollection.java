
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class oopWithCollection {

    static class Student {
        int id;
        String name;
        String dob;

        Student(int id, String name, String dob) {
            this.id = id;
            this.name = name;
            this.dob = dob;
        }

        void showInfo() {
            System.out.println(
                "ID: " + id +
                ", Name: " + name +
                ", DOB: " + dob
            );
        }
    }

    static class Teacher extends Student {
        Teacher(int id, String name, String dob) {
            super(id, name, dob);
        }

        @Override
        void showInfo() {
            System.out.println(
                "Teacher ID: " + id +
                ", Name: " + name +
                ", DOB: " + dob
            );
        }
        
    }

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         List<Student> students = new ArrayList<>();
        // int option;
        // System.out.println("Enter Option:");
        // option = sc.nextInt();
        // switch(option){
        //     case 1:{

        //     }
        // }
        System.out.print("How many students do you want to add? ");
        int size = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < size; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter DOB: ");
            String dob = sc.nextLine();

            students.add(new Student(id, name, dob));

            System.out.println("Student added successfully!");
        }

        System.out.println("\n--- Student List ---");

        for (Student student : students) {
            student.showInfo();
        }

       
        Teacher teacher = new Teacher(101, "Dara", "1995-01-15");

        System.out.println("\n--- Teacher Information ---");
        teacher.showInfo();

        sc.close();
    }
}
