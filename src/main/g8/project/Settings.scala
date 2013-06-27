import sbt._
import sbt.Keys._

object Settings {
	lazy val default = Project.defaultSettings ++ Seq(
		organization := "$organization$",
		version := "0.1.0-SNAPSHOT",
		scalaVersion := "$scala_version$"
	)

	// thrift
	import com.twitter.scrooge._
	import ScroogeSBT._
	lazy val scrooge = ScroogeSBT.newSettings ++ Seq(
    scroogeBuildOptions := Seq("--ostrich","--finagle"),
    libraryDependencies ++= Dependencies.scroogeStack
  )
}