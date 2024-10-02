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

LIFO data structure which allows the client to either add an element to the top and pops the element at the top.

## [Vector Stack](./stack/src/main/java/stack/VectorStack.java)

Depends upon a vector and has capacity limits.

## [List Stack](./stack/src/main/java/stack/ListStack.java)

Has no capacity limitation and depend upon a `LinkedList` implementation.

# [Queues](./queue)

FIFO data structure. The name is the intention here: it is a queue!

## [ListQueue](./queue/src/main/java/queue/ListQueue.java)

Implementation for queue with `LinkedList`.

## [VectorQueue](./queue/src/main/java/queue/VectorQueue.java)

Implementation for queue with vectors and also capacity limit.

# [Tree](./tree)

Special data structure to handle data in an hierarchical manner.

## [Binary trees](./tree/src/main/java/tree/BinaryTree.java)

Have at most two nodes per parent node.

## [N-ary trees](./tree/src/main/java/tree/Tree.java)

There is no link limit: a parent node can have n nodes as children. 