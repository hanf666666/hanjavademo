import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{Connection, ConnectionFactory, Get, Put, Result, Scan, Table}
import org.apache.hadoop.hbase.protobuf.ProtobufUtil
import org.apache.hadoop.hbase.util.{Base64, Bytes}

/**
 * to do
 *
 * @author Hj
 * @date 2020/11/25
 */
object Test {
  def main(args: Array[String]): Unit = {
    val connection: Connection = getHBaseConnection()

    val table: Table = connection.getTable(TableName.valueOf("MEISOODEV:EQUIPMENT_FEE_RULE"))
////    插入数据
////    val put = new Put(Bytes.toBytes("aiqicha"));
////    put.addColumn(Bytes.toBytes("aiqicha"),Bytes.toBytes("han"),Bytes.toBytes("123"))
////    table.put(put)
//
//    //开始rowkey和结束一样代表精确查询某条数据
//    //组装scan语句
//    val scan = new Scan(Bytes.toBytes("aiqicha"), Bytes.toBytes("aiqicha"))
//    scan.setCacheBlocks(false)
//    scan.addFamily(Bytes.toBytes("aiqicha"))

    val get: Get = new Get(Bytes.toBytes("3"))
    val result: Result = table.get(get)
    for (rowKv <- result.rawCells()) {
      println("Famiily:" + new String(rowKv.getFamilyArray, rowKv.getFamilyOffset, rowKv.getFamilyLength, "UTF-8"))
      println("Qualifier:" + new String(rowKv.getQualifierArray, rowKv.getQualifierOffset, rowKv.getQualifierLength, "UTF-8"))
      println("TimeStamp:" + rowKv.getTimestamp)
      println("rowkey:" + new String(rowKv.getRowArray, rowKv.getRowOffset, rowKv.getRowLength, "UTF-8"))
      println("Value:" + new String(rowKv.getValueArray, rowKv.getValueOffset, rowKv.getValueLength, "UTF-8"))
    }


  }


  /**
   * 将Scan转换为String作为设置参数输入
   *
   * @param scan
   * @return
   */
  def convertScanToString(scan: Scan) = {
    val proto = ProtobufUtil.toScan(scan)
    Base64.encodeBytes(proto.toByteArray)
  }
  def getHBaseConnection(): Connection = {
    // 创建HBASE的链接对象
    val hbaseConf = HBaseConfiguration.create()
//    System.getProperties.setProperty("HADOOP_USER_NAME","hdfs")
    hbaseConf.set("hbase.zookeeper.quorum", "bigdata-alpha-003:2181,bigdata-alpha-004:2181,bigdata-alpha-005:2181")
    hbaseConf.set("hbase.zookeeper.property.clientPort", "2181")
    val connection = ConnectionFactory.createConnection(hbaseConf)
    connection
  }

}
