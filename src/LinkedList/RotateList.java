package LinkedList;

import LinkedList.LinkedList.ListNode;

public class RotateList {
	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
		
		public void printNode() {
			System.out.println(val);
		}
	}
	
	  public ListNode rotateRight(ListNode head, int k) {
	    	if (head == null) {
	    		return null;
	    	}
	    	
	    	if (k <= 0) {
	    		return head;
	    	}
	    	
	    	ListNode temp = head;
	    	ListNode preEnd = null;
	        ListNode end = head;
	        int length = 1;
	    	while (end.next != null) {
	    		preEnd = end;
	    		end = end.next;
	    		length++;
	    	}
	    	if (length == 1) {
	    	    return head;
	    	}
	    	
	    	if (k >= length) {
	    		k = k % length;
	    	}
	    	while (k > 0) { 
	    	    ListNode node = new ListNode(end.val);
	    	    node.next = head;
	    	    head = node;
	    	    temp = head;
	    	    preEnd.next = null;
	    	    end = preEnd;
	    	    //found preEnd
	    	    while (temp.next != preEnd) {
	    	    	temp = temp.next;
	    	    }
	    	    preEnd = temp;
	    	    k--;
	    	}
	    	
	    	
	    	return head;
	        
	    }

}
