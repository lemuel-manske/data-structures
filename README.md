# Data structures and algorithms - 2024.2 

That repository intends to keep the exercises implementations.

# Lists

## Static list

Vector manipulation based on basic operations.

### 1st version
Allows creating static lists *only* for primitive integers and provides basic operations

### 2nd version
Allows creating static list for *any* object and also provides the additional `reverseOrder()` operation.

## Linked list

List implementation through a link from node to node, in which each node keeps the element value.

### 1st version

Was implemented with simple nodes: they just stores a reference to the next node.

### 2nd version

Was refactored in order to implement the `remove()` method differently, 
as the nodes keeps both reference to the previous and to the next node as well.

## First test

Added `subList(startIdx, endIdx)` to `LinkedList` implementation, so it returns a reversed sub list of the input range.

Added `removeInRange(startIdx, endIdx)` to `StaticList` implementation, so it remove all the elements in range and set them free.

# Stack

FIFO data structure which allows the client to either add an element to the top and pops the element at the top.

## Vector Stack

Depends upon a vector and has capacity limits.

## ListStack

Has no capacity limitation and depend upon a `LinkedList` implementation.
