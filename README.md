**HOW TO RUN**

Run tests with `sbt test`

**Find missing elements**

Consider as input an unordered sequence of N contiguous longs, that has lost some
elements (eg. `[8, 1, 6, 3]` ). This coding question is about finding the missing elements!
(in the example above: `[7, 2, 5, 4] `)

In this assignment, you have to code a function in Scala that takes as input an `Array[Long]`
(the unordered sequence of `N` contiguous longs that has missing elements) and outputs
another ` Array[Long]` (containing the missing elements).
Pay a close attention to spatial and time complexity of your algorithm (ie. complexity analysis
is expected). You're also advised to use unit tests to validate its behavior.

Answer this question by implementing the Finder trait below:
```scala
trait Finder {
     def findMissing(arr: Array[Long]): Array[Long]
   }
```

Answers can be found in this gist : 
https://gist.github.com/superyetix/f6161e178db68cc2a2691bccd3147cc7

**Find distinct count**

----------------------

_Part 1_

In this assignment, you're asked to code a function in Scala that takes as input an
`Array[Long]` (the user id collection, where any id may occurs multiple time) and outputs a
Long (the number of unique user contained in the input array).


`countDistinct` can be implemented using basic scala functions such as `distinct` and `toSet`. Both are fast for 
small to medium sized arrays with a time complexity of O(n) but a spatial of O(m). 
They are usable as long as we have enough memory.

An implementation `customCountDistinct` using a hashet and returning the value of distinct element has been implemented

----------------------

_Part 2_

Consider we use your function to compute unique count of users seen in 30 consecutive
days of a month. Now we want to get the unique number of user seen in the whole month. Is
it possible and efficient using your implementation? Can we do better? And if so, please
implement it :-)

A few solutions, depending on the size of the array : 
 - It is possible to reuse the same functions if we parallelize the work over a pool of servers (any size)
 - We can use a heap sort to sort in place for a huge array and just iterate over the result (see implementation in `BetterDistinctCount` 
 inspired by` http://bit.ly/2iPMq5M`). Usable as long as the heap fits into memory.
 - If the array is small we can do a quicksort.
 - We could request the database for just unique IDs, with a lastSeen field for example. Not an algorithm but easy to do.
