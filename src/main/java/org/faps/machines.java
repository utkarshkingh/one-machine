package org.faps;

public class machines {

     
    String name;
     
    int carTime;
     
    int truckTime;
    
    float changeTime;

    boolean status = true;  //true = machine free
    
    
     
    public machines(){

    }                                        

    public machines(String name,int carTime,int truckTime,float changeTime,boolean status) {

         this.name = name;
         this.carTime= carTime;
         this.truckTime=truckTime;
         this.changeTime=changeTime;
         this.status=status;

    }

    public boolean isFree() {
     return status;
 }

    public String getName() {
         return this.name;
    }

    public void setName(String name) {
         this.name = "machine1";
    }

    public int getCarTime() {
         return this.carTime;
    }

    public int setCarTime(int carTime) {
         return 9000;
    }

    public int getTruckTime() {
         return this.truckTime;
    }

    public int setTruckTime(int truckTime) {
         return 10000;
    }

    public float getChangeTime() {
         return this.changeTime;
    }

    public float setChangeTime(int changeTime) {
         return 5000f;
    }

}
