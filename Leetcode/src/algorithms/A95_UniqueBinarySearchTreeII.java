package algorithms;

import java.util.ArrayList;
import java.util.List;

import data.TreeNode;

public class A95_UniqueBinarySearchTreeII {
	
	public static void main(String[] args) {
		A95_UniqueBinarySearchTreeII a95 = new A95_UniqueBinarySearchTreeII();
		List<TreeNode> result = a95.generateTrees(0);
//		List<TreeNode> result = a95.generate(1, 3);
		System.out.println(result.size());
		for(TreeNode t : result) {
			TreeNode.printTreeNode(t);
			System.out.println("...................");
		}
	}
	
	//Accepted solution
	public List<TreeNode> generateTrees(int n) {
		//this part is ... only for a test case ...which wants to distinguish [] with [[]]...xD
		if(n == 0) {
	        List<TreeNode> trees = new ArrayList<TreeNode>();
	        trees.add(null);
	        return trees;
		}
        return generate(1, n);
    }
    
    private List<TreeNode> generate(int b, int e) {
        
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(b > e) return trees;
        if(b == e) {
            trees.add(new TreeNode(b));
            return trees;
        }

        for(int i = b; i <= e; i++) {
            TreeNode root = new TreeNode(i);
            List<TreeNode> hasleft = build(generate(b, i - 1), true, root);
            List<TreeNode> right = generate(i + 1, e);
            for(TreeNode r : hasleft){
                trees.addAll(build(right, false, r));

            }
        }
        
        return trees;
    }
    
    private List<TreeNode> build(List<TreeNode> children, boolean left, TreeNode root){
        List<TreeNode> trees = new ArrayList<TreeNode>();
        
    	if(children.isEmpty()) {
//    		if(left){
//    			TreeNode temp = new TreeNode(root.val);
//    			trees.add(temp);
//    		}else 
    		trees.add(root);
    		return trees;
    	}
    	if(left) {
    		for(TreeNode l : children) {
    			TreeNode temp = new TreeNode(root.val);
    			temp.left = l;
    			trees.add(temp);    		}
    	} else {
    		for(TreeNode r : children) {
    			TreeNode temp = new TreeNode(root.val);
    			temp.left = root.left;
    			temp.right = r;
    			trees.add(temp); 
    		}
    	}
    	return trees;
//    	if(left.isEmpty()) {
//    		for(TreeNode r : right) {
//    			TreeNode temp = new TreeNode(root.val);
//    			temp.right = r;
//    			trees.add(temp);
//    		}
//    		return trees;
//    	} else if(right.isEmpty()){
//    		for(TreeNode l : left) {
//    			TreeNode temp = new TreeNode(root.val);
//    			temp.left = l;
//    			trees.add(temp);
//    		}
//    		return trees;
//
//    	} else {
//    		for(TreeNode l : left) {
//    			TreeNode temp = new TreeNode(root.val);
//    			temp.left = l;
//                for(TreeNode r : right) {
//                	temp.right = r;
//                    trees.add(temp);
//                }
//            }
//    		return trees;
//    	}
    }
}
