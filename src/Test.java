import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> resutl = new HashMap<>();
        int[] nums = {4, 5, 8, 2};
        for (int i = 0;  i < nums.length; i++) {
            resutl.put(nums[i], nums[i]);
        }
//        KthLargest kthLargest = new KthLargest(3, nums);
//        System.out.println(kthLargest.add(3));
//        System.out.println(kthLargest.add(10));
//        System.out.println(kthLargest.add(9));
    }

    static class KthLargest {
        private class Node {
            private int val;
            private Node left;
            private Node right;
            private int N;

            private Node(int val, int N) {
                this.val = val;
                this.N = N;
            }
        }

        private Node node;
        private int K;

        public KthLargest(int k, int[] nums) {
            this.K = k;
            for (int i = 0; i < nums.length; i++) {
                node = addNode(node, nums[i]);
            }
        }

        public int add(int val) {
            node = addNode(node, val);
            return get(node, K).val;
        }


        private Node get(Node root, int k) {
            if (root == null) {
                return null;
            }

            int rightSize = size(root.right);
            if (rightSize == k - 1) {
                return root;
            } else if (rightSize < k - 1 ) {
                return get(root.left, k - rightSize - 1);
            } else {
                return get(root.right, k - 1);
            }
        }

        private Node addNode(Node root, int val) {
            if (root == null) {
                return new Node(val, 1);
            }

            int cmp = val - root.val;
            if (cmp == 0) {
                root.val = val;
            } else if (cmp > 0) {
                root.right = addNode(root.right, val);
            } else {
                root.left = addNode(root.left, val);
            }

            root.N = size(root.left) + size(root.right) + 1;
            return root;
        }

        private int size(Node node) {
            if (node == null) {
                return 0;
            }
            return node.N;
        }
    }
}
