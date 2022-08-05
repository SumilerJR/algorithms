/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} val
 * @param {number} depth
 * @return {TreeNode}
 * 执行用时：88 ms, 在所有 JavaScript 提交中击败了55.26%的用户
 * 内存消耗：46.4 MB, 在所有 JavaScript 提交中击败了89.47%的用户
 */
var addOneRow = function (root, val, depth) {
    if (root) {
        if (depth == 1) {
            return new TreeNode(val, root, null);//为第一层时将整个树添加到节点左子树上
        }
        if (depth == 2) {
            root.left = new TreeNode(val, root.left, null);//原来的左子树是新的左子树根的左子树。
            root.right = new TreeNode(val, null, root.right);//原来的右子树是新的右子树根的右子树
        }
        else {
            root.left = addOneRow(root.left, val, depth - 1);//进行递归，
            root.right = addOneRow(root.right, val, depth - 1);
        }
    }
    return root;
};