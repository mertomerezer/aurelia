package service;

import model.CafeTable;
import structures.CafeTableList;


public class TableService {
    private CafeTableList tableList;

    public TableService(CafeTableList tableList) {
        this.tableList = tableList;
    }

    public boolean addTable(CafeTable table) {
        return tableList.addTable(table);
    }

    public CafeTable findByTableNumber(int tableNumber) {
        return tableList.findByTableNumber(tableNumber);
    }

    public boolean removeTable(int tableNumber) {
        return tableList.removeTable(tableNumber);
    }

    public boolean setTableOccupied(int tableNumber,boolean occupied){
        return tableList.setTableOccupied(tableNumber,occupied);
    }


    public int getTableCount(){
        return tableList.getTableCount();
    }


    public CafeTable getTableAt(int index){
        return tableList.getTableAt(index);

    }

}
