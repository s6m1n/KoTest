/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

 // 1,1,2,3,3
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if(head == null || head.next == null) return head
        val head = head!!
        var tmp = head!!
        var max = tmp.`val` // smaller one
        while (tmp.next!=null){
            var target = tmp.next.`val` // 3
            if (max < target) {  // -> not duplicated
                tmp = tmp.next // move to next
                max = target  // update max
            }
            else { // -> duplicated
                if(tmp.next?.next == null) {
                    tmp.next = null // disconnect with duplicated element
                    return head
                }
                tmp.next = tmp.next.next // Move 2times to ignore duplicated one
            }
        }
        return head
    }
}

/*

1. save head to head
3. variable tmp == head
2. variable max == tmp.`val` // smaller one
4. while (tmp.next!=null){
    var target = tmp.next.`val`
    if (min < target) {  // -> not duplicated
        tmp = tmp.next
        max == tmp.`val`
    }
    else { // -> duplicated
        if(tmp.next?.next? == null) {
            tmp.next = null
            return head
        }
        tmp.next = tmp.next.next
    }
}

 */