package com.spring.flink.base

/**
 * 表示符
 */
object Identifier {
  def main(args: Array[String]): Unit = {
    val ++ = "hello wod"
    //看下编译器是如何处理的
    // ++ =$plus$plus
    print(++)


    val -+*/ = 90 //OK
    print("res=" + -+*/)

    /**
     * errot
     */
    //    val +q = "abc"


    /**
     * 关键字也可以作为变量名
     * 需要用反引号
     */
    var `true` = "hello string"


  }
}
