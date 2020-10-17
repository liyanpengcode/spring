package com.spring.flink.exercise

import util.control.Breaks._

object MyWhile {
  def main(args: Array[String]): Unit = {


    /**
     * 输出10 句，您好！
     *
     */
    println("===============  while 输出10 句 " + " 您好！===============")
    var i = 0

    while (i < 10) {
      println("输出10 句 " + i + " 您好！")
      i += 1
    }

    println("=============== do while 输出10 句 " + " 您好！===============")

    /**
     * do while 至少输入一次
     */
    i = 0
    do {
      println("输出10 句 " + i + " 您好！")
      i += 1
    } while (i < 10)

    println("scala 函数式风格解决break ")

    /**
     * /**
     * * A block from which one can exit with a `break`. The `break` may be
     * * executed further down in the call stack provided that it is called on the
     * * exact same instance of `Breaks`.
     **/
     * def breakable(op: => Unit) {
     * try {
     * op
     * } catch {
     * case ex: BreakControl =>
     * if (ex ne breakException) throw ex
     * }
     * }
     */
    breakable {
      i = 0
      while (1 < 10) {
        i += 1
        if (i == 6) {
          break()
        }
      }
    }
    println("scala 函数式风格解决break  ok")
  }


}
