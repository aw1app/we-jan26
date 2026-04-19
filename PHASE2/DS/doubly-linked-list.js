class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


class DoublyLinkedList {

    constructor() {
        this.head = null;
        this.tail = null;
    }



    add(data) {
        let newNode = new ListNode(data);

        // check for empty list
        if (this.head === null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // the list contains atleast one node
        // so traverse till the tail node and then append the newNode
        let currentNode = this.head;

        while (currentNode.next !== null) {
            currentNode = currentNode.next;
        }

        // you (currentNode) are at the tail node.
        currentNode.next = newNode;
        newNode.prev = currentNode;
        this.tail = newNode;
    }

    // Update - Task for you.
    update(data, n) {

    }

    deleteAtPosition(position) {

        // Case 1: delete the head. i.e., position is 0
        if (position === 0) {
            this.head = this.head.next;

            //subcases - after deleting the head above, now the list can be empty or have some elements
            if (this.head !== null) { // case when the list has some elements even after deleting the head
                this.head.prev = null;
            } else { // case when the list became empty after deleting the head
                this.tail = null
            };

            return;
        }

        //Case - 2 position > 0
        // navigate to the (position-1)'th node
        let count = 0;
        let currentNode = this.head;

        while (count < position) {
            currentNode = currentNode.next;
            count++;
        }

        // you are now at the node you want to delete
        currentNode.next.prev = currentNode.prev; //P.n.p = P.p
        currentNode.prev.next = currentNode.next; //P.p.n = P.n
    }

    // Task update (data, position)


    display() {
        let current = this.head;
        let displayOutput = "";
        while (current) {
            displayOutput = displayOutput + current.data + " <--> ";
            current = current.next;
        };

        console.log(displayOutput.substring(0, displayOutput.length - 5));
    }
}


// Creating a DLL
let DLL1 = new DoublyLinkedList();

DLL1.add(23);
DLL1.add(14);
DLL1.add(7);
DLL1.add(55);

DLL1.display();

console.log("-- Deleting position 2");
DLL1.deleteAtPosition(2);
DLL1.display();

console.log("-- Deleting head...");
DLL1.deleteAtPosition(0);
DLL1.display();