package Arrays;

public class Company {

    private CompanyData[] company;
    private int count = 0;

    public Company(int size) {
        if (size <= 0) {
            company = new CompanyData[1];
        }
        company = new CompanyData[size];
    }

    public boolean isFull() {
        return count == company.length; //ถ้าเต็มจะเป็น True
    }

    public boolean expand() {
        if (isFull()) {
            CompanyData[] temp = new CompanyData[company.length + 1]; //สร้าง temp มารองรับค่า
            System.arraycopy(company, 0, temp, 0, count);//ช่องแรกคือArrayเก่า ช่องที่สองเริ่มจากช่องที่0ของช่องแรก ช่องที่สามคือ​Array tempเก็บอันใหม่ เริ่มจาก0ของอันใหม่ count คือก้อปอาเรย์ทั้งหมด(กี่ตัว)
            company = temp;
            return true;
        } else {
            return false;
        }
    }

    public void add(String name, int employeeId) {
        expand();
        company[count++] = new CompanyData(name, employeeId); //นำไปใส่ไว้ใน Constructor ของ CompanyData

    }

    public int searchName(String name) {
        for (int i = 0; i < company.length; i++) {
            if (company[i].getCompanyName() == null) { //หากเจอnull
                continue;                               //ให้ทำลูปต่อไป
            } else if (company[i].getCompanyName().equals(name)) {
                return i;
            }
        }
        System.out.println("Not Found");
        return -1;
    }

    public void display() {
        for (int i = 0; i < company.length; i++) { //Arrayต้องปริ้นทีละช่อง
            System.out.println(company[i]);
        }
    }

    public boolean remove(String name) { //กรณีลบArray ช่องกลางเช่น มี5ช่องเราลบช่อง3
        int index = searchName(name);
        if (index == -1) {
            System.out.println("Can't Remove");
            return false;
        } else if (index != -1) {
            company[index] = null;
            count--;
            for (int i = index; i < count; i++) { //เลื่อนช่อง
                this.company[i] = company[i + 1];
                this.company[i + 1] = null;
            }
            CompanyData[] temp = new CompanyData[company.length - 1];
            System.arraycopy(company, 0, temp, 0, count);
            company = temp;
            System.out.println("Remove Success!!!");
        }
        return true;
    }

    @Override
    public String toString() {
        return "Company{" + "company=" + company + ", count=" + count + '}';
    }

}
