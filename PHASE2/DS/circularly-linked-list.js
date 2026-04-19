class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}


class CircularLinkedList {

    constructor() {
        this.head = null;
    }

    // Create: Add a new node to the end of the list 
    add(data) {
        let newNode = new ListNode(data);

        // if the list was empty
        if (this.head == null) {
            this.head = newNode;
            newNode.next = this.head;
            return;
        }

        //if our list had some elements
        let currentNode = this.head;

        while (currentNode.next !== this.head) {
            currentNode = currentNode.next;
        }

        // Now we are at the Tail node
        currentNode.next = newNode;
        newNode.next = this.head;
    }

    deleteAtPosition(position) {

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

        let output = "";

        do {
            output = output + " " + currentNode.data + " ->";
            currentNode = currentNode.next
        }while  (currentNode !== this.head);

        console.log(output.substring(0, output.length - 3));
    }

}


const list = new CircularLinkedList();

list.add(1);
list.add(2);
list.add(3);
list.add(21);
list.add(44);
list.add(13);
list.display(); // Displays 1, 2, 3
list.deleteAtPosition(2); // Deletes the first element
list.display(); // Displays 4, 3 
