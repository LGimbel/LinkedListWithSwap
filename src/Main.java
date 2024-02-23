public class Main {
    //this is a branch of a branch which is based off of code written by Chevan Richards at Capitol Technology University modified By Liam Gimbel both times.

    public static void main(String[] args) {
        System.out.println("Hello world!");
        LinkedList List = new LinkedList();
        Node current = List.headptr;

        List.add(10);
        List.add(20);
        List.add(20);
        LinkedList ListB = new LinkedList();
        Node currentB = ListB.headptr;
        List.add(5);
        ListB.add(15);
        ListB.add(20);
        LinkedList ListC = LinkedList.joinNSwap(20,3,List.headptr,ListB.headptr);
        current = ListC.headptr;
        while (current !=null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("total:" + List.countNodes());
    }
}
class Node{

    public int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    public Node headptr = null;
    public LinkedList(){
        this.headptr = null;
    }
    public void add(int data){
        Node newNode = new Node(data);
        newNode.next = this.headptr;
        this.headptr = newNode;

    }
    public static LinkedList joinNSwap(int target, int newValue, Node headA, Node headB){
        LinkedList list = new LinkedList();
        //swappage here
        //attempted to use terniaries instead of if else ended in disaster.
        while (headA != null || headB != null) {
            if (headA != null&& headA.data == target){
                list.add(newValue);
                headA = headA.next;
            } else if (headB != null && headB.data == target) {
                list.add(newValue);
                headB = headB.next;
            } else
            {
                // if no sway use here
                if (headA != null) {
                    list.add(headA.data);
                    headA = headA.next;
                }
                if (headB !=null) {
                    list.add(headB.data);
                    headB = headB.next;
                }
            }
        }

        return list;
    }
    public int countNodes(){
        Node current = headptr;
        int count = 1;

        while (current !=null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public void removeNode(int data) {
        Node current = headptr;
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (prev == null) {
                headptr = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }




}
