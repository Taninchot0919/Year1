
public class BusinessContact extends Contact implements Comparable<BusinessContact>{

    private Company company;
    private String jobTitle;

    public BusinessContact(Company company, String jobTitle, Address address, String email, String phone, ContactType type) {
        super(address, email, phone, type);
        this.company = company;
        this.jobTitle = jobTitle;
    }

    @Override
    public int compareTo(BusinessContact o) {
       return this.company.getName().compareTo(o.company.getName());
    }

    public Company getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return "BusinessContact{" + "company=" + company + ", jobTitle=" + jobTitle + '}';
    }


}
