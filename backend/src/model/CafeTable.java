package model;

public class CafeTable {
    private int tableNumber;
    private boolean occupied;

    public CafeTable(int tableNumber,boolean occupied){
        this.tableNumber=tableNumber;
        this.occupied=occupied;
    }

    public int getTableNumber(){
        return tableNumber;
    }
    public boolean isOccupied(){
        return occupied;
    }

    //Masa numaraları sabit olacağı için setTableNumber yok

    public void setOccupied(boolean occupied){
        this.occupied=occupied;
    }


    @Override
    public String toString(){
        String status;

        if(occupied){
            status ="Dolu";
        }else{
            status = "Boş";
        }

        return "CafeTable{Masa Numarası = "+tableNumber +", Durum " + status+"}";


    }
}
