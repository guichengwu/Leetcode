package LinkedList;

import LinkedList.SwapNode.ListNode;

public class LinkedList {
	private ListNode head;
	private int size;
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
	//¹¹ÔìLinkedlist
	public LinkedList(ListNode head) {
		//if head is null, then head's value is 0
		if (head == null) {
			this.head = new ListNode(0);
		}
		
		this.head = head;
		size = 1;
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
		size++;
	}
	
	public void printLinkList() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	public ListNode swapPairs(ListNode head) {

		// check one node linkedlist
		if (head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		
		ListNode iterator1 = head;
		ListNode iterator2 = head.next;
		while (iterator2 != null) {
			ListNode temp1 = null;
			ListNode temp2 = null;
			System.out.println("hi");
			
			if (iterator2.next != null) {
				temp1 = iterator2.next;
			}
			
			if (iterator2.next == null) {
				break;
			}
			
			if (iterator2.next.next != null) {
				temp2 = iterator2.next.next;
			}
			
			iterator2.next = iterator1;
			// even arraylist
			if (iterator2.next.next != null) {
				iterator1.next = temp1;
			}
			// odd arraylist
			else if (iterator2.next != null) {
				iterator1.next = temp1;
			}

			// iterator1,2 move forward by 1

			if (iterator2.next.next != null) {
				iterator1 = temp1;
				iterator2 = temp2;
			}	
		}
		head = newHead;
		return newHead;
	}
	
	public ListNode swapPairs2(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = dummy;
		
		ListNode l1 = null, l2 = null;
		
		while (cur.next != null && cur.next.next != null) {
			System.out.println("hi");
			l1 = cur.next;
			l2 = cur.next.next;
			l1.next = l2.next;
			l2.next = l1;
	
			cur.next = l2;
			cur = l1;

		}
		return dummy.next;
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		int aLength = 0;
		int bLength = 0;
		ListNode tempA = headA;
		ListNode tempB = headB;
		
		while (tempA != null) {
			aLength++;
			tempA = tempA.next;
		}
		
		while (tempB != null) {
			bLength++;
			tempB = tempB.next;
		}
		tempA = headA;
		tempB = headB;
		
		int diff = Math.abs(aLength - bLength);
		System.out.println("diff:" + diff);
		if (aLength > bLength) {
			while (diff > 0) {
				tempA = tempA.next;
				diff--;
			}
		} else if(bLength > aLength) {
			while (diff >0) {
			    tempB = tempB.next;
			    diff--;
			}
		}
		
		while (tempA != null) {
			if (tempA == tempB) {
				return tempA;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		
		return null;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		LinkedList list = new LinkedList(head);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		list.addNode(node2);
		list.addNode(node3);
		list.addNode(node4);
		list.addNode(node5);
		list.addNode(node6);
		//list.printLinkList();
		
		ListNode head2 = new ListNode(20);
		ListNode node7 = new ListNode(11);
		LinkedList list2 = new LinkedList(head2);
		list2.addNode(node7);
		list.addNode(node3);
		list.addNode(node4);
		list.addNode(node5);
		list.addNode(node6);
		
		ListNode node = getIntersectionNode(head, head2);
		node.printNode();
		//ListNode newHead = list.swapPairs2(head);
		//newHead.printNode();
		//list.printLinkList();
		
	}

}
