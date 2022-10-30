public class Node {
	
	public String str;
	public Node next;
	
	public Node(String str) {
		this.str = str;
		next = null;
	}
	
	public String getString() {
		return str;
	}
	
	public void setNum(String str) {
		this.str = str;
	}
}
