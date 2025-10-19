package student;

public class Instructor extends Person{
    private String employeeNumber;
    public Instructor() {
        super();
    }
    public Instructor(String firstName, String lastName, String phone, String email, String employeeNumber) {
        super(firstName, lastName, phone, email);
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String cleanEmployeeNumber() {
        if (employeeNumber == null) return null;
        return employeeNumber.trim().replaceAll("\\s+", "");
    }
    public String summaryLine() {
        return String.format("Instructor[employeeNumber=%s, lastName=%s, firstName=%s]",
                employeeNumber, lastName, firstName);
    }
    public String toCard() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instructor ----------\n");
        sb.append("Employee #: ").append(employeeNumber).append("\n");
        sb.append("Name      : ").append(lastName).append(", ").append(firstName).append("\n");
        sb.append("Email     : ").append(email).append("\n");
        sb.append("Phone     : ").append(phone).append("\n");
        return sb.toString();
    }
    public String displayName() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null) sb.append(lastName);
        if (firstName != null) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(firstName);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return summaryLine();
    }

}
