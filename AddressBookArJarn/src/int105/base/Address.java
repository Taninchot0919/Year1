/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.base;

/**
 *
 * @author Umaporn
 */
public class Address {
    private String no;
    private String street;
    private String province;
    private String postalCode;

    public Address(String no, String street, String province, String postalCode) {
        this.no = no;
        this.street = street;
        this.province = province;
        this.postalCode = postalCode;
    }

    
    public String getNo() {
        return no;
    }

    public String getStreet() {
        return street;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" + "no=" + no + ", street=" + street + ", province=" + province + ", postalCode=" + postalCode + '}';
    }
    
    
    
}
