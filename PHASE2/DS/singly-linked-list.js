class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}


class SinglyLinkedList {

    constructor() {
        this.head = null;
    }

    //1. add to the end of the list
    add(data) {
        let newNode =  new ListNode(data);

        if(this.head===null){
            this.head = newNode;
            return;
        }

        let currentNode = this.head;

         while (currentNode.next !== null) {
             currentNode = currentNode.next;
         }

         // if we are here, we are at the tail node 
         currentNode.next = newNode;
    }


    display() {
        let currentNode = this.head;
        while (currentNode !== null) {
            console.log(currentNode.data, "-->");
            currentNode = currentNode.next
        }
    }

}


// Try out
// node1 = new ListNode(45);
// node2 = new ListNode(67);
// node1 = new ListNode(44);
// node2 = new ListNode(78);
// node1 = new ListNode(12);

let linkedlist1 = new SinglyLinkedList();
linkedlist1.add(45);
linkedlist1.add(67);
linkedlist1.add(44);

linkedlist1.display();