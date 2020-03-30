package basics;
import java.util.*;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Inventory {
	//GLOBAL V
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
    private static final DateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public Inventory() {
//        this.items.add(new Item("Book", "4877326352"));
//        this.items.add(new Item("Pen", "21366363636"));
    }

    public void increaseQuantity(String itemName) {
        for (Item item : this.items) {
            if (itemName.equals(item.getName())) {
                item.add();
                return;
            }
        }
    }

    public void decreaseQuantity(String itemName) {
        for (Item item : this.items) {
            if (itemName.equals(item.getName())) {
                if (item.getQuantity()>=0) {
                    item.remove();
                }
                return;
            }
        }
    }


    public void createItem(String name, String itemId) {
        this.items.add(new Item(name,itemId));
    }

    public String toString() {
        String s="";
        s+="Inventory contains:\n";
        for (Item item:this.items) {
            s+='\t'+item.toString();
        }
        return s;
    }


    public void printInventory() {
        System.out.println(this.toString());
    }


    public static void main(String[] args) {
    	Scanner input=new Scanner(System.in);
        Inventory inventory = new Inventory();
        ArrayList<Tienda> tiendas=new ArrayList<Tienda>();
        ArrayList<Item> items=new ArrayList<Item>();
        int opcion,storeC=0,count=0;
        do {
        	System.out.println("\n------------------------------MAIN MENU------------------------------");
        	System.out.print("1:Add\n2:Show\n3:Search\n4:Modify\n\n9:EXIT\n\nOpcion:"); 
        	opcion=input.nextInt();input.nextLine();
        	switch(opcion) {
        	case 1:
        		add(count,input,tiendas,items,storeC);
        		break;
        	case 2:
        		//Print
        		printAll(input,tiendas,items);
        		break;
        	case 3:
        		//Search
        		search(input,tiendas,items);
        		break;
        	case 4:
        		//Modify
        		printAll(input,tiendas,items);
        		modify(input,tiendas,items);
        	default:
        		//System.out.println("Invalid");
        		break;
        	}
        }while(opcion!=9);
    }
    public static void modify(Scanner input,ArrayList<Tienda> tiendas,ArrayList<Item> items) {
    	String modify;
    	String modify2;
    	Date date = new Date();
    	Item producto =null;
    	int option;
    	boolean ansF=false;
    	System.out.println("\n------------------------------MODIFY MENU------------------------------");
    	do {
    		System.out.println("\n1:Modify Product Quantity\n2:Modify Store Products\n\n9:EXIT\n\nOpcion:");
        	option=input.nextInt();input.nextLine();
    		switch(option) {
    		case 1:
		    	System.out.print("ProductID to modify: ");
		    	modify=input.next();input.nextLine();
		    	int opcion,added=0,removed=0;
		        do {
		        	System.out.println("\n------------------------------Modify Product Quantity------------------------------");
		        	System.out.println("\n1:Add Product Quantity\n2:Remove Product Quantity\n\n9:EXIT\n\nOpcion:");
		        	opcion=input.nextInt();input.nextLine();
		        	switch(opcion) {
		        	case 1:
		        		for(int i=0;i<items.size();i++) {
		    	    		boolean ans=items.get(i).getItemId().contains(modify);
		    	    		if(ans) {
		    	    			System.out.println("\n------------------------------Add Product Quantity------------------------------");
		    	    			System.out.println("\nHow many shall be added?: ");
		    	    			added=input.nextInt();input.nextLine();
		    	    			items.get(i).agregar(added);
		    		    	}
		    	    	}
		        		break;
		        	case 2:
		        		for(int j=0;j<items.size();j++) {
		    	    		boolean ans=items.get(j).getItemId().contains(modify);
		    	    		if(ans) {
		    	    			System.out.println("\n------------------------------Remove Product Quantity------------------------------");
		    	    			System.out.println("\nHow many shall be removed?: ");
		    	    			removed=input.nextInt();input.nextLine();
		    	    			items.get(j).remover(removed);
		    		    	}
		    	    	}
		        	}
		        }while(opcion!=9);
		        break;
    		case 2:
    			System.out.print("StoreID to modify: ");
		    	modify2=input.next();input.nextLine();
		        do {
		        	System.out.println("\n------------------------------Modify Store Products------------------------------");
		        	System.out.println("\n1:Add Product \n2:Remove Product\n\n9:EXIT\n\nOpcion:");
		        	opcion=input.nextInt();input.nextLine();
		        	switch(opcion) {
		        	case 1:
		        		String pKey2=modify2;
		        		System.out.println("\n------------------------------Add Product------------------------------");
		    			System.out.println("\nProduct name: ");
		    			String equis=input.nextLine();
		    			String productN = equis.toUpperCase();
		    			for(int l=0;l<items.size();l++) {
		    	    		boolean ans=items.get(l).getName().contains(productN);
		    	    		ansF=ans;
		    	    		if(ans) {
		    	    			System.out.println("\nProduct already exists\n");
		    	    			break;
		    	    			}
		    	    		}
		    			if(!ansF) {
			    			int random3=(int) (Math.random()*10000);
			        		String str3 = String.valueOf(random3);
			        		String productID=sdf.format(date)+productN.substring(0,2)+str3;
			        		System.out.println("\nPrice: ");
			        		double productP=input.nextInt();input.nextLine();
			        		System.out.println("\nQuantity: ");
			        		int quantity=input.nextInt();input.nextLine();
			        		producto= new Item(pKey2,productN,productID,productP,quantity);
				        	items.add(producto);
		    			}
		        		break;
		        	case 2:
		        		System.out.println("\n------------------------------Remove Product------------------------------");
		        		System.out.println("\nProduct ID to remove: ");
		        		String produID=input.nextLine();
		        		for(int j=0;j<items.size();j++) {
		    	    		boolean ans=items.get(j).getItemId().contains(produID);
		    	    		if(ans) {
		    	    			items.remove(j);
		    		    	}
		    	    	}
		        	}
		        }while(opcion!=9);
		        break;
    		}
    		
    	}while(option!=9);
    }
    public static void search(Scanner input,ArrayList<Tienda> tiendas,ArrayList<Item> items) {
    	String search;
    	System.out.println("\n------------------------------SEARCH------------------------------");
    	System.out.print("Product to search: ");
    	String ser=input.nextLine();
    	search = ser.toUpperCase();
    	for(int i=0;i<items.size();i++) {
    		boolean ans=items.get(i).getName().contains(search);
    		if(ans) {
	    		System.out.println("\n\tStoreID:" +items.get(i).getpKey());
	    		System.out.println("\tProduct:" +items.get(i).getName());
	        	System.out.println("\tID:" +items.get(i).getItemId());
	    		System.out.println("\tPrice:" +items.get(i).getItemP());
	    		System.out.println("\tQuantity:" +items.get(i).getQuantity());
	    		}
    	}
    	System.out.println("\nTo go back to the menu press any button and hit enter: ");
    	String exit2=input.nextLine();
    }
    public static void printAll(Scanner input,ArrayList<Tienda> tiendas,ArrayList<Item> items){
    	System.out.println("\n------------------------------TABLE------------------------------");
    	for(int i=0;i<tiendas.size();i++) {
    		System.out.println("\nStore:" +tiendas.get(i).getName());
    		System.out.println("ID:" +tiendas.get(i).getItemId());
    		for(int j=0;j<items.size();j++) {
    			boolean ans=items.get(j).getpKey().contains(tiendas.get(i).getItemId());
    			if(ans) {
	    			System.out.println("\n\tStoreID:" +items.get(j).getpKey());
	    			System.out.println("\tProduct:" +items.get(j).getName());
	        		System.out.println("\tID:" +items.get(j).getItemId());
	    			System.out.println("\tPrice:" +items.get(j).getItemP());
	    			System.out.println("\tQuantity:" +items.get(j).getQuantity());
	    			}
    		}
    		//ArrayList <Items> produc= tiendas.get(i).
    	}
    	System.out.println("\nTo continue press 'C' and hit enter: ");
    	String exit=input.nextLine();
    }
    public static ArrayList<Tienda> add(int count,Scanner input,ArrayList<Tienda> tiendas,ArrayList<Item> items,int storeC){
    	//ArrayList<Item> produ= new ArrayList<Item>();
    	Tienda store;
    	Item producto;
    	++storeC;
    	String pKey;
    	int state=0;
    	boolean ansF=false;
    	boolean ansF2=false;
    	Date date = new Date();
    	count=tiendas.size()+storeC;
    	for(int i=tiendas.size(); i<count; i++) {
    		System.out.println("\n------------------------------Add Store------------------------------");
    		System.out.println("\nStore name: ");
    		String sN = input.nextLine();
        	String storeN = sN.toUpperCase();
    		for(int k=0;k<tiendas.size();k++) {
    			
	    		boolean ans2=tiendas.get(k).getName().contains(storeN);
	    		ansF=ans2;
	    		if(ans2) {
	    			System.out.println("\nStore already exists\n");
	    			break;
	    			}
	    		}
    		if(!ansF) {
	    		int random = (int) (Math.random()*10000);
	    		String str = String.valueOf(random);
	    		String storeID=str+storeN.substring(0,2)+sdf.format(date);
	    		pKey=storeID;
	    		
	    		do{
		    		System.out.println("\nAdd products? Y/N: ");
		    		String productADD=input.nextLine();
		    		
		    		if(productADD.equalsIgnoreCase("Y")) {
		    			String pKey2=pKey;
		    			System.out.println("\n------------------------------Add Product------------------------------");
		    			System.out.println("\nProduct name: ");
		    			String pN = input.nextLine();
		            	String productN = pN.toUpperCase();
		            	for(int l=0;l<items.size();l++) {
		    	    		boolean anss=items.get(l).getName().contains(productN);
		    	    		ansF2=anss;
		    	    		if(anss) {
		    	    			System.out.println("\nProduct already exists\n");
		    	    			break;
		    	    			}
		    	    		}
		            	if(!ansF2) {
			    			int random2=(int) (Math.random()*10000);
			        		String str2 = String.valueOf(random2);
			        		String productID=sdf.format(date)+productN.substring(0,2)+str2;
			        		System.out.println("\nPrice: ");
			        		double productP=input.nextInt();input.nextLine();
			        		System.out.println("\nQuantity: ");
			        		int quantity=input.nextInt();input.nextLine();
			        		producto= new Item(pKey2,productN,productID,productP,quantity);
				        	items.add(producto);
		            	}
		    		}
		    		else if(productADD.equalsIgnoreCase("n"))
		    			state=1;
	    		}while(state==0);
	    		store=new Tienda(storeN,storeID);
	        	tiendas.add(store);
    		}
    	}
    	
    	return tiendas;
    }

}