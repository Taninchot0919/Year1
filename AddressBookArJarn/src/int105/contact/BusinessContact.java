/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.contact;

import int105.base.Address;
import int105.base.Company;

/**
 *
 * @author Umaporn
 */
public class BusinessContact extends Contact implements Comparable<BusinessContact>{
    private Company company;
    private String jobTitle;

    public BusinessContact(Address add, String email, String phone, ContactType cType, 
            Company company, String jobTitle) {
        super(add, email, phone, cType);
        this.company = company;
        this.jobTitle = jobTitle;
    }

    
    public Company getCompany() {
        return company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    
    @Override
    public int compareTo(BusinessContact o) {
        return company.getName().compareTo(o.company.getName());
    }

    @Override
    public String toString() {
        return "BusinessContact{" + "company=" + company + "\n"+ super.toString() + ", jobTitle=" + jobTitle + '}';
    }
    
    
  

 
    
    
    
}
