package LinkedList;

import LinkedList.LinkedList.ListNode;

public class Intersaction {
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
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
		
		while (tempA != null && tempB != null) {
			if (tempA == tempB) {
				return tempA;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		
		return null;
	}

}
