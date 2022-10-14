public class HW5List {
	
	public Node head;
	public Node tail;
	
	public HW5List() {
		head = null;
		tail = null;
	}
	
	public void addNode(String str) {
		Double num = Double.parseDouble(str);
		Node temp = new Node(num);
		
		if(head == null) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
	}
}
