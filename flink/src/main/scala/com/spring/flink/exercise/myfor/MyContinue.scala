package com.spring.flink.exercise.myfor

object MyContinue {

  def main(args: Array[String]): Unit = {

    println("scala 函数式风格解决continue ")


    println("scala 使用循环守卫 或者 if else ")

    /**
     * if i!=2 && i !=3  为 true执行输出
     */
    for (i <- 1 to 10 if i != 2 && i != 3) {
      println("scala 使用循环守卫 或者 if else  为 true执行输出" + i)
    }

  }
}
