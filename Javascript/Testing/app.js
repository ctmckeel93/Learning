const SLL = require('./scripts/sll')

const sll = SLL.fromValues(10,20,30,40,50);

sll.removeAtIndex(2); 
sll.printValues();

