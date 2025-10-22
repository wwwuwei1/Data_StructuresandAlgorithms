package utils

data class ListNode(
    var `val`: Int,
    var next: ListNode? = null
) {
    // 方便的构造方法
    constructor(vararg values: Int) : this(values[0]) {
        var current = this
        for (i in 1 until values.size) {
            current.next = ListNode(values[i])
            current = current.next!!
        }
    }

    // 打印链表的方法
    fun printList() {
        var current: ListNode? = this
        while (current != null) {
            print("${current.`val`} -> ")
            current = current.next
        }
        println("null")
    }
}