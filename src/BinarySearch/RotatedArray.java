package BinarySearch;

public class RotatedArray {
	public static int search(int[] nums, int target) {
		return searchHelp(nums, 0, nums.length - 1, target);
	}

	public static int searchHelp(int[] nums, int start, int end, int target) {
		int mid = (start + end) / 2;

		if (start > end) {
			return -1;
		}
		if (target == nums[mid]) {
			return mid;
		}

		// left is sorted
		if (nums[start] < nums[mid] && nums[end] < nums[mid]) {
			if (target < nums[start] || target > nums[mid]) {
				// search right
				System.out.println("#1 search right");
				return searchHelp(nums, mid + 1, end, target);
			} else {
				// search left
				System.out.println("#1 search left");
				return searchHelp(nums, start, mid - 1, target);
			}
		}
		// right is sorted
		else if (nums[end] > nums[mid] && nums[start] > nums[mid]) {
			if (target > nums[end] || target < nums[mid]) {
				// search left
				System.out.println("#2 search left");
				return searchHelp(nums, start, mid - 1, target);
			} else {
				// search right
				System.out.println("#2 search right");
				return searchHelp(nums, mid + 1, end, target);
			}
		}
		// search both left and ride side
		else {
			// left first
			System.out.println("#3 search left");
			int result = searchHelp(nums, start, mid - 1, target);
			if (result != -1) {
				return result;
			} else {
				System.out.println("#3 search right");
				return searchHelp(nums, mid + 1, end, target);
			}
		}

	}

	public static int searchHelp2(int[] nums, int start, int end, int target) {
		int mid = (start + end) / 2;
		if (start > end) {
			return -1;
		}

		if (nums[mid] == target) {
			return mid;
		}

		// left is sorted
		if (nums[start] < nums[mid]) {
			if (nums[start] <= target && target <= nums[mid]) {
				// search left
				return searchHelp2(nums, start, mid - 1, target);
			} else {
				// search right
				return searchHelp2(nums, mid + 1, end, target);
			}
		}
		// right is sorted
		else if (nums[mid] < nums[start]) {
			if (nums[mid] <= target && target <= nums[end]) {
				// search right
				return searchHelp2(nums, mid + 1, end, target);
			} else {
				return searchHelp2(nums, start, mid - 1, target);
			}
		} else if (nums[start] == nums[mid]) {
			if ((nums[mid] != nums[end])) {
				return searchHelp2(nums, mid + 1, end, target);
			} else {
				// search left first, thenright
				int result = searchHelp2(nums, start, mid - 1, target);

				if (result != -1) {
					return result;
				} else {
					return searchHelp2(nums, mid + 1, end, target);
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(search(nums, 4));
	}

}
