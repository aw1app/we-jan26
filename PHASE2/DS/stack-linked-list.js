class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class StackLinkedList {

    constructor() {
        this.top = null;
    }

    push(data) {
        let newNode = new ListNode(data);

        // Check if the list is empty
        if (this.top === null) {
            this.top = newNode;
            return;
        }

        // if you are here then the stack had some elements
        newNode.next = this.top;
        this.top = newNode;
    }

    // pop
    pop() {
        if (this.top === null) {
            console.log(" Stack is empty. Nothing to pop")
            return;
        }

        // save the current top's data
        let poppedVal = this.top.data;

        this.top = this.top.next; // The new top

        return poppedVal;
    }

    // peek
    peek() {
        return this.top.data;
    }

    //helper functions
    isEmpty() {
        return this.top === null ? true : false;
    }

    size() {
        let counter = 0;

        let currNode = this.top;
        
        while (currNode !== null) {
            counter++;
            currNode = currNode.next;
        }

        return counter;
    }

}




// Test out
let stack1 = new StackLinkedList();

stack1.push(100);
stack1.push(200);
stack1.push(300);

// check the size now.
console.log("Stack size is :" , stack1.size())

// Let's pop now
let poppedVal = stack1.pop();
console.log("Stack pop returned  :" , poppedVal); // 300

poppedVal = stack1.pop();
console.log("Stack pop returned  :" , poppedVal) ; // 200

// check the size now.
console.log("Stack size is :" , stack1.size())

// TASK-2 : Modify the implementation to make it a fixed size stack.