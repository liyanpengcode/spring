package com.spring.flink

import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

/**
 * console :  nc -lk 8080
 */
object SteamWordCount {

  def main(args: Array[String]): Unit = {
    //创建一个批处理 的执行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(8)

    //接收参数：
    val paramTool: ParameterTool = ParameterTool.fromArgs(args)

    val host: String = paramTool.get("host")

    val port: Int = paramTool.getInt("port")

    //socket 接收文本流
    var inputDataStream = env.socketTextStream(host, port)

    //进行转化处理统计
    var resultStreamData = inputDataStream.flatMap(_.split(" ")).filter(_.nonEmpty).map((_, 1)).keyBy(0).sum(1)

    resultStreamData.print()

    env.execute(" count word job")
  }
}
