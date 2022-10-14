public class Node {
	
	public double num;
	public Node next;
	
	public Node(double num) {
		this.num = num;
		next = null;
	}
	
	public double getNum() {
		return num;
	}
	
	public void setNum(double num) {
		this.num = num;
	}
}
