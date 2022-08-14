# Saved concepts and formulae

## Big O Notation

<br>1. A function `f(n)`, is considered `O(g(n))` (read as big oh of `g(n)`) if there exists some positive real constant `c` and an integer `n_0 > 0`, such that the following inequality holds for all n >= n_0 <br>
`f(n) <= cg(n)`

<br>2. People tend to write `f(n) = O(g(n))`, which isn’t technically accurate. A lot of functions can satisfy the `O(g(n))` conditions. Therefore, `O(g(n))` is a set of functions, and it is okay to say that `f(n)` belongs to `O(g(n))`.

<br>3. `f(n)` will grow no faster than a constant multiple of `g(n)`. Put yet another way, the rate of growth of `f(n)` is within constant factors of that of `g(n)`.

<br>4. Suppose algorithms `A` and `B` have running time of `O(n)` and `O(n^2)`, respectively. For sufficiently large input sizes, algorithm `A` will run faster than algorithm `B`. That does not mean that algorithm `A` will always run faster than algorithm `B`.
Algorithm A and B both have running time `O(n)`. The execution time for these algorithms for very large input sizes, will be within constant factors of each other. For all practical purposes, they are considered equally good.

<br> 5. Simplified asymptotic analysis
Once we have obtained the time complexity of an algorithm by counting the number of primitive operations, we can arrive at the Big O notation for the algorithm simply by:

- Dropping the multiplicative constants with all terms.
- Dropping all but the highest order term.
- Therefore, `n^2 + 2n + 1` is `O(n^2)` while `n^5 + 4n^3 + 2n + 43` is `O(n^5)`.

The constant coefficients have become insignificant in the Big O notation. Recall that these constants represent the number of primitive operations on a given line of code. This means that, while analyzing code, counting a line of code
as contributing 4 primitive operations is as good as counting it as 1 primitive operation. What matters is correctly counting the number of times each line of code is repeated.

<br><br> 6. A comparison of some common functions
It is easy to work with simple polynomials in n, but when the time complexity involves other types of functions like log(), you may find it hard to identify the “highest order term”. The following table lists some commonly encountered
functions in ascending order of rate of growth. Any function can be given as a Big O of any other function that appears later in this table.

| # | Name | Function |
|-|-|-|
| 1.  | Any constant | Constant |
| 2.  | logn | Logarithmic |
| 3.  | $${log^2n}$$ | Log-square |
| 4.  | $$\sqrt{n}$$ | Root-n |
| 5.  | n | Linear |
| 6.  | nlogn | Linearithmic |
| 7.  | $${n^2}$$ | Quadratic |
| 8.  | $${n^3}$$ | Cubic |
| 9.  | $${n^4}$$ | Quartic |
| 10. | $${2^n}$$ | Exponential |
| 11. | $${e^n}$$ | Exponential |
| 12. | n! | n-Factorial |
||||

<br><br> 7. General Tips

- Every time a list or array gets iterated over `c×length` times, it is most likely in `O(n)` time.
- When you see a problem where the number of elements in the problem space gets halved each time, it will most probably be in `O(log n)` runtime.
- Whenever you have a single nested loop, the problem is most likely in quadratic time. `O(n2)`.
- A loop statement that multiplies/divides the loop variable by a constant takes log_k(n) time because the loop runs that many times.
- We don’t always add the time complexity of the inner loop. It depends. If the inner loop depends on the outer loop, then the complexity is added, and if the inner loop does not depend on the outer loop, then we multiply it.
- `log(a)` + `log(b)` = `log(ab)`
- An algorithm is said to be constant time (also written as `O(1)}` time) if the value of `T(n)` is bounded by a value that does not depend on the size of the input. For example, accessing any single element in an array takes constant time as only one operation has to be performed to locate it. In a similar manner, finding the minimal value in an array sorted in ascending order; it is the first element. However, finding the minimal value in an unordered array is not a constant time operation as scanning over each element in the array is needed in order to determine the minimal value. Hence it is a linear time operation, taking {\textstyle O(n)}{\textstyle O(n)} time. If the number of elements is known in advance and does not change, however, such an algorithm can still be said to run in constant time.
- An algorithm is said to take logarithmic time when `T(n) =O(log n)`. Since `log_a(n)` `log_b(n)` are related by a constant multiplier, and such a multiplier is irrelevant to `big O` classification, the standard usage for logarithmic-time algorithms is `O(log n)` regardless of the base of the logarithm appearing in the expression of T.
Algorithms taking logarithmic time are commonly found in operations on binary trees or when using binary search.

<br>
<br>
<br>
<br>

