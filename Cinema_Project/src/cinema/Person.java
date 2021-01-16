package cinema;

public abstract class Person {
    private long personId;
    private String firstname;
    private String lastname;

    public Person(long personId, String firstname, String lastname) {
        this.personId = personId;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getPersonId() {
        return personId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
    
    
}
