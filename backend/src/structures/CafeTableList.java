package structures;

import model.CafeTable;

public class CafeTableList {
    private TableNode head = null;
    private TableNode tail = null;

    public boolean addTable(CafeTable cafeTable) { //Tek yönlü bağlı liste (LinkedList)

        if (cafeTable == null) {
            return false;
        }

        if(cafeTable.getTableNumber()<=0){
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


    public boolean setTableOccupied(int tableNumber, boolean occupied) { //Listede numarası verilen masanın doluluk durumunu güncelleme

        CafeTable table = findByTableNumber(tableNumber);

        if (table == null) {
            return false;
        }

        table.setOccupied(occupied);
        return true;
    }


    public boolean removeTable(int tableNumber) { //Listede numarası verilen masayı listeden kaldırma

        TableNode temp = head;
        TableNode previous = null;

        while (temp != null) {
            if (temp.getCafeTable().getTableNumber() == tableNumber) {
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }

        if (temp == null) {
            return false;
        }
        if (temp.getCafeTable().isOccupied()) {
            return false;
        }

        if (previous == null) {
            head = temp.getNext();
        } else {
            previous.setNext(temp.getNext());
        }

        if (temp == tail) {
            tail = previous;
        }

        return true;
    }

    public void displayTables() { //Masa listesini göster
        TableNode temp = head;
        if (temp == null) {
            System.out.println("Masa listesi boş");
            return;
        }

        while (temp != null) {
            System.out.println(temp.getCafeTable());
            temp = temp.getNext();
        }
    }


    //Masa listesini özellikle numaraya göre sıralamak lazım mı hocaya sorulacak
    //Bu classta Bağlı Liste(LinkedList)
    //-Ekleme : addTable()
    //-Arama : findByTableNumber()
    //-Güncelleme : setTableOccupied() -> masa numarasına göre doluluk durumunu değiştiriyor
    //-Silme : removeTable() -> masa bulunamazsa veya doluysa silmiyor


    //-displayTables() -> Masa düğümlerini sırayla konsola yazdırma
    // Örnek çıktı (önce 3 numaralı boş, sonra 7 numaralı dolu masa eklenmiş):
    // CafeTable{Masa Numarası = 3, Durum Boş}
    // CafeTable{Masa Numarası = 7, Durum Dolu}


}