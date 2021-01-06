package com.spring.flink.base

import scala.io.StdIn

/**
 * 控制台输入
 */
object InputConsole {

  def main(args: Array[String]): Unit = {
    /**
     * 键盘输入
     * 要求控制台接收用户信息
     * 姓名，年龄，薪水
     *
     */

    println("输入姓名")
    val name = StdIn.readLine()

    println(name)
  }
}
