package $organization$
package client

import api._

import com.twitter.finagle._
import builder.ClientBuilder
import thrift.ThriftClientFramedCodec

object Main extends App {

  val service = ClientBuilder()
  	.hosts(Config.host+":"+Config.port)
  	.codec(ThriftClientFramedCodec())
  	.hostConnectionLimit(1)
  	.build()

  val client = new HelloUser.FinagledClient( service )

  // This is sequencial !
  // If you want this to run in parallel you need something like
  // Future.sequence with an execution context(eg. thread pool)
  for {
  	alice <- client.hello(User("Alice","Robert"))
  	bob <- client.hello(User("Bob","Robert"))
  } yield {
  	println(alice + " " + bob)
  	service.close()
  }
}