
public class IntNode {

	public int info;
	public IntNode next;
	
	public IntNode(int i){
		this.info = i;
	}
	
	public IntNode(int i, IntNode next){
		this.info = i;
		this.next = next;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public IntNode getNext() {
		return next;
	}

	public void setNext(IntNode next) {
		this.next = next;
	}
	
	
}
