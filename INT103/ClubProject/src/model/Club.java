package model;
public class Club {

    private String fullname;
    private String shortname;
    private Student[] members;
    private int count;
    private Status status;
   

   public Club(String fullname, String shortname, int maxMembers) {
        this.fullname = fullname;
        this.shortname = shortname;
        this.members = new Student[maxMembers];
        status = Status.OPEN;
    }

   
    
    public boolean unsubscribe(long id) {
        int foundStudentIndex = searchMemberAt(new Student(id));
     //   System.out.println("found: "+foundStudent);
        if (foundStudentIndex == -1) {
            return false;
        }
        members[foundStudentIndex]=null;
      
        count--;
        status = Status.OPEN;
        return true;
    }

    public boolean subscribe(Student std) {
        if (status.equals(Status.CLOSE) || searchMemberAt(std) != -1) {
            return false;
        }
        for (int i = 0; i < members.length; i++) {
            if(members[i]==null){
                members[i]=std;
                count++;
                break;
            }     
        }
        
        if (count >= members.length) {
            status = Status.CLOSE;
        }
        return true;
    }
    public boolean editInfo(long studentId, String newFirstName, String newLastName, String newDepartment){
        int foundStudentIndex = searchMemberAt(new Student(studentId));
        if (foundStudentIndex == -1) {
            return false;
        }
        members[foundStudentIndex ].setFirstname(newFirstName);
        members[foundStudentIndex ].setLastname(newLastName);
        members[foundStudentIndex ].setDepartment(newDepartment);
        return true;
    }
    
   /* public Student searchMemberAt(long id) {
        for (int i = 0; i < count; i++) {
            if ((members[i].getStudentId())==(id)) {
                return members[i];
            }
        }
        return null;
    }*/
    
    public int searchMemberAt(Student std) {
        for (int i = 0; i < members.length; i++) {
            if (members[i]!=null && members[i].equals(std)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Club Name:" + fullname+ "(" + shortname+")\n");
        for (int i = 0; i < members.length; i++) {
            if(members[i]!=null){
               // System.out.println("member: "+members[i]);
                str.append(members[i]+"\n");
            }
        }
        str.append("club member: "+status);
        return str.toString();
    }

}
