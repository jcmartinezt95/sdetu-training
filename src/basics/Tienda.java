package basics;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Tienda {

	private static final DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private String storeN;
    private String storeId;
    private String newID;
    private int quantity;
    private double itemP;
    private ArrayList<Item> produ= new ArrayList<Item>();

    public Tienda(String storeN,String storeID,ArrayList<Item> produ) {
        this.storeN=storeN;
        this.storeId=storeID;
        this.produ=produ;
        
    }
    public Tienda(String storeN, String storeId) {
        this.storeN=storeN;
        this.storeId=storeId;
    }

    public void add() {
        this.quantity++;
    }

    public void remove() {
        this.quantity--;
    }


    public String getName() {
        return this.storeN;
    }

    public String getItemId() {
        return this.storeId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toString() {
        String s="";
        s+=" name = "+this.storeN;
        s+=" , id = "+this.storeId;
        return s;
    }
}