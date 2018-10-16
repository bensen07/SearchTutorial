package org.benz.tree;

import org.benz.common.TreeNode;

public class TreeTutorial {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.setRoot(new TreeNode("10", 1));
		tree.getRoot().setLeft(new TreeNode("12", 2));
		tree.getRoot().setRight(new TreeNode("15", 3));
		tree.getRoot().getLeft().setLeft(new TreeNode("25", 3));
		tree.getRoot().getLeft().setRight(new TreeNode("30", 3));
		tree.getRoot().getRight().setLeft(new TreeNode("36", 3));
		tree.getRoot().getRight().getLeft().setRight(new TreeNode("38", 4));

		System.out.println("InOrder tree");
		tree.printInorderTree(tree.getRoot());

		System.out.println("preOrder tree");
		tree.printpreorderTree(tree.getRoot());

		System.out.println("postOrder tree");
		tree.printpostorderTree(tree.getRoot());

		System.out.println("BFS");
		tree.bfs(tree.getRoot());

		System.out.println("DFS");
		tree.dfs(tree.getRoot());

		System.out.println("print Number of Node Of Tree " + tree.numberOfNodes(tree.getRoot()));

		System.out.println("print Height of Tree " + tree.maxHeightOfTree(tree.getRoot()));

		System.out.println("Print Min Height of Tree " + tree.minHeightOfTree(tree.getRoot()));

		System.out.println("Is Balanced Tree " + tree.isBalancedTree(tree.getRoot()));

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode n = tree.convertArrayToTree(arr, 0, arr.length - 1);
		System.out.println("Array to Tree");
		tree.printList(tree.convertToDoubleLinkedList(n));

		System.out.println("Convert To Double Linked List");
		TreeNode node = tree.convertToDoubleLinkedList(tree.getRoot());
		tree.printList(node);

		System.out.println("Reversing Tree Linked List");
		TreeNode head = tree.reverseTreeLinkedList(node);
		tree.printList(head);
		// System.out.println("Recursive Conversion");
		// tree.recursiveConversionToDLL(tree.getRoot());
		// tree.printList(tree.head);

	}

}
