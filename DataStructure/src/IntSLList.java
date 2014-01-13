
public class IntSLList {
	private IntNode head, tail;
	
	public IntSLList(){
		head = tail = null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void addToHead(int i){
		IntNode newNode = new IntNode(i,head);
		head = newNode;
		if(tail == null)
			tail = head;
	}
	
	public void addToTail(int i){
		if(!isEmpty()){
			IntNode newNode = new IntNode(i);
			tail.next = newNode;
			tail = tail.next;
		}else{
			head = tail = new IntNode(i);
		}
	}
	
	public int deleteFromHead(){
		int info = head.getInfo();
		if(head == tail){
			head = tail = null;
		}else{
			head = head.next;
		}
		return info;
	}
	
	public int deleteFromTail(){
		int info = tail.getInfo();
		if(head == tail){
			head = tail = null;
		}else{
			IntNode temp = head;
			while(temp.next != tail){
				temp = temp.next;
			}
			temp.next = null;
			tail = temp;
		}
		return info;
	}
	
	public void printAll(){
		IntNode temp = head;
		while(temp != null){
			System.out.print(temp.info + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public boolean isInList(int num){
		IntNode temp = head;
		while(temp != null){
			if(temp.getInfo() == num){
				break;
			}else{
				temp = temp.next;
			}
		}
		return temp != null;
	}
	
	public void delete(int num){
		if(head == tail && head.getInfo() == num){
			head = tail = null;
		}else if(head.getInfo() == num){
			head = head.next;
		}else{
			IntNode temp, pre;
//			for( pre = head, temp = head.next;
//				 temp!=null && temp.getInfo()!=num;
//				 pre = temp, temp = temp.next){
//				if(temp.getInfo() == num)
//			}
			pre = head;
			temp = head.next;
			while(temp!=null){
				if(temp.getInfo() == num){
					pre.next = temp.next;
					break;
				}else{
					pre = temp;
					temp = temp.next;
				}
			}
		}
	}
	
	public static void main(String[] args){
		IntSLList intList = new IntSLList();
		intList.addToTail(0);
		intList.printAll();
		intList.delete(1);
		intList.addToHead(1);
		intList.printAll();
		intList.addToTail(2);
		intList.printAll();
		intList.delete(0);
		intList.printAll();
		intList.delete(2);
		intList.printAll();
		intList.delete(1);
		intList.printAll();
	}
	
	
	
	
	
	

}
