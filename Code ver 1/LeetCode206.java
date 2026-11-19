class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
}
class ReverseLinkedListSolution {
    public ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode();
        ListNode prev = null;
        ListNode current = head;

        while (current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        return prev;
    }
}

public class LeetCode206 {
    public static void main(String[] args){
        ReverseLinkedListSolution solution = new ReverseLinkedListSolution();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        
        ListNode current = head;
        while (current != null){
            System.out.println(current.val);
            current = current.next;
        }
        
        ListNode result = solution.reverseList(head);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
        
    }
}
