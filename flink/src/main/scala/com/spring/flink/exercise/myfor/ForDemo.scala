package com.spring.flink.exercise.myfor

/**
 *
 */
object ForDemo {
  def main(args: Array[String]): Unit = {
    var start = 1
    var end = 5

    println("================ to ====================")

    /**
     * start to end : 1-5
     *
     */
    for (i <- start to end) {
      println("to：" + i)
    }


    println("================ until ====================")

    /**
     * start to end : 1-4
     *
     */
    for (i <- start until end) {
      println("until：" + i)
    }

    println("============for 推倒式遍历========================")

    var list = List(1, 2, 3, 3)
    for (i <- list) {
      println("推倒式遍历：" + i)
    }

    println("============for 循环守卫========================")


    /**
     * result ：1 和 3
     */
    for (i <- 1 to 3 if i != 2) {
      println("循环守卫：" + i)
    }


    println("============for 引入变量========================")

    for (i <- 1 to 3; j = 4 - i) {
      println("for 引入变量: " + j)
    }

    println("============for 嵌套循环========================")

    for (i <- 1 to 3; j <- 1 to 3) {
      println("嵌套循环: " + i + " " + j)
    }


    println("============for yield使用 demo1========================")
    /**
     * 将每次循环得到的 i 放入vector 集合返回给 res；
     * i 这里是一个代码块，我们可以对i 进行逻辑处理
     */
    val res = for (i <- 1 to 10) yield i * 2
    println(res)

    println("============for yield使用 demo2========================")
    /**
     * 将每次循环得到的 i 放入vector 集合返回给 res；
     * i 这里是一个代码块，我们可以对i 进行逻辑处理
     */
    val result = for (i <- 1 to 10) yield {
      if (i % 2 == 0) {
        println("yield使用 偶数： " + i)
      } else {
        println("yield使用 奇数： " + i)
      }
    }


    println("============for 括号的改写（）与 { } demo1========================")

    for (i <- 1 to 3; j = i * 2) {
      println("括号的改写（）" + i + "   " + j)
    }

    println("============for 括号的改写（）与 { } demo2========================")

    for {i <- 1 to 3
         j = i * 2} {
      println("括号的改写{}" + i + "   " + j)
    }


    println("============for 循环控制 demo========================")

    /**
     * Range()使用
     * Make a range from `start` until `end` (exclusive) with given step value.
     *
     * @note step != 0
     */
    for (i <- Range(1, 10, 2)) {
      println("循环控制 Range()使用：" + i)
    }

    println("============for 循环控制 -》守卫模式 demo========================")

    /**
     * Range()使用
     * Make a range from `start` until `end` (exclusive) with given step value.
     *
     * @note step != 0
     */
    for (i <- 1 to 10 if i % 2 == 1) {
      println("循环控制 Range()-》守卫模式使用：" + i)
    }


  }
}
