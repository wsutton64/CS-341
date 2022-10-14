package HW3;
import java.util.ArrayList;

public class SalesSlip {
	ArrayList<SalesItem> list = new ArrayList<SalesItem>();

	public SalesSlip() {
		
	}

	public void addItem(String n, String p, String q) {
		Double pD = Double.parseDouble(p);
		Integer qI = Integer.parseInt(q);
		SalesItem item = new SalesItem(n, pD, qI);

		list.add(item);
	}

	public Double totalSales(){
		Double total = 0.00;
		for(int i = 0; i < list.size(); i++) {
			total += list.get(i).getPrice();
		}
		return total;
	}

	public String toString(){
		String str = "";
		for(int i = 0; i < list.size(); i++){
			str = str + list.get(i).toString() + "\n";
		}
		return str;
	}
}
