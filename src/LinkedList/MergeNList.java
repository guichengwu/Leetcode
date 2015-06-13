package LinkedList;

import LinkedList.SortList.ListNode;



 
public class MergeNList {
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	  
    public static ListNode mergeKLists(ListNode[] lists) {
    	
    	if (lists.length == 0) {
    		return null;
    	}
    	
    	if (lists.length == 1) {
    		return lists[0];
    	}
    	
    	int size = lists.length;
    	
    	
        ListNode[] leftHalfs = new ListNode[size/2];
        ListNode[] rightHalfs = new ListNode[size -size/2];
        for (int i = 0; i < size; i++) {
        	if (i < (size / 2)) {
        		leftHalfs[i] = lists[i];
        	} else {
        		rightHalfs[i - (size/2)] = lists[i];
        	}
        }
        ListNode firstPart = mergeKLists(leftHalfs);
        ListNode secondPart = mergeKLists(rightHalfs);
        
        ListNode result = merge(firstPart, secondPart);
        return result;
    }
    

  public static ListNode merge(ListNode firstHead, ListNode secondHead) {
    	
    	ListNode fakeHead = new ListNode(-1);
    	ListNode newNode = fakeHead;
    	//both are not end
    	while (firstHead != null && secondHead!= null) {
    		if (firstHead.val <= secondHead.val) {
    			newNode.next = new ListNode(firstHead.val);
    			newNode = newNode.next;
    			firstHead = firstHead.next;
    		} else {
    			newNode.next = new ListNode(secondHead.val);
    			newNode = newNode.next;
    			secondHead = secondHead.next;
    		}
    	}
    	
    	//if firstHead remain more nodes
    	if (firstHead != null) {
    		while (firstHead != null) {
    			newNode.next = new ListNode(firstHead.val);
    			newNode = newNode.next;
    			firstHead = firstHead.next;

    		}
    	}
    	
    	//if seondHead remaing more nodes
    	if (secondHead != null) {
    		while (secondHead != null) {
    			newNode.next = new ListNode(secondHead.val);
    			newNode = newNode.next;
    			secondHead = secondHead.next;
    		}
    	}
    	
    	return fakeHead.next;
    }
}