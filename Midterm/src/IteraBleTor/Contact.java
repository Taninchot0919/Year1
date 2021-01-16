package IteraBleTor;

public class Contact {

    private String email;
    private String phone;

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "email=" + email + ", phone=" + phone + '}';
    }

}
