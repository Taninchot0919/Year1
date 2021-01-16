
import java.time.LocalDate;
import java.util.Comparator;

public class PersonContact extends Contact{
    private Person person;
    private LocalDate dateOfBirth;

    static class firstNameComparator implements Comparator<PersonContact>{
        @Override
        public int compare(PersonContact o1, PersonContact o2) {
            return o1.person.getFirstName().compareTo(o2.person.getFirstName());
        }
    }
    
    static class lastNameComparator implements Comparator<PersonContact>{
        @Override
        public int compare(PersonContact o1, PersonContact o2) {
            return o1.person.getLastName().compareTo(o2.person.getLastName());
        }
    }

    public PersonContact(Person person, LocalDate dateOfBirth, Address address, String email, String phone, ContactType type) {
        super(address, email, phone, type);
        this.person = person;
        this.dateOfBirth = dateOfBirth;
    }

    public Person getPerson() {
        return person;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "PersonContact{" + "person=" + person + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
}
