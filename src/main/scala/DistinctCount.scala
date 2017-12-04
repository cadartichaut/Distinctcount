package com.tinyclues.count;
import scala.collection.mutable.HashSet

class DistinctCount extends Counter {

  override def countDistinct(arr: Array[Long]) : Long = {
    customCountDistinct(arr)
  }

  /**
    * Using toSet
    *
    * @param arr an array of ids
    * @return the number of unique occurences of a long in the array
    */
  def countWithToSet(arr: Array[Long]): Long = {
    arr.toSet.size
  }

  /**
    * Using distinct
    * Distinct uses a hashset.
    * https://github.com/scala/scala/blob/v2.10.3/src/library/scala/collection/SeqLike.scala#L490
    * @param arr an array of ids
    * @return the number of unique occurences of a long in the array
    */
  def countWithDistinct(arr: Array[Long]): Long = {
    arr.distinct.size
  }

  /**
    * Using a hashset
    * O(n) complexity but takes O(m) space
    * Good depending on how much memory we have.
    * @param arr
    * @return
    */
  def customCountDistinct(arr: Array[Long]) : Long = {
    var acc = 0
    val seen = HashSet[Long]()
    for (x <- arr) {
      if (!seen(x)) {
        acc += 1
        seen += x
      }
    }

    acc
  }
}