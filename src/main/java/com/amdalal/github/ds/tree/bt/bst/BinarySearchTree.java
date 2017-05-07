package com.amdalal.github.ds.tree.bt.bst;

import com.amdalal.github.ds.tree.bt.BinaryTree;
import com.amdalal.github.ds.tree.TreeEntry;
import com.amdalal.github.ds.tree.bt.BinaryTreeNode;

public class BinarySearchTree<T extends TreeEntry & Comparable<? super T>> extends BinaryTree<T> {

    public boolean search(T key) {
        return doSearch(getRoot(), key) != null;
    }

    private BinaryTreeNode<T> doSearch(BinaryTreeNode<T> node, T key) {
        if (node != null) {
            int comparisionResult = node.getData().compareTo(key);
            if (comparisionResult == 0) {
                return node;
            } else if (comparisionResult > 0) {
                return doSearch(node.getLeftChild(), key);
            } else {
                return doSearch(node.getRightChild(), key);
            }
        }
        return null;
    }

    public void insert(T key) {
        BinaryTreeNode<T> node = getRoot();
        BinaryTreeNode<T> prevNode = null;
        while (node != null) {
            int comparisionResult = node.getData().compareTo(key);
            if (comparisionResult == 0) {
                throw new IllegalArgumentException("key already exists in tree");
            }
            prevNode = node;
            if (comparisionResult > 0) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(key);
        if (prevNode != null) {
            if (prevNode.getData().compareTo(key) > 0) {
                prevNode.addLeftChild(newNode);
            } else {
                prevNode.addRightChild(newNode);
            }
        } else {
            setRoot(newNode);
        }
    }

    public T findMin() {
        BinaryTreeNode<T> node = doFindMin(getRoot());
        return node == null ? null : node.getData();
    }

    private BinaryTreeNode<T> doFindMin(BinaryTreeNode<T> node) {
        if (node != null) {
            if (node.getLeftChild() == null) {
                return node;
            } else {
                return doFindMin(node.getLeftChild());
            }
        }
        return null;
    }

    public T findMax() {
        BinaryTreeNode<T> node = doFindMax(getRoot());
        return node == null ? null : node.getData();
    }

    private BinaryTreeNode<T> doFindMax(BinaryTreeNode<T> node) {
        if (node != null) {
            if (node.getRightChild() == null) {
                return node;
            } else {
                return doFindMax(node.getRightChild());
            }
        }
        return null;
    }

    public int getNodeCount() {
        return doGetNodeCount(getRoot(), 0);
    }

    public int doGetNodeCount(BinaryTreeNode<T> node, int count) {
        if (node != null) {
            count++;
            count = doGetNodeCount(node.getLeftChild(), count);
            count = doGetNodeCount(node.getRightChild(), count);
        }
        return count;
    }

    public void delete(T key) {
        if (key == null) {
            throw new NullPointerException("key cannot be null");
        }
        BinaryTreeNode<T> node = doSearch(getRoot(), key);
        if (node == null) {
            throw new IllegalArgumentException("key not found");
        }
        doDelete(getRoot(), key);
    }

    private BinaryTreeNode<T> doDelete(BinaryTreeNode<T> node, T key) {
        if (node != null) {
            int comparisionResult = node.getData().compareTo(key);
            if (comparisionResult < 0) {
                node.setRightChild(doDelete(node.getRightChild(), key));
            } else if (comparisionResult > 0) {
                node.setLeftChild(doDelete(node.getLeftChild(), key));
            } else {
                if (node.getLeftChild() == null) {
                    return node.getRightChild();
                } else if (node.getRightChild() == null) {
                    return node.getLeftChild();
                } else {
                    BinaryTreeNode<T> candidate = doFindMin(node.getRightChild());
                    node.setData(candidate.getData());
                    node.setRightChild(doDelete(node.getRightChild(), candidate.getData()));
                }
            }
        }
        return node;
    }
}
