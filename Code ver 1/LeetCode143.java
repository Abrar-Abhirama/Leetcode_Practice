
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class ReorderListSolution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            fast = fast.next;
            
            if (fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode temp = new ListNode();
        ListNode temp2 = new ListNode();
        ListNode prev = null;
        ListNode curr = second;
        
        while (curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        while (head != null && prev != null){
            temp = head.next;
            head.next = prev;
            temp2 = prev.next;
            head = head.next;
            head.next = temp;
            prev = temp2;
            head = head.next;
        }
        
    }
}


public class LeetCode143{
    public static void main(String[] args){
        ReorderListSolution solution = new ReorderListSolution();
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
        solution.reorderList(head);
    }
}