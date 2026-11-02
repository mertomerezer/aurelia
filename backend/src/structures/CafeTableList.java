package structures;

import model.CafeTable;

public class CafeTableList {
    private TableNode head = null;
    private TableNode tail = null;

    public boolean addTable(CafeTable cafeTable) { //Tek yönlü bağlı liste (LinkedList)

        if (cafeTable == null) {
            return false;
        }

        if (findByTableNumber(cafeTable.getTableNumber()) != null) {
            return false;
        }

        TableNode node = new TableNode(cafeTable);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        return true;
    }

    public CafeTable findByTableNumber(int tableNumber) { //Tek yönlü bağlı liste (LinkedList)
        TableNode temp = head;

        while (temp != null) {
            CafeTable table = temp.getCafeTable();

            if (table.getTableNumber() == tableNumber) {
                return table;
            }

            temp = temp.getNext();
        }
        return null;
    }


}
