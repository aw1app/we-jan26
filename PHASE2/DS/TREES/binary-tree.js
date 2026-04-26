class TreeNode {

    constructor(data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}


class BinarySearchTree {

    constructor() {
        this.root = null;
    }

    insert(data) {
        let newNode = new TreeNode(data);

        if (this.root === null) {
            this.root = newNode;
            return;
        } else {
            // if you are here, then the tree is non empty
            this.insertNode(newNode, this.root);
        }

    }


    insertNode(newNode, currNode) {

        if (newNode.data < currNode.data) {
            if (currNode.left === null)
                currNode.left = newNode;
            else
                this.insertNode(newNode, currNode.left);
        }
        else {
            if (currNode.right === null)
                currNode.right = newNode;
            else
                this.insertNode(newNode, currNode.right);
        }

    }


    // Traversals
    // 1. Pre Order Traversal M L R

    preOrderTraversal( node, result = [ ] ){

        if (node ) {  // check if the node is non null            
            
                result.push(node.data);

                this.preOrderTraversal(node.left,result );           
           
                this.preOrderTraversal(node.right,result );

        }
        
        return result;
    }


    //2. In order L M R 
     inOrderTraversal ( node, result = [ ] ){

        if (node ) {  // check if the node is non null  
            
                this.inOrderTraversal(node.left,result );   
            
                result.push(node.data);                        
           
                this.inOrderTraversal(node.right,result );

        }
        
        return result;
    }


}



//
let tree1 = new BinarySearchTree();

tree1.insert(34);
tree1.insert(23);
tree1.insert(99);
tree1.insert(44);
tree1.insert(12);

console.log('Pre-order traversal:', tree1.preOrderTraversal(tree1.root));

console.log('In-order traversal:', tree1.inOrderTraversal(tree1.root));