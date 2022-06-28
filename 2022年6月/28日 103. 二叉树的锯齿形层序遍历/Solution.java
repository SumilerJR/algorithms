//list奇偶层前后插入
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.9 MB, 在所有 Java 提交中击败了85.17%的用户
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if(root == null)
            return listList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            List<Integer> listInt = new ArrayList<Integer>();
            int size = queue.size();
            while(size-- > 0){
                root = queue.poll();
                if (flag)
                    listInt.add(root.val);
                else
                    listInt.add(0, root.val);
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
            flag = !flag;
            listList.add(listInt);
        }
        return listList;
    }
}

//list奇偶层翻转
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if(root == null)
            return listList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        while(!queue.isEmpty()){
            List<Integer> listInt = new ArrayList<Integer>();
            int size = queue.size();
            while(size-- > 0){
                root = queue.poll();
                listInt.add(root.val);
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
            if (++height % 2 == 0)
                Collections.reverse(listInt);
            listList.add(listInt);
        }
        return listList;
    }
}
