package $organization$
package server

import api._

import com.twitter.util.Future

class HelloUserImpl extends HelloUser.FutureIface {
  def hello(user: User): Future[String] = {
  	val ret = "hello " + user
  	println(ret)
    Future.value(ret)
  }
}