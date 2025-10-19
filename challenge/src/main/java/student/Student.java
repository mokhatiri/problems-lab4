package student;

public class Student extends Person {
    private String cne;
    private Major major;

    public Student(String lastName, String firstName, String phone, String email, String cne, Major major) {
        super(lastName, firstName, phone, email);
        this.cne = cne;
        this.major = major;
        if (major != null) {
            major.addStudent(this);
        }
    }
    public Student(String lastName, String firstName, String phone, String email, String cne) {
        this(lastName, firstName, phone, email, cne, new Major("23", "Computer Science"));
    }

    // Getters
    public String getCne() { return cne; }
    public Major getMajor() { return major; }
    // Setters
    public void setCne(String cne) { this.cne = cne; }
    public void setMajor(Major major) { this.major = major; }

    public String getFullNameFormatted() {
        return String.format("%s, %s", lastName.toUpperCase(), firstName);
    }

    @Override
    public String toString() {
        return String.format("%s  %s %s", cne, lastName, firstName);
    }
}

