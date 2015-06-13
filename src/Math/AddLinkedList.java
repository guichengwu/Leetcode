package Math;

public class AddLinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head = null;
		ListNode node = null;
		ListNode pointer = null;
		boolean bit = false;
		while (l1 != null && l2 != null) {
			if (bit == false) {
				node = new ListNode((l1.val + l2.val) % 10);
			} else {
				node = new ListNode((1 + (l1.val + l2.val)) % 10);
			}

			if (head == null) {
				head = node;
				pointer = head;
			} else {
				pointer.next = node;
				pointer = pointer.next;
			}

			if ((l1.val + l2.val > 9) || ((bit) && ((l1.val + l2.val) >= 9))) {
				bit = true;
			} else {
				bit = false;
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			if (bit) {
				node = new ListNode((l1.val + 1) % 10);
			} else {
				node = new ListNode(l1.val);
			}

			pointer.next = node;
			pointer = pointer.next;

			if (bit && l1.val == 9) {
				bit = true;
			} else {
				bit = false;
			}

			l1 = l1.next;
		}

		while (l2 != null) {
			if (bit) {
				node = new ListNode((l2.val + 1) % 10);
			} else {
				node = new ListNode(l2.val);
			}

			pointer.next = node;
			pointer = pointer.next;

			if (bit && l2.val == 9) {
				bit = true;
			} else {
				bit = false;
			}

			l2 = l2.next;
		}

		if (bit) {
			node = new ListNode(1);
			pointer.next = node;
			pointer = pointer.next;
		}

		return head;
	}
}
