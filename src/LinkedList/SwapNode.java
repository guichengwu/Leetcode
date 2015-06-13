package LinkedList;

public class SwapNode {
	private ListNode head;
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {

		// check one node linkedlist
		if (head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(head.next.val);

		ListNode temp;
		ListNode iterator1 = head;
		ListNode iterator2 = head.next;
		while (iterator2 != null) {
			iterator2.next = iterator1;

			// even arraylist
			if (iterator2.next.next != null) {
				iterator1.next = iterator2.next.next;
			}
			// odd arraylist
			else if (iterator2.next != null) {
				iterator1.next = iterator2.next;
			}

			// iterator1,2 move forward by 1

			if (iterator2.next.next != null) {
				iterator1 = iterator2;
				iterator2 = iterator2.next;
			}
			// iterator2 is the second last one or iterator 2 is the last one,
			// then end while
			else if (iterator2.next == null || iterator2.next.next == null) {
				break;
			}
		}
		return newHead;
	}
}
