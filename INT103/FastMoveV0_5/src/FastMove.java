

public class FastMove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehicle vehicle =new Vehicle(1,"John");
        Job job001=new Job(vehicle);
        job001.add(0, 13.662348, 100.502370);
        job001.add(1, 13.658739, 100.494089);
        
        System.out.println(job001);
    }
    
}
