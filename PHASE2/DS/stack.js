
class Stack {

    constructor() {
        this.items = [];
    }


    // push (data)

    push(data) {
        this.items.push(data);
    }

    // Pop
    pop() {

        if (this.isEmpty()) {
            console.log(" Underflow error");
            return;
        }
        return this.items.pop();
    }

    // Peek - will return the TOP element
    peek() {
        if (this.isEmpty()) {
            console.log(" Underflow error");
            return;
        }
        return this.items[this.items.length - 1];
    }




    // helper functions
    isEmpty() {
        return this.size() === 0 ? true : false;
    }

    size() {
        return this.items.length;
    }

}

// Test out
let stack1 = new Stack();
stack1.push(10);
stack1.push(20);
stack1.push(30);

// check the size now.
console.log("Stack size is :" , stack1.size())

// Let's pop now
let poppedVal = stack1.pop();
console.log("Stack pop returned  :" , poppedVal); // 30

poppedVal = stack1.pop();
console.log("Stack pop returned  :" , poppedVal) ; // 20

// TASK : Modify the implementation to make it a fixed size stack.