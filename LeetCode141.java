import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

class CycleSolution {
    public boolean hasCycle(ListNode head) {
        ListNode start = head;
        ListNode current = head;

        while (current != null){
            if (current.next != null && current.next == start){
                return true;
            }

            current = current.next;
            if (current != null && current.next == start){
                return true;
            }

            if (current != null){
                current = current.next;
                start = start.next;
            }
            
        }
        return false;
    }
}

public class LeetCode141 {
    public static void main(String[] args){
        CycleSolution solution = new CycleSolution();

    }
}
