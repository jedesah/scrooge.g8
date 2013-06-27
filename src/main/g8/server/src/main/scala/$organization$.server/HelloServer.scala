package $organization$
package server

import api._

import com.twitter.finagle._
import thrift.ThriftServerFramedCodec
import builder.ServerBuilder
import builder.Server

import org.apache.thrift.protocol.TBinaryProtocol
import java.net.InetSocketAddress

object HelloServer {
	var server = Option.empty[Server]
  def start() {
    val protocol = new TBinaryProtocol.Factory()
    val serverService = new HelloUser.FinagledService(new HelloUserImpl, protocol)
    val address = new InetSocketAddress(Config.host, Config.port)

    val s = ServerBuilder()
      .codec(ThriftServerFramedCodec())
      .name("binary_service")
      .bindTo(address)
      .build(serverService)

    println("+++Server Started+++")
    server = Some(s)
  }

  def stop(){
    println("---Server Stoped---")
    server.map(_.close())
  }
}

object Main extends App {
  HelloServer.start()
}