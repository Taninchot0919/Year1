/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.base;

import java.util.Objects;

/**
 *
 * @author Umaporn
 */
public class Company {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "Company{" + "name=" + name + '}';
    }
    
}
