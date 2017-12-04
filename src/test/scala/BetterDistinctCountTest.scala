package com.tinyclues.count;

import org.scalatest._

class BetterDistinctCountTest extends FlatSpec with Matchers {

  val d = new BetterDistinctCount();

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

  it should "Test with 5 000 000 uniques and 5 000 000 pairs should be 10 000 000" in {
    val seq = (1L to 10000000L) ++ (1L to 5000000L)
    seq.size should equal(15000000)
    d.countDistinct(seq.toArray) should equal(10000000);
  }
}