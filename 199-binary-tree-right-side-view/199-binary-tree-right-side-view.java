class Solution{
public List<Integer> rightSideView(TreeNode root) {
    LinkedList<TreeNode> q1 = new LinkedList<>();
    LinkedList<Integer> q2 = new LinkedList<>();
 
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
 
    q1.offer(root);
    q2.offer(1);
    int prev = 0;
 
    while (!q1.isEmpty()) {
        TreeNode h = q1.poll();
        int level = q2.poll();
 
        if (level != prev) {
            result.add(h.val);
        }
 
        if (h.right != null) {
            q1.offer(h.right);
            q2.offer(level + 1);
        }
 
        if (h.left != null) {
            q1.offer(h.left);
            q2.offer(level + 1);
        }
 
        prev = level;
    }
 
    return result;
}
}