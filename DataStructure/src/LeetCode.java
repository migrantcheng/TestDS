import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class LeetCode {

	public static String intToRoman(int num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String result = "";
        while(num>=1000){
            result += "M";
            num -= 1000;
        }
        if(num>=100){
        switch (num/100) {
            case 1:  result += "C";
                     num = num%100;
                     break;
            case 2:  result += "CC";
                    num = num%100;
                     break;
            case 3:  result += "CCC";
                    num = num%100;
                     break;
            case 4:  result += "CD";
                    num = num%100;
                     break;
            case 5:  result += "D";
                    num = num%100;
                     break;
            case 6:  result += "DC";
                    num = num%100;
                     break;
            case 7:  result += "DCC";
                    num = num%100;
                     break;
            case 8:  result += "DCCC";
                    num = num%100;
                     break;
            case 9:  result += "CM";
                    num = num%100;
                     break;
        }
        }
        if(num>=10){
        switch (num/10) {
            case 1:  result += "X";
                     num = num%10;
                     break;
            case 2:  result += "XX";
                    num = num%10;
                     break;
            case 3:  result += "XXX";
                    num = num%10;
                     break;
            case 4:  result += "XL";
                    num = num%10;
                     break;
            case 5:  result += "L";
                    num = num%10;
                     break;
            case 6:  result += "LX";
                    num = num%10;
                     break;
            case 7:  result += "LXX";
                    num = num%10;
                     break;
            case 8:  result += "LXXX";
                    num = num%10;
                     break;
            case 9:  result += "XC";
                    num = num%10;
                     break;
        }
        }
        if(num<10){
        switch (num) {
            case 1:  result += "I";
                     break;
            case 2:  result += "II";
                     break;
            case 3:  result += "III";
                     break;
            case 4:  result += "IV";
                     break;
            case 5:  result += "V";
                     break;
            case 6:  result += "VI";
                     break;
            case 7:  result += "VII";
                     break;
            case 8:  result += "VIII";
                     break;
            case 9:  result += "IX";
                     break;
        }
        }
        return result;
        
    }
	
	public static double findMedianSortedArrays(int A[], int B[]) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] temp = new int[A.length+B.length];
        int index = 0;
        int indexA = 0;
        int indexB = 0;
        while(indexA<A.length && indexB<B.length){
            if(A[indexA]>B[indexB]){
                temp[index++]=B[indexB++];
            }else{
                temp[index++]=A[indexA++];
            }
        }
        for(int i=indexA; i<A.length; i++){
            temp[index++] = A[i];
        }
        for(int i=indexB; i<B.length; i++){
            temp[index++] = B[i];
        }
        
        int length = A.length + B.length;
        if(length%2==0){

        	double result = temp[length/2 - 1] + temp[length/2];

        	return result/2;
        }else{
        	return (double)temp[length/2];
        }
        
    }
	
	public int romanToInt(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		HashMap romanToInt = new HashMap<String, Integer>();
		romanToInt.put("I", 1);
		
		return 0;
    }
	
	
	    public static boolean isValid(String s) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        boolean result = true;
	        Stack<Character> charStack = new Stack<Character>();
	        
	        for(int i=0; i < s.length(); i++){
	            charStack.push(s.charAt(i));
	        }
	        while(charStack.size()>0){
	            char right = charStack.pop();
	            if(right=='('||right=='['||right=='{'){
	            	result = false;
	            	break;
	            }
	            if(charStack.size()==0){
	            	result = false;
	                break;
	            }else{
	                char left = charStack.pop();
	                if(right==')'){
	                    if(left!='('){
	                        result=false;
	                    }
	                }else if(right==']'){
	                    if(left!='['){
	                        result = false;
	                    }
	                    
	                }else if(right=='{'){
	                    if(left!='}'){
	                        result = false;
	                    }
	                }
	            }
	            if(!result){
	                break;
	            }
	            
	        }
	        
	        return result;
	        
	    }
	
	    public static ListNode deleteDuplicates(ListNode head) {
	        if(head == null)
	            return null;
	        ListNode index = head;
	        ListNode preIndex = head;
	        boolean found = false;
	        while(index!=null && index.next!=null){
	            ListNode temp = index;
	            found = false;
	            while(temp.next!=null ){
	            	if(temp.val == index.val){
	                    found = true;
	                    temp = temp.next;
	                }
	                temp = temp.next;
	            }
	            if(found){
	                if(preIndex == head){
	                    head = index.next;
	                }
	                preIndex.next = index.next;
	                
	            }else{
	                if(preIndex != index){
	                    preIndex = index;
	                }
	            }
	            index = index.next;
	        }
	        
	        return head;
	        
	    }
	    
	    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        if(triangle == null){
	            return 0;
	        }
	        int length = triangle.size();
	        int[][] opt = new int[length][length];
	        opt[0][0]=triangle.get(0).get(0);
	        
	        for(int i =1; i<length; i++){
	            ArrayList<Integer> tempList = triangle.get(i);
	            for(int j = 0; j<=i; j++){
	                if(j==0){
	                    opt[i][j] = opt[i-1][j]+tempList.get(j);
	                }else if(j==i){
	                    opt[i][j] = opt[i-1][j-1]+tempList.get(j);
	                }else{
	                    opt[i][j] = ((opt[i-1][j-1]<opt[i-1][j])?opt[i-1][j-1]:opt[i-1][j])+tempList.get(j);
	                }
	            }
	        }
	        int min = opt[length-1][0];
	        for(int i =1; i<triangle.size(); i++){
	            if(min>opt[length-1][i])
	                min = opt[length-1][i];
	        }
	        return min;
	        
	    }
	    
	    public static ArrayList<Integer> getRow(int rowIndex) {
	        if(rowIndex<0)
	           return null;
	        ArrayList<Integer> resultList = new ArrayList<Integer>();
	        resultList.add(1);
	        for(int i =1; i<=rowIndex; i++){
	        	int old =1;
	            for(int j =1; j<=i; j++){
	                
	                if(j==i){
	                    resultList.add(1);
	                }else{
	                    int temp = resultList.get(j);
	                    resultList.set(j, old + temp);
	                    old = temp;
	                }
	            }
	        }
	        
	        return resultList;
	    }
	    
	    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
	        if(matrix==null ){
	            return null;
	        }
	        if(matrix.length==0){
	        	return new ArrayList<Integer>();
	        }
	        int startX = 0;
	        int endX = matrix[0].length-1;
	        int startY = 0;
	        int endY = matrix.length-1;
	        
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        
	        while(startX<=endX && startY<=endY){
	            for(int i =startX; i<=endX; i++){
	                list.add(matrix[startY][i]);
	            }
	            startY++;
	            for(int i=startY; i<=endY; i++){
	                list.add(matrix[i][endX]);
	            }
	            endX--;
	            for(int i=endX; i>=startX; i--){
	                list.add(matrix[endY][i]);
	            }
	            endY--;
	            for(int i=endY; i>=startY; i--){
	                list.add(matrix[i][startX]);
	            }
	            startX++;
	        }
	        
	        return list;
	        
	    }
	    
	public static void main(String[] args){
//		int[] A = {};
//		int[] B = {2,3};
//		System.out.println(findMedianSortedArrays(A, B));
//		for(int i =100; i<=199; i++){
//			System.out.println(intToRoman(i));
//		}
//		System.out.println(isValid("(("));
		
//		System.out.println("abc"+"123");
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(1);
//		deleteDuplicates(head);
//		System.out.println(getRow(2));
		int[][] array = new int[0][0];
//		array[0][0] = 1;
		System.out.println(spiralOrder(array));
	}
	
	
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
