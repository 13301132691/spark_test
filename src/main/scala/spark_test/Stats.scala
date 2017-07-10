package spark_test

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.random.RandomRDDs
import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by jax on 17-7-6.
  */
object Stats extends App{
  val conf = new SparkConf().setMaster("local").setAppName("Stats")
  val sc = new SparkContext(conf)
  val iris = sc.textFile("data/iris.csv").map(_.split(",").dropRight(1).map(_.toDouble)).map(Vectors.dense(_))
  val summary = Statistics.colStats(iris)
  println(summary.count)
  println(summary.max)
  println(summary.mean)
  println(summary.min)
  println(summary.normL1)
  println(summary.normL2)
  println(summary.variance)
  val cor1 = Statistics.corr(iris)
  val iris2 = sc.textFile("data/iris.csv").flatMap(_.split(",").dropRight(1).map(_.toDouble))
  val cor2:Double = Statistics.corr(iris2,iris2)
  val chi = Statistics.chiSqTest(Vectors.dense(iris2.collect()),Vectors.dense(iris2.collect()))
  val ran = RandomRDDs.normalRDD(sc,100)
  ran.foreach(print)
}
