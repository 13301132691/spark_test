import org.apache.spark.{SparkConf, SparkContext}
val conf = new  SparkConf().setMaster("local").setAppName("AggregateTest")
val sc = new SparkContext(conf)
