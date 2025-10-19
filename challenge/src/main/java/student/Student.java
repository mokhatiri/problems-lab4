package student;

public class Student extends Person {
    private String studentId; // CNE number
    private Major major;

    public Student(String lastName, String firstName, String phoneNumber, String emailAddress, String studentId, Major major) {
        super(lastName, firstName, phoneNumber, emailAddress);
        this.studentId = studentId;
        this.major = major;
        if (major != null) {
            major.addStudent(this);
        }
    }
    public Student(String lastName, String firstName, String phoneNumber, String emailAddress, String studentId) {
        this(lastName, firstName, phoneNumber, emailAddress, studentId, new Major("23", "Computer Science"));
    }

    // Getters
    public String getStudentId() { return studentId; }
    public Major getMajor() { return major; }
    // Setters
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setMajor(Major major) { this.major = major; }

    public String getFullNameFormatted() {
        return String.format("%s, %s", lastName.toUpperCase(), firstName);
    }

    @Override
    public String toString() {
        return String.format("%s  %s %s", studentId, lastName, firstName);
    }
}

