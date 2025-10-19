package student;

public class Test {
    public static void main(String[] args) {
        Major cs = new Major("23", "Computer Science");
        Major math = new Major("42", "Mathematics");


        new Student("SAFI", "Amal", "0666554433", "amal.safi@example.com", "22885676", cs);
        new Student("ALAMI", "Samir", "0666889900", "samir.alami@example.com", "23585976", cs);
        new Student("FARAH", "Lina", "0666998877", "lina.farah@example.com", "22447899", math);

        System.out.println("===== STUDENT & MAJOR TEST =====");
        // Display computer science students
        cs.displayStudents();

        cs.getOccupancyRate();
        System.out.println("Find student 22885676 → " + cs.findStudentByCNE("22885676").getFullNameFormatted());
        cs.removeStudent("23585976");
        System.out.println("\nAfter removal:");
        cs.displayStudents();

        System.out.println("\n===== INSTRUCTOR & SUBJECT TEST =====");
        Instructor instructor1 = new Instructor("Hiba", "Elbouanani", "0611223344",
                "hiba.elbouanani@um6p.ma", " AB 123 ");
        Subject subject1 = new Subject(" cs-101 ", "introduction to java");

        System.out.println("Cleaned employee number: " + instructor1.cleanEmployeeNumber());
        System.out.println("Normalized subject code: " + subject1.normalizedCode());
        System.out.println("Proper subject title: " + subject1.properTitle());
        System.out.println("Instructor summary: " + instructor1.summaryLine());
        System.out.println("Instructor card:\n" + instructor1.toCard());
        System.out.println("Syllabus line: " + subject1.syllabusLine(instructor1));
        System.out.println("Is intro course? " + subject1.isIntroCourse());
        System.out.println("Display name: " + instructor1.displayName());

    }
}

