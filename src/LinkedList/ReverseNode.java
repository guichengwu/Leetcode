package LinkedList;

import java.util.Collections;

import LinkedList.RotateList.ListNode;

public class ReverseNode {
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
	
	//learned from others
	public ListNode reverseKGroup1(ListNode head, int k) {
		  ListNode dummy = new ListNode(0);
		  dummy.next = head;
		  ListNode temp = dummy;
		  ListNode current = head;
		  ListNode reverse = null;
		  
		  while (current != null) {
			  ListNode reverseHead = temp;
			  ListNode reverseTail = temp.next;
			  temp = temp.next;
			  
			  for (int i = 0; i < k; i++) {
				  if (current == null) {
					  return dummy.next;
				  }
				  
				  current = current.next;
			  }
			  
			  current = temp;
			  
			  for (int i = 0; i < k; i++) {
				  current = current.next;
				  temp.next = reverse;
				  reverse = temp;
				  temp = current;
			  }
			  
			  reverseHead.next = reverse;
			  reverseTail.next = current;
			  reverse = null;
			  temp = reverseTail;
		  }
		 
		  return dummy.next;
	}
	
    public ListNode reverseKGroup(ListNode head,  int k)  {
    	
    	    if (head == null || k == 1) {
    	    	return head;
    	    }
    	    
    	    ListNode prePointer1 = null;
    	     ListNode pointer1 = head;
    	     ListNode prePointer2 = getKPreNode(pointer1, k);
    	     
    	     if (prePointer2 == null) {
    	    	 return head;
    	     }
    	     
    	     ListNode pointer2 = prePointer2.next;
    	     
    	     while (pointer1 != null && pointer2 != null) {
    	    	   swapNodes(prePointer1, pointer1, prePointer2,  pointer2);
 
    	    	   prePointer1 = pointer2;
    	    	   pointer1 = pointer2.next;
    	    	   prePointer2 = getKPreNode(pointer1, k);
    	    	   if (prePointer2 == null) {
    	    		   return head;
    	    	   }
    	    	   pointer2 = prePointer2.next;
    	     }
    	     
    	     return head;
    	     
        
    }
    
    public void swapNodes(ListNode prePointer1, ListNode pointer1, ListNode prePointer2, ListNode pointer2) {
    	  ListNode temp = pointer1.next;
    	  pointer1.next = pointer2.next;
    	  pointer2.next = temp;
    	  
    	  temp = prePointer1;
    	  prePointer1 = prePointer2;
    	  prePointer2 = temp;
    }
    
    public ListNode getKPreNode(ListNode n, int k)  {
    	  while (n != null && k > 2) {
    		   n = n.next;
    		   k--;
    	  }
    	  
    	  if (n == null) {
    		  return null;
    	  }
    	  
    	  return n;
    }
}
