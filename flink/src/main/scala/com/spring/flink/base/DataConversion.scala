package com.spring.flink.base

/**
 * 数据转换
 */
object DataConversion {
  def main(args: Array[String]): Unit = {

    /**
     * 自动转换
     */
    var autoConversion = 5.5 + 22
    print(autoConversion + "\n")

    /**
     * byte,short 和char 之间不会自动转换
     * 三者可以进行计算，在计算时限转换为int类型
     * 提升原则：
     * 表达式结果的类型自动提升为操作数中最大的类型
     *
     */
  }
}
