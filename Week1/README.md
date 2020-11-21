# 第一周学习总结

## 数组（Array）

### 概念定义

数组（Array）是一种**线性表**数据结构。它用一组**连续的内存空间**来存储一组具有**相同类型的数据**。

- 线性表：数据排成像一条线一样的结构，属于一维数据结构，其他如链表、队列、栈等都属于线性表结构。
- 连续的内存空间和相同类型的数据：正因为这两个限制，数组支持随机访问特性，通过角标可以支持 O(1) 查询，查询元素可通过二分查找，复杂度为 O(logn) 但是要想在数组中删除、插入一个数据，为了保证连续性，需要做大量的数据搬移工作，复杂度为 O(n)。

### 实战题目解析

- [盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)
- [移动零](https://leetcode-cn.com/problems/move-zeroes/)
- [爬楼梯](https://leetcode.com/problems/climbing-stairs/)
- [两数之和](https://leetcode-cn.com/problems/two-sum/)
- [三数之和](https://leetcode-cn.com/problems/3sum/)

## 链表（Node）

### 概念定义

链表和数组一样，是一种线性表结构。从内存结构来看，链表的内存结构是不连续的内存空间，是将一组零散的内存块串联起来，从而进行数组存储的数据结构。链表中的每一个内存块被称为节点 Node，节点除了存储数据本身外，还需要记录链上下一个节点的地址，即后继指针 next。

### 链表特点

- 插入、删除数据效率高，O(1) 级别（只需要更改指针的指向即可），随机访问效率低，O(n) 级别（需要从链头至链尾进行遍历）。
- 和数组相比，内存空间消耗更大，因为每个存储数据的节点都需要额外的空间存储指针。

### 链表分类

**单链表**

- 每个节点只包含一个指针，即后继指针。
- 首节点和尾节点是单链表的亮哥特殊节点，首节点地址表示整条链表，尾节点的后继指针指向空地址 null。
- 插入和删除节点的时间复杂度为 O(1)，查询的时间复杂度为 O(n)。

**循环链表**

- 除了尾节点的后继指针指向首节点的地址外均与单链表一致。
- 适用于存储有循环特点的数据，比如约瑟夫问题。

**双向链表**

- 节点除了存储数据外，还有亮哥指针分别指向前一个节点地址（前驱指针 prev）和下一个节点地址（后继指针 next）。
- 首节点的前驱指针 prev 和尾节点的后继指针均指向空地址。
- 插入、删除操作比单链表效率更高，O(1)级别。以删除操作为例，删除操作分为2种情况：给定数据值删除对应节点和给定节点地址删除节点。对于前一种情况，单链表和双向链表都需要从头到尾进行遍历从而找到对应节点进行删除，时间复杂度为O(n)。对于第二种情况，要进行删除操作必须找到前驱节点，单链表需要从头到尾进行遍历直到 p->next = q，时间复杂度为O(n)，而双向链表可以直接找到前驱节点，时间复杂度为O(1)。
  对于一个有序链表，双向链表的按值查询效率要比单链表高一些。因为我们可以记录上次查找的位置p，每一次查询时，根据要查找的值与p的大小关系，决定是往前还是往后查找，所以平均只需要查找一半的数据。

**双向循环链表**

首节点的前驱指针指向尾节点，尾节点的后继指针指向首节点

### 实战题目解析

- [反转链表](https://leetcode.com/problems/reverse-linked-list/)
- [两两交换链表中的节点](https://leetcode.com/problems/swap-nodes-in-pairs)
- [环形链表](https://leetcode.com/problems/linked-list-cycle)
- [环形链表 II](https://leetcode.com/problems/linked-list-cycle-ii)
- [K 个一组翻转链表](https://leetcode.com/problems/reverse-nodes-in-k-group/)



## 跳表（待完善）

## 栈（Stack）

### 概念定义

- 先进者后出，后进者先出，这就是典型的『栈』结构。
- 从栈的操作特性来看，是一种是一种“操作受限”的线性表，只允许在端插入和删除数据。

### 示例代码

```java
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);
// [1, 2, 3, 4]
System.out.println(stack);
// 1
System.out.println(stack.search(4));

stack.pop();
stack.pop();
Integer topElement = stack.peek();
// 2
System.out.println(topElement);
// 2 的位置： 1
System.out.println("2 的位置： " + stack.search(2));
```

### 实战题目解析

- [有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)
- [最小栈](https://leetcode-cn.com/problems/min-stack/)
- [柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram)

## 队列（Queue）

### 概念定义

- 先进者先出，这就是典型的“队列”结构。
- 支持两个操作：入队enqueue()，放一个数据到队尾；出队dequeue()，从队头取一个元素。
- 队列也是一种“操作受限”的线性表，只支持两种基本操作：入队和出队。

队列的应用非常广泛，特别是一些具有某些额外特性的队列，比如循环队列、阻塞队列、并发队列。它们在很多偏底层的系统、框架、中间件的开发中，起着关键性的作用。比如高性能队列 Disruptor、Linux 环形缓存，都用到了循环并发队列；Java concurrent 并发包利用 ArrayBlockingQueue 来实现公平锁等。

### 示例代码

```java
Queue<String> queue = new LinkedList<>();
queue.offer("one");
queue.offer("two");
queue.offer("three");
queue.offer("four");
// [one, two, three, four]
System.out.println(queue);
// one
System.out.println(queue.poll());
// [two, three, four]
System.out.println(queue);
// two
System.out.println(queue.peek());
// [two, three, four]
System.out.println(queue);
// two
// three
// four
while (queue.size() > 0) {
  System.out.println(queue.poll());
}
```

### 实战题目解析

- [滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum)

## 双端队列

### 概念定义

- 简单理解：两端可以进出的 Queue，Deque - double ended queue
- 插入和删除都是 O(1) 操作

### 示例代码

```java
Deque<String> deque = new LinkedList<>();
deque.addFirst("a");
deque.addFirst("b");
deque.addLast("c");
// [b, a, c]
System.out.println(deque);
// b
System.out.println(deque.peek());
// [b, a, c]
System.out.println(deque);
while (deque.size() > 0) {
  System.out.println(deque.pollFirst());
}
```

## 优先队列（待完善）

### 概念定义

- 插入操作：O(1)
- 取出操作：O(logN) - 按照元素的优先级取出
- 底层具体实现的数据结构较为多样和复杂：heap、bst、treap
  Java 的 PriorityQueue https://docs.oracle.com/javase/10/docs/api/java/util/ PriorityQueue.html

## 复杂度分析

![常用数据结构复杂度](https://blog-figure-bed.oss-cn-shanghai.aliyuncs.com/2020/08/2020-11-21-152014.png)

## 参考链接

- [Java 源码分析（ArrayList）](http://developer.classpath.org/doc/java/util/ArrayList-source.html)
- [Linked List 的标准实现代码](http://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/)
- [Linked List 示例代码](http://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked Lists/code/LinkedList.java)
- [Java 源码分析（LinkedList）](http://developer.classpath.org/doc/java/util/LinkedList-source.html)
- LRU Cache - Linked list：[ LRU 缓存机制](http://leetcode-cn.com/problems/lru-cache)
- Redis - Skip List：[跳跃表](http://redisbook.readthedocs.io/en/latest/internal-datastruct/skiplist.html)、[为啥 Redis 使用跳表（Skip List）而不是使用 Red-Black？](http://www.zhihu.com/question/20202931)
- [Java 的 PriorityQueue 文档](http://docs.oracle.com/javase/10/docs/api/java/util/PriorityQueue.html)
- [Java 的 Stack 源码](http://developer.classpath.org/doc/java/util/Stack-source.html)
- [Java 的 Queue 源码](http://fuseyism.com/classpath/doc/java/util/Queue-source.html)
- [Python 的 heapq](http://docs.python.org/2/library/heapq.html)
- [高性能的 container 库](http://docs.python.org/2/library/collections.html)

## 本周作业

### 简单：

- 用 add first 或 add last 这套新的 API 改写 Deque 的代码
- 分析 Queue 和 Priority Queue 的源码
- [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
- [旋转数组](https://leetcode-cn.com/problems/rotate-array/)
- [合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)
- [合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)
- [两数之和](https://leetcode-cn.com/problems/two-sum/)
- [移动零](https://leetcode-cn.com/problems/move-zeroes/)
- [加一](https://leetcode-cn.com/problems/plus-one/)

### 中等：

- [设计循环双端队列](https://leetcode.com/problems/design-circular-deque)

### 困难：

- [接雨水](https://leetcode.com/problems/trapping-rain-water/)



















