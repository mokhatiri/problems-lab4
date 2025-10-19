package student;

public class Instructor extends Person {
    private String employeeId;

    public Instructor() {
        super();
    }
    
    public Instructor(String firstName, String lastName, String phoneNumber, String emailAddress, String employeeId) {
        super(firstName, lastName, phoneNumber, emailAddress);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String cleanEmployeeId() {
        if (employeeId == null) return null;
        return employeeId.trim().replaceAll("\\s+", "");
    }
    
    public String summaryLine() {
        return String.format("Instructor[employeeId=%s, lastName=%s, firstName=%s]",
                employeeId, lastName, firstName);
    }
    
    public String toCard() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instructor ----------\n");
        sb.append("Employee #: ").append(employeeId).append("\n");
        sb.append("Name      : ").append(lastName).append(", ").append(firstName).append("\n");
        sb.append("Email     : ").append(emailAddress).append("\n");
        sb.append("Phone     : ").append(phoneNumber).append("\n");
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
