package org.benz.common;

public class TreeNode {

	private String key;
	private int value;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(String key, int value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {

		return "{ key:" + this.getKey() + ", value:" + this.getValue()
		// + ", left:" + this.getLeft() + ", right:"
		// + this.getRight()
				+ "}";

	}
}
