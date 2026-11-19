class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
}

class MergeTwoListSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                if (dummy == null){
                    dummy = list1;
                }
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            }
            else{
                if (dummy == null){
                    dummy = list2;
                }
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            }
        }
        while (list1 != null){
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            }
        while (list2 != null){
            dummy.next = list2;
            list2 = list2.next;
            dummy = dummy.next;
        }
        return result.next;
    }
}

public class LeetCode21 {
    public static void main(String[] args){
        MergeTwoListSolution solution = new MergeTwoListSolution();
        ListNode list1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode list2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        list1.next = node1;
        list1.next.next = node2;
        list2.next = node3;
        list2.next.next = node4;
        // while (list1 != null){
        //     System.out.println(list1.val);
        //     list1 = list1.next;
        // }

        ListNode result = solution.mergeTwoLists(list1, list2);
        
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
