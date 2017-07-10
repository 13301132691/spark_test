package spark_test

/**
  * Created by jax on 17-7-4.
  */
import org.apache.spark.ml.linalg.{Matrices, Vector, Vectors}
import org.apache.spark.{SparkConf, SparkContext}

object Aggregate extends App{
  val conf = new  SparkConf().setMaster("local").setAppName("AggregateTest")
  val sc = new SparkContext(conf)

  val arr = sc.parallelize(Array(1,2,3,4,5,6))
  val result = arr.aggregate(0)(math.max(_,_),_+_)
  print(result2)

  val arr2 = sc.parallelize(Array(1,2,3,4,5,6),2)
  val result2 = arr2.aggregate(0)(math.max(_,_),_+_)
  print(result2)

  val arr3 = sc.parallelize(Array("a","b","c","d"))
  val result3 = arr3.aggregate("\\")(_+_,_+_)
  print(result3)

  val result4 = arr.cartesian(arr2)
  print(result4)

  val result5 = arr.countByValue()
  result5.foreach(println)

  val arr4 = sc.parallelize(Array(("1","a"),("2","b")))
  val result6 = arr4.countByKey()
  print(result6)

  val arr5 = sc.parallelize(Array(1,2,3,4,5,6,1,2,3,4,5,6))
  val result7 = arr5.distinct
  print(result7)

  val result8 = arr5.filter(_>=3).collect()
  print(result8)

  val result9 = arr5.flatMap(x=>List(x+1)).collect()
  print(result9)

  val result10 = arr5.map(x=>List(x+1)).collect()
  print(result10)

  def filter1(num:Int)={num>=3}
  def filter2(num:Int)={num<3}
  arr5.groupBy(filter1(_),1)
  arr5.groupBy(filter2(_),2)

  val result11 = arr3.keyBy(w=>w.size)

  val resutl12 = arr5.reduce(_+_)

  val vd: Vector = Vectors.dense(3,4,5,7)
  val vs: Vector = Vectors.sparse(10,Array(0,4,7),Array(2,5,9))
  print(vs(2).getClass)

  val  mx = Matrices.dense(2,3,Array(1,2,3,4,5,6))
}
