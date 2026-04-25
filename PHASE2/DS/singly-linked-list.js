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

    //Case-1. add to the end of the list
    add(data) {
        let newNode = new ListNode(data);

        // check if the list is empty
        if (this.head === null) {
            this.head = newNode;
            return;
        }

        // if here, the list had atleast one element.
        // create a dummy node and navigate till the tail node
        let currentNode = this.head;

        while (currentNode.next !== null) {
            currentNode = currentNode.next;
        }

        // if we are here, we are at the tail node 
        currentNode.next = newNode;
    }

    // case -2: add the new node at some position n
    addAtPosition(data, position) {
        let newNode = new ListNode(data);

        if (position === 0) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        };

        // position > 0
        // navigate to the (position-1)'th node
        let count = 0;
        let currentNode = this.head;

        while (count < position - 1) {
            // special case - if we are at the tail node now...
            if (currentNode.next === null) {
                console.log("Cannot add at position ", position, " which is beyond the length of the linked list");
                return;
            }

            currentNode = currentNode.next;
            count++;
        }

        // if we are here, currentNode is at given position  
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }



    // DELETE Ops
    deleteAtPosition(position) {

        if (position === 0) {
            this.head = this.head.next;
            return;
        }

        // Delete at position > 0
        // navigate to the (position-1)'th node
        let count = 0;
        let currentNode = this.head;

        while (count < position - 1) {
            // TODO: special case - if we are at the tail node now...
            //...

            currentNode = currentNode.next;
            count++;
        }

        // if we are here, currentNode is at one position before the node we want to delete 
        currentNode.next = currentNode.next.next;
    }


    display() {
        let currentNode = this.head;

          if(currentNode == null) // the list was empty
          { console.log("list is empty" ); return;}

        let output = "";      

        while (currentNode.next !== null) {
            //console.log(currentNode.data, "-->");
            output = output + " " + currentNode.data + " ->";
            currentNode = currentNode.next
        }

        console.log(output.substring(0, output.length - 3));
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
console.log("-----")

linkedlist1.addAtPosition(12, 0);
linkedlist1.display();
console.log("-----");

linkedlist1.addAtPosition(7, 2);
linkedlist1.display();

linkedlist1.addAtPosition(66, 12);
linkedlist1.display();

console.log("--Deleting at pos 0 --");
linkedlist1.deleteAtPosition(0);
linkedlist1.display();

console.log("--Deleting at pos 2 --");
linkedlist1.deleteAtPosition(2);
linkedlist1.display();