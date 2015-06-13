package LinkedList;

import LinkedList.LinkedList.ListNode;

public class RemoveNode {
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
	
	 public ListNode removeNthFromEnd(ListNode head, int n) {
	        if (head == null) {
	            return null;
	        }
	        int length = 0;
	        ListNode temp = head;
	        while (temp != null) {
	            length++;
	            temp = temp.next;
	        }
	        
	        temp = head;
	        //the pos to be removed
	        int pos = length - n + 1;
	        int i = 1;
	        while (temp != null) {
	            //remove head
	            if (pos == 1) {
	                head = head.next;
	                temp = null;
	                return head;
	            }
	            if (i+1 == pos) {
	                ListNode del = temp.next;
	                temp.next = del.next;
	                del = null;
	                
	                return head;
	            }
	            
	            temp = temp.next;
	            i++;
	        }
	        
	        return head;
	        
	    }
}
