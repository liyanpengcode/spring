package com.spring.flink.base

/**
 * 取模算式
 * %
 *
 */
object Arithoper {
  def main(args: Array[String]): Unit = {
    /**
     * 运算原则：
     * 商取小原则
     * 求整数商：c = a/b;
     * 计算模/余数：r = a - (c*b);
     *
     * @example 5 mod 3 = 2	5/3 = 1.66 商取小原则 商=1	5 - 3 * 1 = 2	2
     *          a%b=a-a/b*b
     */

    println(10 % -3) //1
  }
}
