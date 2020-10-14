package com.spring.flink.base

/**
 * 关系运算符
 * ==
 * <=
 * >=
 * !=
 * >
 * <
 *
 */
object RelationalOperator {
  def main(args: Array[String]): Unit = {
    var a = 10
    var b = 20

    /**
     * oK
     */
    var booleanValue: Boolean = a > b
    println("a==b =" + (a == b))
    println("a!=b =" + (a != b))
    println("a>b =" + (a > b))
    println("a<b =" + (a < b))
    println("a<=b =" + (a <= b))
    println("a>=b =" + (a >= b))
    println("booleanValue=" + (booleanValue))
  }

}
