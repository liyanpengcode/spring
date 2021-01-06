package com.spring.flink

import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}
import org.apache.flink.api.scala._

object WordCount {


  def main(args: Array[String]): Unit = {


    //创建一个批处理 的执行环境
    val env = ExecutionEnvironment.getExecutionEnvironment

    //从文件读取数据

    val inputPath: String = "/Users/liyanpeng/dev-projects/spring/flink/src/main/resources/wordcount.txt";
    val inputDataSet: DataSet[String] = env.readTextFile(inputPath);

    //对数据进行转换处理统计，先分词，再按照word进行分组，最后进行聚合统计

    val resultDataSet: DataSet[(String, Int)] = inputDataSet.flatMap(_.split(" ")).map((_, 1)).groupBy(0).sum(1)


    resultDataSet.print()
  }
}
