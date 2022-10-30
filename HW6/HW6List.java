public class HW6List {
	
	public Node head;
	public Node tail;
	public int size;
	
	public HW6List() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addNode(String str) {
		Node temp = new Node(str.trim());
		size++;
		if(head == null) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
	}

	public int getSize() {
		return size;
	}
}
