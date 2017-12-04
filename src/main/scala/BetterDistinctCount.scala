package com.tinyclues.count;
import scala.collection.mutable.HashSet;
import util.Sorting.quickSort;

class BetterDistinctCount extends Counter {

  override def countDistinct(arr: Array[Long]) : Long = {
    customCountDistinct(arr)
  }

  def customCountDistinct(arr: Array[Long]) : Long = {
    sort(arr)
    def go(num : Long, current: Int = 0, acc : Long = 0) : Long = {
      if(current >= arr.length ) acc + 1
      else if(arr(current) == num) go(num, current + 1, acc)
      else go(arr(current), current + 1, acc + 1)
    }

    go(arr(0))
  }

  /**
    * Heap sort
    * Has O(nlogn) complexity
    * @param a
    */
  def sort(a: Array[Long]): Unit = {
    var m = a.length - 1
    buildHeap(a, m)
    while (m >= 1) {
      swap(a, 0, m)
      m-=1
      heapify(a, 0, m)
    }
  }

  def buildHeap(a: Array[Long], m: Int): Unit = {
    for (i <- m/2 to 0 by -1) {
      heapify(a, i, m)
    }
  }

  /**Pushes an illegally located element down the heap to restore heap property.*/
  @annotation.tailrec
  private def heapify(a: Array[Long], loc: Int, lastLeaf: Int): Unit = {
    val l = left(loc)
    val r = right(loc)

    var max = loc

    if(l <= lastLeaf && a(l) > a(max)) max = l
    if(r <= lastLeaf && a(r) > a(max)) max = r

    if(max != loc) {
      swap(a, max, loc)
      heapify(a, max, lastLeaf)
    }
  }

  /**Returns position of left child (possibly empty). */
  def left(loc: Int): Int = {
    return 2*loc
  }

  /**Returns position of right child (possibly empty). */
  def right(loc: Int): Int = {
    return 2*loc+1
  }

  def swap(a: Array[Long], i: Int, j:Int): Unit = {
    val staging = a(i)
    a(i) = a(j)
    a(j) = staging
  }
}