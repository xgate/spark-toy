package hello

import org.apache.spark.{SparkConf, SparkContext}

object SimpleApp {

  def main(args: Array[String]): Unit = {
    val home = "YOUR_SPARK_HOME"
    val logFile = s"$home/README.md"
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()

    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}
