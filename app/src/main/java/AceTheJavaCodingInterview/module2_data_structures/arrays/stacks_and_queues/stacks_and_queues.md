## Stacks and Queues

A collection designed for holding elements prior to processing. Besides, basic Collection operations, queues provide additional insertion, extraction, and inspection operations. Each of these methods exists in two forms: one throws an
exception if the operation fails, the other returns a special value (either null or false, depending on the operation). The latter form of the insert operation is designed specifically for use with capacity-restricted Queue implementations;
in most implementations, insert operations cannot fail.

| # | Action | Method <>(Throws Exception) | Method (Returns special value) |
|-|-|-|-|
| 1. | Insert | add(e) | offer(e) |
| 2. | Remove | remove() | poll() |
| 3. | Examine | element() | peek() |
|||||

`Queues` typically, but do not necessarily, order elements in a `FIFO`(first-in-first-out) manner. Among the exceptions are priority queues, which order elements according to a supplied comparator, or the elements' natural ordering,
and`LIFO`queues (or stacks) which order the elements`LIFO` (last-in-first-out). Whatever the ordering used, the head of the queue is that element which would be removed by a call to remove() or poll(). In a FIFO queue, all new elements are
inserted at the tail of the queue. Other kinds of queues may use different placement rules. Every Queue implementation must specify its ordering properties.

The offer method inserts an element if possible, otherwise returning false. This differs from the Collection.add method, which can fail to add an element only by throwing an unchecked exception. The offer method is designed for use when
failure is a normal, rather than exceptional occurrence, for example, in fixed-capacity (or "bounded") queues.

The `remove()` and `poll()` methods remove and return the head of the queue. Exactly which element is removed from the queue is a function of the queue's ordering policy, which differs from implementation to implementation. The `remove()`
and `poll()` methods differ only in their behavior when the queue is empty: the `remove()` method throws an exception, while the `poll()` method returns null.

The `element()` and `peek()` methods return, but do not remove, the head of the queue.

The Queue interface does not define the blocking queue methods, which are common in concurrent programming. These methods, which wait for elements to appear or for space to become available, are defined in
the `java.util.concurrent.BlockingQueue` interface, which extends this interface.

Queue implementations generally do not allow insertion of null elements, although some implementations, such as LinkedList, do not prohibit insertion of null. Even in the implementations that permit it, null should not be inserted into a
Queue, as null is also used as a special return value by the poll method to indicate that the queue contains no elements.

Queue implementations generally do not define element-based versions of methods `equals` and `hashCode` but instead inherit the identity based versions from class Object, because element-based equality is not always well-defined for queues
with the same elements but different ordering properties.

#### public interface Queue<E> extends Collection<E>

Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an `IllegalStateException` if no space is currently available.

Params:
**e** – the element to add
**Returns**: true (as specified by Collection.add)
**Throws**:
. `IllegalStateException` – if the element cannot be added at this time due to capacity restrictions
. `ClassCastException` – if the class of the specified element prevents it from being added to this queue
. `NullPointerException` – if the specified element is null and this queue does not permit null elements
. `IllegalArgumentException` – if some property of this element prevents it from being added to this queue

`boolean offer(E e);`
Retrieves and removes the head of this queue. This method differs from `poll()` only in that it throws an exception if this queue is empty.
. **return**: the head of this queue
. **throws** `NoSuchElementException` if this queue is empty.

`E remove();`
Retrieves and removes the head of this queue, or returns null if this queue is empty.
. **return**: the head of this queue, or `null` if this queue is empty.

`E poll();`
Retrieves, but does not remove, the head of this queue. This method differs from `peek()` only in that it throws an exception if this queue is empty.
. **return**: the head of this queue
. **throws**: `NoSuchElementException` if this queue is empty.

`E element();`
Retrieves, but does not remove, the head of this queue, or returns `null` if this queue is empty.
. **return**: the head of this queue, or `null` if this queue is empty.

`E peek();`