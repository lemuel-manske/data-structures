# Data structures and algorithms - 2024.2 

That repository intends to keep the exercises implementations.

# [Lists](./list)

## [Static list](./list/src/main/java/list/StaticList.java)

Vector manipulation based on basic operations.

### 1st version
Allows creating static lists *only* for primitive integers and provides basic operations

### 2nd version
Allows creating static list for *any* object and also provides the additional `reverseOrder()` operation.

## [Linked list](/list/src/main/java/list/LinkedList.java)

List implementation through a link from node to node, in which each node keeps the element value.

### 1st version

Was implemented with simple nodes: they just stores a reference to the next node.

### 2nd version

Was refactored in order to implement the `remove()` method differently, 
as the nodes keeps both reference to the previous and to the next node as well.

## First test

Added `subList(startIdx, endIdx)` to `LinkedList` implementation, so it returns a reversed sub list of the input range.

Added `removeInRange(startIdx, endIdx)` to `StaticList` implementation, so it remove all the elements in range and set them free.

# [Stack](./stack)

Stacks are non-iterable data structures that allow the removal of only the top element at a time. 
They follow the LIFO (Last In, First Out) principle, meaning the last item added is the first to be removed.
Stacks have numerous applications in other data structures, such as graph traversal, tree processing, and more.

The operations are: push -to add- and pop -to remove.

## [Vector Stack](./stack/src/main/java/stack/VectorStack.java)

Depends upon a vector and has limited capacity.

## [List Stack](./stack/src/main/java/stack/ListStack.java)

Has no capacity limit and depend upon a linked list implementation.

# [Queues](./queue)

Queues are non-iterable data structures that allow the removal of only the first element at a time: elements are 
pushed to the end and pop at the start of the queue. Queues follow the FIFO approach (First in, First out).

FIFO data structure. The name is the intention here: it is a queue!

## [VectorQueue](./queue/src/main/java/queue/VectorQueue.java)

Implementation for queue with vectors which imply capacity limit.

## [ListQueue](./queue/src/main/java/queue/ListQueue.java)

Implementation for queue with linked list without capacity limit.

# [Tree](./tree)

Special data structure to handle data in an hierarchical manner.

## [Binary trees](./tree/src/main/java/tree/BinaryTree.java)

Have at most two nodes per parent node.

## [N-ary trees](./tree/src/main/java/tree/Tree.java)

There is no link limit: a parent node can have n nodes as children. 