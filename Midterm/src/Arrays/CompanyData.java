package Arrays;

public class CompanyData {
    private String CompanyName;
    private int employeeId;

    public CompanyData(String CompanyName, int employeeId) {
        this.CompanyName = CompanyName;
        this.employeeId = employeeId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "CompanyData{" + "CompanyName=" + CompanyName + ", employeeId=" + employeeId + '}';
    }
    
}
