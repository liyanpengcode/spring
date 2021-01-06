package com.spring.flink.exercise.mutifor

object MutiFor {
  def main(args: Array[String]): Unit = {

    /**
     * 打印99乘法表
     *
     */
    /**
     * 思路分析： 双重♻️循环
     * 每一列的行数在增加
     */

    var numLine = 9 //定义一个变量 numLine
    for (i <- 1 to numLine) { //确定行数
      for (j <- 1 to i) { //确定列数
        printf("%d * %d = %d  \t ", j, i, (i * j))
      }
      println()
    }


  }
}
