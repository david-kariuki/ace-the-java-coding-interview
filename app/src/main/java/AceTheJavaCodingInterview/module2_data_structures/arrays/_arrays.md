# Arrays

### Array Indexing

Each data element is assigned a numerical value called the index, which corresponds to the position of that item in the array. It is important to note that the value of the index is non-negative and always starts from zero. So the first
element of an array will be stored at index 0 and the last one at index size-1.

An index makes it possible to access the contents of the array directly. Otherwise, we would have to traverse through the whole array to access a single element.

### Types of Arrays#

Arrays can store **primitive** data-type values (e.g., `int`, `char`, `floats`, `boolean`, `byte`, `short`, `long`, etc.), **non-primitive** data-type values (e.g., Java Objects, etc.) or it can even hold references of other arrays. That
divides the arrays into two categories:

- One Dimensional Array.
- Multi-Dimensional Array.

<br>

### Notes

1. If the size and the values of an array are known in advance, we can use the array literal for adding elements in an array.
   - datatype[] arrayName = {Comma Separated list of values};
2. In Java, arrays are dynamically allocated. Arrays are stored in the memory using a reference pointer, which points to the first element.
3. Pointers - References are used to explicitly store memory locations that hold a value or an object.
4. A Two Dimensional Array is an array of references that holds references to other arrays.
5. In 2D arrays, all values must have the same data type. This means that you can’t store an array of integers next to an array of strings and vice versa. For example, if one array is declared of type int, then its pointer can’t point to
   the string type array. Each element must be of the same data type.
