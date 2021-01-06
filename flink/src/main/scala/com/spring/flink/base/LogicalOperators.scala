package com.spring.flink.base

/**
 * 逻辑运算符
 * &&
 * ||
 * !
 * 结果最终都是Boolean 值
 */
object LogicalOperators {
  def main(args: Array[String]): Unit = {
    val a = true
    val b = false

    println("a && b = " + (a && b))

    println("a || b = " + (a || b))

    println("!(a && b) = " + !(a && b))
  }
}
