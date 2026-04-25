class Queue {

    constructor() {
        this.items = [];
        this.front = null;
        this.rear = null;
    }

    // adding data - add to the rear
    enqueue(data) {
        this.items.push(data);  // array's push method will append to the end (rear position of the queue)
    }

    // removing - remove from the front
    dequeue() {
        return this.items.shift(); // array's shift method will remove from the start of the array (front of the queue)
    }

    getFront() {
        return this.items[0];
    }

    getRear() {
        return this.items[this.items.length - 1];
    }

    // TASK -helper functions
    size() {

    }

    isEmpty() {

    }

}

// Test out with 57, 12 and 17
let queue1 = new Queue(); // Empty queue

queue1.enqueue(57);
queue1.enqueue(12);
queue1.enqueue(17);

console.log(" Queue's Front is ", queue1.getFront());
console.log(" Queue's Rear is ", queue1.getRear());

queue1.enqueue(66);

console.log(" Queue's Front after enqueing 66  is ", queue1.getFront());
console.log(" Queue's Rear  after enqueing 66 is ", queue1.getRear());

// - Let's deque now
queue1.dequeue();
console.log(" Queue's Front after dequeue  is ", queue1.getFront());
console.log(" Queue's Rear  after dequeue is ", queue1.getRear());