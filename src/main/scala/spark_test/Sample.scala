package spark_test

import org.apache.spark.{SparkConf, SparkContext}
/**
  * Created by jax on 17-7-6.
  */
class Sampling {
  val conf = new SparkConf().setMaster("local").setAppName("testSingleCorrect2 ")                                              //设置本地化处理
  val sc = new SparkContext(conf)                                  //创建环境变量实例
  val data = sc.textFile("data/iris.csv").map(row => {                                                //开始处理
    if(row(0) >=5)                                            //判断字符数
      (1,row)                                                    //建立对应map
    else (2,row)                                                  //建立对应map
  })
  val fractions: Map[Int, Double] = List((1, 0.2), (2, 0.8)).toMap                //设定抽样格式
  val approxSample = data.sampleByKey(withReplacement = false,fractions,0) //计算抽样样本
  approxSample.foreach(println)
  val approxSample2 = data.sample(withReplacement = false,0.8,0) //计算抽样样本
  approxSample2.foreach(println)
}
