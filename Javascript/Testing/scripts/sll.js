const Node = require('./node');

class SLL {
    constructor(){
        this.head = null;
        this.count = 0; 

    }

    // Inserts 
    insertAtHead(val) {
        const newNode = new Node(val, this.head);
        this.head = newNode;
        this.count++ 
        return this 
    } 

    append(val){
        const newNode = new Node(val, null);
        let runner = this.head;

        while (runner.next){
            runner = runner.next; 
        }
        runner.next = newNode; 
        this.count++
        return newNode;
    }

    insertAtIndex(idx, val){
        if (idx < 0 || idx >= this.count) return null;

        let runner = this.head;
        let prev = null;
        const newNode = new Node(val, null);
        
        for (let i = 0; i < this.count; i++){
            if (i == idx) {
                prev.next = newNode; 
                newNode.next = runner 
                return this;
            }
            prev = runner; 
            runner = runner.next; 
        }
    }

    // Getters 
    getByIndex(idx) {
        if (idx < 0) return null;
        if (idx >= this.count) return null;
        let runner = this.head;
        
        for (let i = 0; i < this.count; i++){
            if (i == idx) return runner;
            runner = runner.next;
        }
    }


    // Removers 
    removeAtHead() {
        let temp = this.head;
        this.head = this.head.next;
        temp = null;
        this.count-- 
        return temp;
    }

    pop() {
        if (this.count == 1) return this.removeAtHead(); 

        let runner = this.head; 
        while (runner.next.next) {
            runner = runner.next; 
        }
        let temp = runner.next; 
        runner.next = null; 
        this.count-- 
        return temp;
    }

    removeAtIndex(idx) {
        if (idx < 0 || idx >= this.count) return null  

        if (idx == 0) return this.removeAtHead(); 
        if (idx == this.count - 1) return this.pop(); 

        let runner = this.head; 
        for (let i =0; i < idx-1; i++){
            runner = runner.next; 
        }
        let temp = runner.next; 
        runner.next = runner.next.next 
        temp.next = null; 
        this.count--
        return temp; 

    }

    // Display
    printValues() {
        let output = "";
        let runner = this.head;
        while (runner) {
            output = `${output}${runner.value} -> `
            runner = runner.next;
        }
        console.log(`${output}null`)
    }

    
} 

SLL.fromValues = (...values) => {
    const sll = new SLL();
    for (let i = values.length -1; i >= 0; i--) {
        sll.insertAtHead(values[i])
    }
    return sll;
}

module.exports = SLL;