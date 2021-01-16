/*
- vehicle: Vehicle
- parcelsId: int[]
- destinationLat: double[]
- destinationLong: double[]
- status: String[]
- count: int
- nextParcel: int

+ Job(vehicle: Vehicle)
+ add(parcelsId: int, lat:double, longi:double):void
+ expand():void
+ nextStop(): double[]
+ deliverNextParcel(): int
+ toString(): String
 */


/**
 *
 * @author Praisan
 */
public class Job {

    private Vehicle vehicle;
    private int[] parcelsId;
    private double[] destinationLat;
    private double[] destinationLong;
    private String[] status;
    private int count;
    private int nextParcel;

    public Job(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.parcelsId=new int[10];
        this.destinationLat=new double[10];
        this.destinationLong=new double[10];
        this.status=new String[10];
    }
    
    public void add(int parcelsId, double lat, double longi){
        this.parcelsId[count]=parcelsId;
        this.destinationLat[count]=lat;
        this.destinationLong[count]=longi;
        this.status[count]="Added";
        this.count++;
        if(this.count==this.parcelsId.length){
            expand();
        }
    }
    
    private void expand(){
        int[] temp=new int[parcelsId.length+10];
        System.arraycopy(parcelsId, 0, temp, 0, count);
        this.parcelsId=temp;
        
        double[] temp2 = new double[destinationLat.length+10];
        System.arraycopy(destinationLat, 0, temp2, 0, count);
        this.destinationLat=temp2;
        
        double[] temp3 = new double[destinationLong.length+10];
        System.arraycopy(destinationLong, 0, temp3, 0, count);
        this.destinationLong=temp3;
        
        String[] temp4 = new String[status.length+10];
        System.arraycopy(status, 0, temp4, 0, count);
        this.status=temp4;
    }  
    
    public double[] nextStop(){
        if(this.nextParcel==this.count){
            return null;
        }
        double[] latLong=new double[2];
        latLong[0]=this.destinationLat[this.nextParcel];
        latLong[1]=this.destinationLong[this.nextParcel];
        return latLong;
    }

    public int deliverNextParcel(){
        if(this.nextParcel==this.count){
            return -1;
        }
        this.status[this.nextParcel]="delivered";
        return this.parcelsId[this.nextParcel++];
        
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.vehicle.toString());
        str.append("\n");
        for(int i=0;i<this.count;i++){
            str.append(" ");
            str.append(this.parcelsId[i]);
            str.append(" ");
            str.append(this.destinationLong[i]);
            str.append(" ");
            str.append(this.destinationLat[i]);
            str.append(" ");
            str.append(this.status[i]);
            str.append("\n");
        }
        return str.toString();
    }
    
}
