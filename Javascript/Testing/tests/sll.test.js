const SLL = require('../scripts/sll')

// Inserts
describe('#insertAtHead', () => {
    test('Successfully insert a new node at the front of a linked list', () => {
        const sll = new SLL();
        sll.insertAtHead(10);
        sll.insertAtHead(20);

        expect(sll.head.value).toBe(20);
        expect(sll.head.next.value).toBe(10);
        expect(sll.count).toBe(2);
    })
})

describe('#append', () => {
    test('Should successfully insert a node to the end of a list', () => {
        const sll = SLL.fromValues(10,20,30,40,50);

        expect(sll.append(60).next).toBeNull();
        expect(sll.count).toBe(6);
    })
})

describe('insertAtIndex', () => {
    describe('index less than 0', () => {
        test('should return null', () => {
            const sll = SLL.fromValues(10,20,30,40,50);

            expect(sll.insertAtIndex(-1)).toBeNull(); 
        })
    })

    describe('index greater than length of list', () => {
        test('should return null', () => {
            const sll = SLL.fromValues(10,20,30,40,50);
            expect(sll.insertAtIndex(5)).toBeNull();
        })
    })

    describe('index in the middle', () => {
        test('Should successfully add the given element to the list at the desired index', () => {
            const sll = SLL.fromValues(10,20);
            sll.insertAtIndex(1, 15); 

            expect(sll.getByIndex(1).value).toBe(15)
            expect(sll.getByIndex(1).next.value).toBe(20);
            expect(sll.head.value).toBe(10);
        })
    })
})


// Getters
describe('#getByIndex', () => {
    describe('with index less than 0', () => {
        test('it returns null', () => {
            const sll = SLL.fromValues(10, 20);

            expect(sll.getByIndex(-1)).toBeNull();
        })
    })
    
    describe('#getByIndex', () => {
        describe('with index greater than the length of the list', () => {
            test('it returns null', () => {
                const sll = SLL.fromValues(10, 20);
                expect(sll.getByIndex(5)).toBeNull();
            })
        })
    })
    
    describe('with index 0', () => {
        test('returns the head', () => {
            const sll = SLL.fromValues(10,20);
            expect(sll.getByIndex(0).value).toBe(10);
        })
    })
    
    describe('with any index within', () => {
        test('return the value at the proper index', () => {
            const sll = SLL.fromValues(10,20,30,40,50);
            
            expect(sll.getByIndex(3).value).toBe(40);
        })
    })
})

// Removals 

describe('#removeAtHead', () => {
    test('Should successfully remove the first node in the list', () => {
        const sll = SLL.fromValues(10,20,30,40,50); 
        sll.removeAtHead();

        expect(sll.head.value).toBe(20); 
        expect(sll.count).toBe(4); 
    })
})

describe('#pop', () => {
    test('Should successfully remove the element at the end of list', () => {
        const sll =  SLL.fromValues(10,20,30);

        expect(sll.pop().value).toBe(30); 
        expect(sll.getByIndex((sll.count - 1)).value).toBe(20); 
        expect(sll.count).toBe(2);
    })
})

describe('#removeAtIndex', () => {
    describe('index less than 0', () => {
        test('should return null', () => {
            const sll = SLL.fromValues(10,20,30)
            expect(sll.removeAtIndex(-1)).toBeNull();
        })
    })

    describe('index greater than list length', () => {
        test('should return null', () => {
            const sll = SLL.fromValues(10,20,30)
            expect(sll.removeAtIndex(5)).toBeNull();
        })
    })

    describe('index in the middle', () => {
        test('should remove the element at given index and return the value', () => {
            const sll = SLL.fromValues(10,20,30,40,50);

            expect(sll.removeAtIndex(2).value).toBe(30);
            expect(sll.getByIndex(2).value).toBe(40); 
            expect(sll.count).toBe(4);
        })
    })
})