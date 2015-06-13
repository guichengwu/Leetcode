package LinkedList;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import LinkedList.LinkedList.ListNode;

public class SortList {
	private static ListNode head;
	
	//ππ‘ÏLinkedlist
	public SortList(ListNode head) {
		//if head is null, then head's value is 0
		if (head == null) {
			this.head = new ListNode(0);
		}
		
		this.head = head;
	}
	
	 public static class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		     ListNode() {}
		 }
	
	 //Selection sort
    public ListNode sortList(ListNode head) {
    	if (head == null) {
    		return null;
    	}

    	ListNode tempNode;
    	ListNode outLoop;
    	tempNode = head;
    	outLoop = head;
    	while (outLoop.next != null) {
        	int tempSmallest = outLoop.val;
    		System.out.println("out loop");
    		while (head.next != null) {
    			System.out.println("in loop");
    			if (head.next.val < tempSmallest) {
    				tempSmallest = head.next.val;
    				tempNode = head.next;
    			}
    			
    			head = head.next;
    		}
    		
    		if (outLoop.val > tempSmallest) {
    		//exchange values
    		int tempValue = outLoop.val;
    		outLoop.val = tempNode.val;
    		tempNode.val = tempValue;
    		
    		}
    		outLoop = outLoop.next;
    		head = outLoop;
    	}

    	return head;
    }

    public static ListNode sortList2(ListNode head) {
    	return mergeSort(head);
    }
    //MergeSort
    
    public static ListNode mergeSort(ListNode head) {
    	
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
    	int size = 1;
    	ListNode temp = head;
    	while (temp.next != null) {
    		size++;
    		temp = temp.next;
    	}
    	
    	ListNode firstHead = head;
    	ListNode secondHead = head;
    	ListNode firstEnd = head;
    	int i = 1;  
    	
    	//create the first half of linkedlist
    	while (i < (size /2)) {
    		i++;
    		firstEnd = firstEnd.next;
    	}
    	
    	//create the second half
    	secondHead = firstEnd.next;
    	firstEnd.next = null;
    	
    	ListNode firstSortedHead = mergeSort(firstHead);
    	ListNode secondSortedHead = mergeSort(secondHead);
    	
    	ListNode sortedHead = merge(firstSortedHead, secondSortedHead);
    	
    	return sortedHead;
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
    
	public void addNode (ListNode node) {
		if (head == null) {
			System.out.println("failed, because there are no head.");
			return;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
	}
	
	public static void printLinkList() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode head =null;
/*		SortList list = new SortList(head);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(-1);
		ListNode n5 = new ListNode(8);
		list.addNode(n2);
		list.addNode(n3);
		list.addNode(n4);
		list.addNode(n5);*/
		
		//list.sortList(head);
		ListNode newHead = mergeSort(head);
		ListNode temp = newHead;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}
