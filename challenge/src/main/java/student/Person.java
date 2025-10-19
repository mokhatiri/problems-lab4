package student;

public class Person {
    private static int personIdCounter = 1;
    protected int personId;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String emailAddress;

    public Person() {
        this.personId = personIdCounter++;
    }
    public Person(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.personId = personIdCounter++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public int getId() { return personId; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }


    @Override
    public String toString() {
        return String.format("%d  %s %s", personId, lastName, firstName);
    }
}

