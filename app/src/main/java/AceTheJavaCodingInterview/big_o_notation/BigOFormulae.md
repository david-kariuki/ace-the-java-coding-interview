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
|-|-|
| 1. | Any constant    | Constant |
| 2. | `logn`          | Logarithmic |
| 3. | `$${log^2n}$$`        | Log-square |
| 4. | `$$\sqrt{n}$$`  | Root-n |
| 5. | `n`             | Linear |
| 6. | `nlogn`         | Linearithmic |
| 1. | `n` |  |
| 1. |  |  |
| 1. |  |  |
| 1. |  |  |
| 1. |  |  |
| 1. |  |  |
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>