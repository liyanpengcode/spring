package com.spring.flink.exercise.ifelse

/**
 * 定义两个变量 二者和相加，既能被3整除又能被5整除
 */
object Exercise {

  def main(args: Array[String]): Unit = {
    var num1 = 10

    var num2 = 5

    val sum = num1 + num2
    if (sum % 3 == 0 && sum % 5 == 0) {
      println(true)
    } else {
      println(false)
    }
  }

}
