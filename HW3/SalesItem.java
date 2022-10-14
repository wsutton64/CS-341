package HW3;
public class SalesItem {

	String name;
	Double price;
	Integer quant;
	
	public SalesItem(String n, Double p, Integer q) {
		name = n;
		price = Math.floor((p * q) * 100) / 100;
		quant = q;
	}

	// Setter and Getters
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

	public Integer getQuant() {
		return quant;
	}

	public String toString() {
		return name + "\t$" + price + "\t" + quant;
	}
}
