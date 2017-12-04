package com.tinyclues.count;

import org.scalatest._

class DistinctCountTest extends FlatSpec with Matchers {

  val d = new DistinctCount();

  it should "Test with 6 unique should be 6" in {
    d.countDistinct(Array(1, 3, 2, 21, 18, 9)) should equal(6);
  }

  it should "Test with 5 unique and 3 pairs should be 8" in {

    d.countDistinct(Array(1, 2, 3, 9, 18, 21, 21, 22, 22, 23,23)) should equal(8);
  }

  it should "Test with 500 000 uniques should be 500 000" in {
    val seq = (1L to 500000L)
    seq.size should equal(500000)
    d.countDistinct(seq.toArray) should equal(500000);

  }

  it should "Test with 500 000 uniques and 500 000 pairs should be 1 000 000" in {
    val seq = (1L to 1000000L) ++ (1L to 500000L)
    seq.size should equal(1500000)
    d.countDistinct(seq.toArray) should equal(1000000);
  }
}