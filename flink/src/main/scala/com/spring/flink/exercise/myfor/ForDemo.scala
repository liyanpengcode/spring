package com.spring.flink.exercise.myfor

/**
 *
 */
object ForDemo {
  def main(args: Array[String]): Unit = {
    var start = 1
    var end = 5

    /**
     * start to end : 1-5
     *
     */
    for (i <- start to end) {
      println("count=" + i)
    }

    println("====================================")

    /**
     * start to end : 1-4
     *
     */
    for (i <- start until end) {
      println("count=" + i)
    }


  }
}
