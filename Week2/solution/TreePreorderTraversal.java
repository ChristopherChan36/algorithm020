package com.codingstarlet.structure.array;

public class TreePreorderTraversal {

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> rs = new ArrayList<>();
        Deque<Node> stack = new LinkedList();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            rs.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return rs;
    }

    /**
     * 递归方式
     */
    public List<Integer> _preorder_1(Node root) {
        List<Integer> nodeValues = new ArrayList<>();
        if (root == null) {
            return nodeValues;
        }
        rootIteration(root, nodeValues);
        return nodeValues;
    }

    private void rootIteration(Node root, List<Integer> nodeValues) {
        nodeValues.add(root.val);
        List<Node> childrens = root.children;
        if (childrens != null && childrens.size() > 0) {
            for (int i = 0; i < childrens.size(); i++) {
                rootIteration(childrens.get(i), nodeValues);
            }
        }
    }

}
