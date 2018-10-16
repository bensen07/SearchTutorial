package org.benz.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.benz.common.TreeNode;

public class Tree {

	private TreeNode root;

	public TreeNode head;

	static TreeNode prev;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void insertNode(String key, int value) {

		TreeNode node = new TreeNode(key, value);
		if (root == null) {
			root = node;
		} else {
			TreeNode temp = root;
			TreeNode currentparent = null;
			while (temp != null) {
				currentparent = temp;
				if (value > temp.getValue()) {
					temp = temp.getRight();
					if (temp == null) {
						currentparent.setRight(node);
						return;
					}
				} else if (value < temp.getValue()) {
					temp = temp.getLeft();
					if (temp == null) {
						currentparent.setLeft(node);
						return;
					}
				}
			}

		}

	}

	public void printInorderTree(TreeNode node) {
		if (null == node) {
			return;
		}

		printInorderTree(node.getLeft());
		System.out.println(node.toString());
		printInorderTree(node.getRight());

	}

	public void printpreorderTree(TreeNode node) {
		if (null == node) {
			return;
		}

		System.out.println(node.toString());
		printpreorderTree(node.getLeft());
		printpreorderTree(node.getRight());

	}

	public void printpostorderTree(TreeNode node) {
		if (null == node) {
			return;
		}

		printpostorderTree(node.getLeft());
		printpostorderTree(node.getRight());
		System.out.println(node.toString());
	}

	public TreeNode convertTreeToLinkedList(TreeNode node) {

		if (node == null)
			return node;

		if (node.getLeft() != null) {
			TreeNode left = convertTreeToLinkedList(node.getLeft());
			while (left.getRight() != null) {
				left = left.getRight();
			}

			left.setRight(node);
			node.setLeft(left);

		}

		if (node.getRight() != null) {
			TreeNode right = convertTreeToLinkedList(node.getRight());
			while (right.getLeft() != null) {
				right = right.getLeft();
			}

			right.setLeft(node);
			node.setRight(right);
		}

		return node;
	}

	public TreeNode convertToDoubleLinkedList(TreeNode node) {
		if (node == null)
			return node;

		node = convertTreeToLinkedList(node);

		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	public TreeNode reverseTreeLinkedList(TreeNode node) {

		TreeNode prev = null;
		TreeNode current = node;
		TreeNode next = null;

		while (null != current) {
			next = current.getRight();
			current.setRight(prev);
			prev = current;
			current = next;
		}
		node = prev;
		return node;

	}

	public int maxHeightOfTree(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return 1 + Math.max(maxHeightOfTree(node.getLeft()), maxHeightOfTree(node.getRight()));

	}

	public int minHeightOfTree(TreeNode node) {

		if (node == null) {
			return 0;
		}
		return 1 + Math.min(minHeightOfTree(node.getLeft()), minHeightOfTree(node.getRight()));
	}

	public boolean isBalancedTree(TreeNode root) {

		return (maxHeightOfTree(root) - minHeightOfTree(root) <= 1);
	}

	public int numberOfNodes(TreeNode node) {

		if (node == null) {
			return 0;
		}

		return 1 + numberOfNodes(node.getLeft()) + numberOfNodes(node.getRight());
	}

	// public void recursiveConversionToDLL(TreeNode node) {
	// System.out.println("RecConv Node:" + node);
	// if (node == null) {
	// return;
	// }
	//
	// recursiveConversionToDLL(node.getLeft());
	// if (null == prev) {
	// head = root;
	// } else {
	// node.setLeft(prev);
	// prev.setRight(node);
	// }
	//
	// prev = node;
	//
	// recursiveConversionToDLL(node.getRight());
	//
	// }

	void printList(TreeNode node) {
		while (node != null) {
			System.out.print(node + " -> ");
			node = node.getRight();
		}
	}

	void bfs(TreeNode node) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		System.out.println(node + "->");
		while (!q.isEmpty()) {
			TreeNode curr = q.remove();
			if (null != curr.getLeft()) {
				q.add(curr.getLeft());
				System.out.println(curr.getLeft() + ",");
			}
			if (null != curr.getRight()) {
				q.add(curr.getRight());
				System.out.println(curr.getRight());
			}

		}

	}

	void dfs(TreeNode node) {

		if (null != node) {
			if (null != node.getLeft()) {
				dfs(node.getLeft());
			}
			if (null != node.getRight()) {
				dfs(node.getRight());
			}
			System.out.println(node);
		}
		return;

	}

	TreeNode convertArrayToTree(int[] arr, int start, int end) {
		if (end < start)
			return null;

		int middle = (start + end) / 2;
		System.out.println("Middle " + middle + " Val:" + arr[middle]);
		TreeNode node = new TreeNode("", arr[middle]);
		node.setLeft(convertArrayToTree(arr, start, middle - 1));
		node.setRight(convertArrayToTree(arr, middle + 1, end));
		return node;

	}

	List<LinkedList<TreeNode>> findLevelLinkList(TreeNode head) {
		if (null == head) {
			return null;
		}
		int level = 0;

		List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(head);

		result.add(level, list);
		while (true) {
			list = new LinkedList<TreeNode>();
			for (int i = 0; i < result.get(level).size(); i++) {
				TreeNode n = result.get(level).get(i);
				if (n != null) {

					if (n.getLeft() != null) {
						list.add(n.getLeft());
					}
					if (n.getRight() != null) {
						list.add(n.getRight());
					}

				}

			}
			if (list.size() > 0) {
				result.add(list);
			} else {
				break;
			}
			level++;
		}

		return result;

	}

	// public TreeNode inorderSucc(TreeNode node) {
	//
	// if (node.parent == null || node.getRight() != null) {
	// TreeNode n = node.getRight();
	// while (n.getLeft() != null) {
	// n = n.getLeft();
	// }
	// return n;
	// }else {
	// while(TreeNode p = node.parent !=null) {
	// if(p.getLeft() == node) {
	// break;
	// }
	// node = p;
	// }
	// }
	// return p;
	//
	// }

	private boolean covers(TreeNode root, TreeNode p) {
		if (null == root) {
			return false;
		}
		if (root == p) {
			return true;
		}

		return covers(root.getLeft(), p) || covers(root.getRight(), p);
	}

	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (covers(root.getLeft(), p) && covers(root.getLeft(), q)) {
			return commonAncestor(root.getLeft(), p, q);
		}
		if (covers(root.getRight(), p) && covers(root.getRight(), q)) {
			return commonAncestor(root.getRight(), p, q);
		}
		return root;
	}
}
