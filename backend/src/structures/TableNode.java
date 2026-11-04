package structures;
import model.CafeTable;

public class TableNode {

    private CafeTable cafeTable;
    private TableNode next;

    public TableNode(CafeTable cafeTable){
        this.cafeTable=cafeTable;
    }

    public CafeTable getCafeTable(){
        return cafeTable;
    }


    public TableNode getNext(){
        return next;
    }

    public void setNext(TableNode next){
        this.next=next;

    }
}
