public class SLLTest {
    public static void main(String[] args){
        SLL sll1 = new SLL();
        sll1.add(3);
        sll1.add(4);
        sll1.add(10);
        sll1.add(5);
        sll1.add(15);
        sll1.add(2);
        sll1.printValues();
        System.out.println(sll1.count);
        sll1.find(3);
        sll1.removeAt(4);
        sll1.printValues();
    }
}