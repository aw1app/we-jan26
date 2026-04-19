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

    display() {
        let current = this.head;
        let displayOutput ="";
        while (current) {
            displayOutput=displayOutput+ current.data + " <--> ";
            current = current.next;
        };

        console.log(displayOutput.substring(0,displayOutput.length-5));
    }
}


// Creating a DLL
let DLL1 = new DoublyLinkedList();

DLL1.add(23);
DLL1.add(14);
DLL1.add(7);
DLL1.add(55);

DLL1.display();
