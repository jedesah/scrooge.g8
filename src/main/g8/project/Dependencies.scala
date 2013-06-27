import sbt._
import sbt.Keys._

object Dependencies {
  private lazy val finagleVer = "6.5.0"
  lazy val thrift = "org.apache.thrift" % "libthrift" % "0.8.0"
  lazy val finagleCore = "com.twitter" %% "finagle-core" % finagleVer
  lazy val finagleThrift = "com.twitter"  %% "finagle-thrift" % finagleVer
  lazy val finableOstrich = "com.twitter" %% "finagle-ostrich4" % finagleVer
  lazy val scroogeRuntime = "com.twitter" %% "scrooge-runtime" % "3.1.10"

  lazy val scroogeStack = Seq(  
    thrift, 
    finagleCore, 
    finagleThrift,
    scroogeRuntime
  )
}