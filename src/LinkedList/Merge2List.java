package LinkedList;

import LinkedList.RemoveElement.ListNode;

public class Merge2List {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode firstHead, ListNode secondHead) {
		ListNode fakeHead = new ListNode(-1);
		ListNode newNode = fakeHead;
		//both lists have nodes
		while (firstHead != null && secondHead != null) {
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
		
		//first list has remaining nodes
		while (firstHead != null) {
			newNode.next = new ListNode(firstHead.val);
			newNode = newNode.next;
			firstHead = firstHead.next;
		}
		
		//second list has remaining nodes
		while (secondHead != null) {
			newNode.next = new ListNode(secondHead.val);
			newNode = newNode.next;
			secondHead = secondHead.next;
		}

		return fakeHead.next;
	}

}
