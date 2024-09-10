# Data structures and algorithms - 2024.2 

That repository intends to keep the exercises implementations.

## Static list

The first version tagged as [static-list](https://github.com/lemuel-manske/data-structures/tree/static-list) allows creating 
static lists *only* for primitive integers and provides basic operations

The second version tagged as [generic-static-list](https://github.com/lemuel-manske/data-structures/tree/generic-static-list) allows creating
static list for *any* object and also provides the additional `reverseOrder()` operation.

## Linked list

The first version tagged as [linked-list](https://github.com/lemuel-manske/data-structures/tree/linked-list) was implementing with simple nodes: they just stores a reference to the next node.

The version tagged as [linked-list-refactored](https://github.com/lemuel-manske/data-structures/tree/linked-list-refactored) was refactored in order to implement the `remove()` method differently, as the nodes keeps both reference to the previous and to the next node as well.

## First test

Added `subList(startIdx, endIdx)` to `LinkedList` implementation, so it return a reversed sub list of the input range.

Added `removeInRange(startIdx, endIdx)` to `StaticList` implementation, so it remove all the elements in range and set them free.
