package LinkedList;

public class RemoveElement {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		ListNode pre = null;
		ListNode current = head;

		while (current != null) {
			if (current.val == val) {
				if (current == head) {
					head = head.next;
					current = head;
					if (head == null) {
						return head;
					}
				} else {
					pre.next = current.next;
					current = pre.next;
					if (current == null) {
						break;
					}
				}
			} else {
				pre = current;
				current = current.next;
			}
		}
		return head;
	}

}
