package exam.finalalgo;

import datastructure.tree.binarysearch.BinarySearchTree;
import datastructure.tree.binarysearch.Node;

public class BinarySearchTreeStorage<E> extends BinarySearchTree<E> {

	public int updateStock(Object o, int num) {
		return updateUsingComparable(o, num);
	}
	
	public int updateUsingComparable(Object o, int num) {
		@SuppressWarnings("unchecked")
		Comparable<? super E> value = (Comparable<? super E>) o;
		
		Node<E> node = super.getRoot();
		
		while(node != null) {
			int res = value.compareTo(node.getValue());
			if(res < 0) {
				node = node.getLeft();
			}else if(res > 0) {
				node = node.getRight();
			}else {
				Product prd = (Product) node.getValue();
				int tmpStock = prd.getProduct(num);
				
				if(tmpStock == 0) {
					return 0;
				}else if(tmpStock == -1) {
					return -1;
				}else {
					E tmpValue = (E)prd;
					node.setValue(tmpValue);
					return tmpStock;
				}
			}
		}
		return -2;
	}
}
