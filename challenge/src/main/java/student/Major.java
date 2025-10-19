package student;

public class Major {
    private static int nextId = 1;
    private static final int MAX_STUDENTS = 50;
    private int id;
    private String code;
    private String name;
    private Student[] students;
    private int studentCount;

    public Major(String code, String name) {
        this.id = nextId++;
        this.code = code;
        this.name = name;
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }

    // Method to add a student
    public void addStudent(Student s) {
        if (studentCount < MAX_STUDENTS) {
            students[studentCount++] = s;
        } else {
            System.out.println("Cannot add student: capacity full for " + name);
        }
    }
    public Student findStudentByCNE(String cne) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getCne().equals(cne)) {
                return students[i];
            }
        }
        return null;
    }
    public boolean removeStudent(String cne) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getCne().equals(cne)) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--studentCount] = null;
                return true;
            }
        }
        return false;
    }
    public int getStudentCount() {
        return studentCount;
    }
    public void getOccupancyRate() {
        System.out.println(name + " capacity: " + MAX_STUDENTS + " students");
        System.out.println("Current enrollment: " + studentCount + " students");
        double rate = (studentCount * 100.0) / MAX_STUDENTS;
        System.out.println(String.format("Occupancy rate = %.1f%%", rate));
    }
    public String getStudentListAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < studentCount; i++) {
            sb.append(i + 1).append(". ").append(students[i].toString()).append("\n");
        }
        return sb.toString();
    }


    // Getters
    public String getCode() { return code; }
    public String getName() { return name; }

    // Display all students in the major
    public void displayStudents() {
        System.out.println("The list of students in the " + name + " major is:");
        System.out.print(getStudentListAsString());
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, code);
    }


}
