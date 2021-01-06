package com.spring.flink.base

object DataType {

  def main(args: Array[String]): Unit = {

    /**
     * var 可变
     * val 不可变
     */
    var int = 0
    val num = 20
    //    num=30


    /**
     * 值类型转换
     */
    var double = 2.01
    var float = 2.1f
    float = double.toFloat


    /**
     * 参数列表中没有形参
     * sayhello
     *
     * OR
     *
     * sayhello()
     */
    sayhello
    //    sayhello()
  }

  /**
   * Nothing
   * 比如开发过程中，我们有一个方法，就会异常中断，这时就可以返回Nothing
   * 当我们使用Nothing做返回值，就是明确该方法没有正常返回值。
   *
   */

  def sayhello(): Nothing = {

    throw new Exception("=抛出异常=")


  }

}
