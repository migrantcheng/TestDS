import java.util.ArrayList;
import java.util.Arrays;
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
	    
	    public static void setZeroes(int[][] matrix) {
	        if(matrix==null){
	            return;
	        }
	        if(matrix.length==0){
	            return;
	        }
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        boolean[] row = new boolean[m];
	        boolean[] column = new boolean[n];
	        
	        for(int i=0; i<m; i++){
	            for(int j =0;j < n; j++){
	                if(matrix[m][n]==0){
	                    row[m] = true;
	                    column[n] = true;
	                }
	            }
	        }
	        
	        for(int i=0; i<m; i++){
	            if(row[i]){
	                for(int j =0; j<n; j++){
	                    matrix[i][j]=0;
	                }
	            }
	        }
	        
	        for(int i=0; i<n; i++){
	            if(column[n]){
	                for(int j=0; j<m; j++){
	                    matrix[j][i]=0;
	                }
	            }
	        }
	        
	    }
	    
	    public static int[][] generateMatrix(int n) {
	        if(n<0){
	            return null;
	        }
	        
	        int[][] result = new int[n][n];
	        int start = 0;
	        int end = n-1;
	        int num =1;
	        while(start<end){
	            for(int i =start; i<=end; i++){
	                result[start][i]=num++;
	            }
	            for(int i =start+1; i<=end; i++){
	                result[i][end]=num++;
	            }
	            for(int i=end-1; i>=start; i--){
	                result[end][i]=num++;
	            }
	            for(int i=end-1; i>start; i--){
	                result[i][start]=num++;
	            }
	            start++;
	            end--;
	        }
	        if(start==end){
	        result[start][end]=num;
	        }
	        
	        return result;
	        
	        
	    }
	    
	    public static int[] searchRange(int[] A, int target) {
	        int lowerBound = findLowerBound(A, target);
	        int upperBound = findUpperBound(A, target);
	        if(lowerBound == A.length || A[lowerBound]!=target){
	            return new int[]{-1, -1};
	        }
	        return new int[]{lowerBound, upperBound};
	        
	    }
	    
	    static int findLowerBound(int[] A, int target){
	        int first = 0;
	        int last = A.length-1;
	        while(first!=last){
	            int mid = (first+last)/2;
	            if(target>A[mid]){
	                first = mid+1;
	            }else{
	                last = mid;
	            }
	        }
	        return first;
	        
	    }
	    
	    static int findUpperBound(int[] A, int target){
	        int first = 0;
	        int last = A.length-1;
	        while(first!=last){
	            int mid = (first+last)/2;
	            if(target>=A[mid]){
	                first = mid+1;
	            }else{
	                last = mid;
	            }
	        }
	        return first;
	    }
	    
	    static public int maxProfit(int[] prices) {
	        if(prices==null || prices.length<2){
	            return 0;
	        }
	        int length = prices.length;
	        int f[] = new int[length];
	        f[0] = 0;
	        int g[] = new int[length];
	        g[length-1] = 0;
	        int min, max;
	        min = prices[0];
	        max = prices[length-1];
	        for(int i=1; i<length; i++){
	            min = Math.min(min, prices[i]);
	            f[i] = Math.max(f[i-1], prices[i]-min);
	        }
	        
	        for(int i=length-2; i>=0; i--){
	            max = Math.max(max, prices[i]);
	            g[i] = Math.max(g[i+1], max - prices[i]);
	        }
	        
	        int result = 0;
	        for(int i=0; i<length; i++){
	            result = Math.max(result, f[i]+g[i]);
	        }
	        
	        return result;
	        
	    }
	    
	    public static TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder==null || inorder==null || preorder.length!=inorder.length){
	            return null;
	        }
	        
	        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	        
	    }
	    
	    private static TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
	    	if((pStart-pEnd) != (iStart-iEnd)){
	            return null;
	        }
	        if(pStart>pEnd){
		        	return null;
		    }
	        int value = preorder[pStart];
	        TreeNode root = new TreeNode(value);
	        if(pStart == pEnd){
	            return root;
	        }
	        int foundIndex = -1;
	        for(int i=iStart; i<=iEnd; i++){
	            if(inorder[i]==value){
	                foundIndex = i;
	                break;
	            }
	        }
	        if(foundIndex==-1){
	            return null;
	        }
	        root.left = buildTree(preorder, pStart+1, pStart+foundIndex-iStart, inorder, iStart, foundIndex-1);
	        root.right = buildTree(preorder, pStart+foundIndex-iStart+1, pEnd, inorder, foundIndex+1, iEnd);
	        
	        return root;
	    }
	   
	    public TreeNode sortedArrayToBST(int[] num) {
	        if(num==null){
	            return null;
	        }
	        return sortedArrayToBST(num, 0, num.length-1);
	    }
	    
	    private TreeNode sortedArrayToBST(int[] num, int start, int end){
	        if(start<end)
	            return null;
	        int mid = (start + end)/2;
	        TreeNode node = new TreeNode(num[mid]);
	        node.left = sortedArrayToBST(num, start, mid-1);
	        node.right = sortedArrayToBST(num, mid+1, end);
	        
	        return node;
	    }
	    
	    public static ListNode deleteDuplicates2(ListNode head) {
	        if(head == null)
	            return null;
	        ListNode root = new ListNode(-1);
	        ListNode prev = root;
	        ListNode curr,next;
	        curr = head;
	        while(curr!=null){
	            next = curr.next;
	            boolean found = false;
	            while(next!=null && next.val==curr.val){
	                found = true;
	                next = next.next;
	            }
	            if(found){
	                curr = next;
	            }else{
	            	prev.next = curr;
	                prev = curr;
	                prev.next = null;
	                curr = next;
	            }
	        }
	        
	        return root.next;
	        
	    }
	    
	    public double pow(double x, int n) {
	        if(n<0)
	            return 1.0/power(x, -n);
	        return power(x,n);
	        
	    }
	    
	    private double power(double x, int n){
	        if(n==0)
	            return 1.0;
	        double temp = power(x, n/2);
	        if(n%2==0){
	            return temp * temp;
	        }else{
	            return temp * temp * x;
	        }
	    }
	    
	    public int sqrt(int x) {
	        if(x<2){
	            return x;
	        }
	        int left = 1;
	        int right = x/2;
	        int mid=1;
	        int lastMid=1;
	        while(left<=right){
	            mid = (left + right)/2;
	            if((x/mid)>mid){
	                lastMid = mid;
	                left = mid +1;
	            }else if((x/mid)<mid){
	                right = mid - 1;
	            }else{
	                return mid;
	            }
	        }
	        return lastMid;
	        
	    }
	    
	    public static void rotate(int[][] matrix) {
	        if(matrix==null || matrix.length==0 ){
	            return;
	        }
	        int n = matrix.length;
	        int temp;
	        for(int left=0, right=n-1; left<right; left++, right--){
	            for(int i=0; i<n; i++){
	                temp = matrix[i][left];
	                matrix[i][left] = matrix[i][right];
	                matrix[i][right] = temp;
	            }
	        }
	        
	        for(int i=0; i<n-1; i++){
	            for(int j=0; j<n-1-i; j++){
	                temp = matrix[i][j];
	                matrix[i][j] = matrix[n-1-j][n-1-i];
	                matrix[n-1-j][n-1-i] = temp;
	            }
	            
	        }
	        
	        return;
	        
	    }
	    
	    public static int[] plusOne(int[] digits) {
	        if(digits==null || digits.length==0){
	            return digits;
	        }
	        int carry = 1;
	        int temp;
	        for(int i=digits.length-1; i>=0; i--){
	            temp = digits[i]+carry;
	            digits[i] = temp %10;
	            carry = temp/10;
	        }
	        if(carry==0){
	            return digits;
	        }else{
	            int[] newDigits = new int[digits.length+1];
	            newDigits[0]=1;
	            for(int i=0; i<digits.length; i++){
	                newDigits[i+1] = digits[i];
	            }
	            return newDigits;
	        }
	        
	    }
	    
	    public static int search(int[] A, int target) {
	        if(A==null || A.length==0){
	            return -1;
	        }
	        int lowerBound = 0;
	        int upperBound = A.length;
	        int mid;
	        while(lowerBound!=upperBound){
	            mid = (lowerBound + upperBound)/2;
	            if(target == A[mid]){
	                return mid;
	            }else if(A[lowerBound]<=A[mid]){
	                if(target<A[mid] && target>=A[lowerBound]){
	                    upperBound = mid;
	                }else{
	                    lowerBound = mid+1;
	                }
	            }else{
	                if(target>A[mid] && target<=A[upperBound-1]){
	                    lowerBound = mid+1;
	                }else{
	                    upperBound = mid;
	                }
	            }
	        }
	        
	        return -1;
	    }
	    
	    public static int trap(int[] A) {
	        if(A==null || A.length == 0){
	            return 0;
	        }
	        int[] maxLeft = new int[A.length];
	        //maxLeft[0] = A[0];
	        int[] maxRight = new int[A.length];
	        
	        for(int i=1; i<A.length; i++){
	            maxLeft[i] = Math.max(maxLeft[i-1], A[i-1]);
	            maxRight[A.length-1-i] = Math.max(maxRight[A.length-i],A[A.length-i]);
	        }
	        int sum = 0;
	        for(int i=1; i<A.length; i++){
	            int height = Math.min(maxLeft[i], maxRight[i]);
	            if(height > A[i]){
	                sum += height - A[i];
	            }
	        }
	        
	        return sum;
	        
	    }
	    
	    public static int candy(int[] ratings) {
	        if(ratings==null || ratings.length==0){
	            return 0;
	        }
	        int[] candys = new int[ratings.length];
	        candys[0]=1;
	        for(int i=1; i<ratings.length; i++){
	            if(ratings[i]>ratings[i-1]){
	                candys[i] = candys[i-1]+1;
	            }else{
	                candys[i] = 1;
	            }
	        }
	        for(int i=ratings.length-2; i>=0; i--){
	            if(ratings[i]>ratings[i+1]){
	                if(candys[i]<=candys[i+1]){
	                    candys[i] = Math.max(candys[i+1]+1, candys[i]+1);
	                }
	            }
	        }
	        int sum =0;
	        for(int i=0; i<candys.length; i++){
	            sum += candys[i];
	        }
	        
	        return sum;
	        
	    }
	    
	    public int canCompleteCircuit(int[] gas, int[] cost) {
	        int total = 0;
	        int sum = 0;
	        int index = -1;
	        for(int i=0; i<gas.length; i++){
	            total += gas[i] - cost[i];
	            sum += gas[i] - cost[i];
	            if(sum<0){
	                index = i;
	                sum = 0;
	            }
	        }
	        
	        return total>0? index + 1:-1;
	        
	    }
	    
	    public static ListNode partition(ListNode head, int x) {
	    	if(head==null || head.next==null){
	            return head;
	        }
	        ListNode left = new ListNode(-1);
	        ListNode right = new ListNode(-1);
	        ListNode leftCurr = left;
	        ListNode rightCurr = right;
	        
	        ListNode curr = head;
	        while(curr!=null){
	            if(curr.val<x){
	                leftCurr.next = curr;
	                leftCurr = leftCurr.next;
	                curr = curr.next;
	            }else{
	                rightCurr.next = curr;
	                rightCurr = rightCurr.next;
	                curr = curr.next;
	            }
	        }
	        
	        leftCurr.next = right.next;
	        rightCurr.next = null;
	        return left.next;
	    }
	    
	    public static ListNode reverseKGroup(ListNode head, int k) {
	        if(head==null || head.next==null || k<2){
	            return head;
	        }
	        ListNode nextStart = head;
	        for(int i=0; i<k; i++){
	            if(nextStart!=null){
	                nextStart = nextStart.next;
	            }else{
	                return head;
	            }
	        }
	        ListNode nextHead = reverseKGroup(nextStart, k);
	        ListNode prev = null;
	        ListNode curr = head;
	        while(k>0){
	            ListNode next = curr.next;
	            if(prev==null){
	                curr.next = nextHead;
	            }else{
	                curr.next = prev;
	            }
	            prev = curr;
	            curr = next;
	            k--;
	        }
	        
	        return prev;
	    }
	    
	    public RandomListNode copyRandomList(RandomListNode head) {
	        if(head==null){
	            return head;
	        }
	        RandomListNode curr = head;
	        while(curr!=null){
	            RandomListNode temp = new RandomListNode(curr.label);
	            temp.next = curr.next;
	            curr.next = temp;
	            curr = temp.next;
	        }
	        curr = head;
	        while(curr!=null){
	            if(curr.random!=null){
	                curr.next.random = curr.random.next;
	            }
	            curr = curr.next.next;
	        }
	        curr = head;
	        RandomListNode newHead = new RandomListNode(-1);
	        RandomListNode newCurr = newHead;
	        while(curr!=null){
	            newCurr.next = curr.next;
	            curr.next = curr.next.next;
	            newCurr = newCurr.next;
	            curr = curr.next;
	        }
	        
	        return newHead.next;
	    }
	    
	    public static void reorderList(ListNode head) {
	        if(head==null || head.next==null){
	            return;
	        }
	        ListNode prev = null;
	        ListNode slow = head;
	        ListNode fast = head;
	        while(fast!=null && fast.next!=null){
	            prev = slow;
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        prev.next = null;
	        ListNode newHead = reverseList(slow);
	        ListNode leftP = head;
	        ListNode rightP = newHead;
	        while(leftP.next!=null){
	            ListNode next = leftP.next;
	            leftP.next = rightP;
	            rightP = rightP.next;
	            leftP.next.next = next;
	            leftP = next;
	        }
	        leftP.next = rightP;
	        
	        return;
	    }
	    
	    private static ListNode reverseList(ListNode head){
	        ListNode prev = null;
	        ListNode curr = head;
	        while(curr!=null){
	            ListNode next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        return prev;
	    }
	    
	    
	    public static ListNode reverseBetween(ListNode head, int m, int n) {
	        if(head==null || head.next==null){
	            return head;
	        }
	        ListNode dumpHead = new ListNode(-1);
	        dumpHead.next = head;
	        ListNode prev = dumpHead;
	        ListNode curr = head;
	        int count = m-1;
	        while(count>0){
	            prev = curr;
	            curr = curr.next;
	            count--;
	        }
	        prev.next = reverseList(curr, n-m+1);
	        return dumpHead.next;
	        
	    }
	    
	    private static ListNode reverseList(ListNode head, int length){
	        if(head==null || head.next==null){
	            return head;
	        }
	        ListNode prev = null;
	        ListNode curr = head;
	        ListNode nextP = curr;
	        int k = length;
	        while(k>0){
	            nextP = nextP.next;
	            k--;
	        }
	        while(length>0){
	        	ListNode next = curr.next;
	            if(prev == null){
	                curr.next = nextP;
	            }else{
	                curr.next = prev;
	            }

                prev = curr;
                curr = next;
	            length--;
	        }
	        
	        return prev;
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
//		int[][] array = new int[1][1];
//		array[0][0] = 0;
////		setZeroes(array);
//		array = generateMatrix(3);
//		System.out.println(array[0][1]);
//		
//		ListNode n = new ListNode(1);
//		//1->2->3 ===> 321
//		int value = 1;
//		int i = 1;
//		while(n!=null){
//			value += n.val*i;
//			i*=10;
//			n = n.next;
//		}
//		
//		//1->2->3 ===> 123
//		value = 1;
//		while (n != null) {
//			value = value *10 + n.val;
//			n = n.next;
//		}
//		
//		int num = 12345;
//		ListNode head = new ListNode(num%10);
//		num = num/10;
//		ListNode node = head;
//		while(num>0){
//			node.next = new ListNode(num%10);
//			node = node.next;
//			num = num/10;
//		}
//		//5->4->3->2->1
//		while(head!=null){
//			System.out.println(head.val+"->");
//			head = head.next;
//		}
//		
//		num = 12345;
//		int index = 1;
//		int temp = num;
//		while(temp>10){
//			temp = temp/10;
//			index *= 10;
//		}
//		head = new ListNode(num/index);
//		num = num % index;
//		index /=10;
//		node = head;
//		while(num>0){
//			node.next = new ListNode(num/index);
//			node = node.next;
//			num = num % index;
//			index /= 10;
//		}
//		//1->2->3->4->5
//		while(head!=null){
//			System.out.print(head.val+"->");
//			head = head.next;
//		}
//		System.out.println(searchRange(new int[]{1,3},1));
//		maxProfit(new int[]{1,2});
//		buildTree(new int[]{1,2},new int[]{2,1});
//		System.out.println(deleteDuplicates2(new ListNode(1)));
//		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//		rotate(matrix);
//		for(int i=0; i<3; i++){
//			System.out.println(Arrays.toString(matrix[i]));
//		}
		
		int[] digits = {1,2,3,9,6,4,5,10,7};
//		System.out.println(Arrays.toString(plusOne(digits)));
//		System.out.println(search(digits,2));
//		System.out.println(candy(digits));
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
//		head.next.next = new ListNode(3);
//		partition(head, 2);
//		reverseKGroup(head,2);
//		reorderList(head);
		reverseBetween(head, 1,1);
		
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

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };
