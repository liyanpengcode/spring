package com.spring.flink.base

object Comment {

  /**
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {
    print("hello word!\n")
    val i = sum(1, 2)
    print(i + "\n")
  }

  /**
   * @deprecated
   * @example
   * @param n1
   * @param n2
   * @return 和
   */
  def sum(n1: Int, n2: Int): Int = {
    n1 + n2
  }
}
