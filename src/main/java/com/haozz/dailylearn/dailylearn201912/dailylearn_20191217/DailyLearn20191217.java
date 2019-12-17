package com.haozz.dailylearn.dailylearn201912.dailylearn_20191217;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author haozhezhe@yunquna.com
 * @date 19:40 2019/12/17
 */
public class DailyLearn20191217 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverseList2(n1);
    }

    /**
     * 方法一：迭代
     * 假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
     * <p>
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
     * 空间复杂度：O(1)。
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //入参为空或只有一个元素，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        //定义前一个节点
        ListNode pre = null;

        ListNode curr = head;

        while (curr != null) {
            //1.定义临时节点，存储当前节点的下一个节点
            ListNode temp = curr.next;

            //2.将当前节点的下一个节点设置为上一个节点
            curr.next = pre;

            //3.将当前节点赋值给“前一个节点”，以便遍历到下一个节点的时候使用
            pre = curr;

            //4.将第1步中定义的临时节点覆给当前节点，进入下一个节点遍历
            curr = temp;
        }

        //此处需要返回pre
        return pre;
    }


    /**
     * 方法二：递归
     * 递归版本稍微复杂一些，其关键在于反向工作。假设列表的其余部分已经被反转，现在我该如何反转它前面的部分？
     *
     * 要小心的是 n1 的下一个必须指向 Ø 。如果你忽略了这一点，你的链表中可能会产生循环。如果使用大小为 2 的链表测试代码，则可能会捕获此错误。
     *
     * 复杂度分析
     *
     * 时间复杂度 O(n)，假设 n 是列表的长度，那么时间复杂度为 O(n)。
     * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
     *
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
