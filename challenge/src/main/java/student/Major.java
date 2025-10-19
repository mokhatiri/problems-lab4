package student;

public class Major {
    private static int nextMajorId = 1;
    private static final int MAXIMUM_STUDENTS_CAPACITY = 50;
    private int majorId;
    private String majorCode;
    private String majorName;
    private Student[] enrolledStudents;
    private int enrolledStudentCount;

    public Major(String majorCode, String majorName) {
        this.majorId = nextMajorId++;
        this.majorCode = majorCode;
        this.majorName = majorName;
        this.enrolledStudents = new Student[MAXIMUM_STUDENTS_CAPACITY];
        this.enrolledStudentCount = 0;
    }

    // Method to add a student
    public void addStudent(Student student) {
        if (enrolledStudentCount < MAXIMUM_STUDENTS_CAPACITY) {
            enrolledStudents[enrolledStudentCount++] = student;
        } else {
            System.out.println("Cannot add student: capacity full for " + majorName);
        }
    }

    public Student findStudentByCNE(String studentId) {
        for (int i = 0; i < enrolledStudentCount; i++) {
            if (enrolledStudents[i].getStudentId().equals(studentId)) {
                return enrolledStudents[i];
            }
        }
        return null;
    }

    public boolean removeStudent(String studentId) {
        for (int i = 0; i < enrolledStudentCount; i++) {
            if (enrolledStudents[i].getStudentId().equals(studentId)) {
                // Shift remaining students left
                for (int j = i; j < enrolledStudentCount - 1; j++) {
                    enrolledStudents[j] = enrolledStudents[j + 1];
                }
                enrolledStudents[--enrolledStudentCount] = null;
                return true;
            }
        }
        return false;
    }

    public int getEnrolledStudentCount() {
        return enrolledStudentCount;
    }

    public void displayOccupancyRate() {
        System.out.println(majorName + " capacity: " + MAXIMUM_STUDENTS_CAPACITY + " students");
        System.out.println("Current enrollment: " + enrolledStudentCount + " students");
        double rate = (enrolledStudentCount * 100.0) / MAXIMUM_STUDENTS_CAPACITY;
        System.out.printf("Occupancy rate = %.1f%%\n", rate);
    }

    public String getEnrolledStudentsList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < enrolledStudentCount; i++) {
            sb.append(i + 1).append(". ").append(enrolledStudents[i].toString()).append("\n");
        }
        return sb.toString();
    }


    // Getters
    public String getMajorCode() { return majorCode; }
    public String getMajorName() { return majorName; }

    // Display all students in the major
    public void displayStudents() {
        System.out.println("The list of students in the " + majorName + " major is:");
        System.out.print(getEnrolledStudentsList());
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", majorName, majorCode);
    }


}
