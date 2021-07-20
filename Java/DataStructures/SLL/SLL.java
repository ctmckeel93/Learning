public class SLL {
    public Node head;
    public int count;
    public SLL(){
        this.head = null;
        this.count = 0;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            count += 1;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
            count += 1;
        }
    }    

    public SLL remove(){
        Node runner = head;
        while (runner.next.next != null) {
            System.out.println(runner);
            runner = runner.next;
        }
        System.out.println("Node to be removed: " + runner.next.value);
        runner.next = null;
        count -= 1;
        return this;
    }

    public Node removeAt(int val) {
        Node runner = head;
        Node prev = head;
        int idx = 0;

        if (val == 0){
            Node temp = head; 
            head = head.next;
            temp = null;
            return runner;
        }
        while (runner.next != null || idx != count ) {
            if (idx == val){
                Node returnNode = runner;
                Node temp = runner.next;
                prev.next = temp;
                runner.next = null;
                return returnNode;
            }
            else {
                prev = runner;
                runner = runner.next;
            }
            idx+=1;
        }
        return runner;
    }

    public Node find(int val) {
        Node runner = head; 
            while (runner.next != null ){
                if (runner.value == val){
                    System.out.println("Found it! " + runner + ":" + " " + runner.value);
                    return runner;
                }
                runner = runner.next;
            }
        System.out.println("We couldn't find the node");
        return runner; 
    }

    public void printValues() {
        Node runner = head;
        while (runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }


}