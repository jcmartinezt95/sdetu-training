package basics;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Item {

	private static final DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private String name;
    private String itemId;
    private String newID2;
    private String storeID;
    private double itemP;
    private String pKey;
    private int quantity;
     //ArrayList<Item> produ= new ArrayList<Item>();

    public Item(String name, String itemId) {
        this.name=name;
        this.itemId=itemId;
    }
    
    public Item(String pKey,String productN, String productID,double productP,int quantity) {
        this.pKey=pKey;
    	this.name=productN;
        this.itemId=productID;
        this.itemP=productP;
        this.quantity=quantity;
        
    }
    public void agregar(int added) {
    	
    	this.quantity+=added;
	}
    
    public void remover(int removed) {
    	
    	this.quantity-=removed;
	}


    public void add() {
        this.quantity++;
    }

    public void remove() {
        this.quantity--;
    }

	public String getpKey() {
		return pKey;
	}

	public void setpKey(String pKey) {
		this.pKey = pKey;
	}
	
    public String getName() {
        return this.name;
    }

    public String getItemId() {
        return this.itemId;
    }
    

    public double getItemP() {
		return itemP;
	}

	public void setItemP(double itemP) {
		this.itemP = itemP;
	}

    public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
        String s="";
        s+=" pkey = "+this.pKey;
        s+=" name = "+this.name;
        s+=" , id = "+this.itemId;
        s+=" , price = "+this.itemP;
        s+=" , quantity = "+this.quantity;
        return s;
    }
}