import sbt._
import sbt.Keys._

object ProjectBuild extends Build {
  import Dependencies._

  lazy val api = Project(
    id = "api",
    base = file("api"),
    settings = Settings.default ++ Settings.scrooge ++ Seq(
      name := "api"
    )
  )

  lazy val client = Project(
    id = "client",
    base = file("client"),
    settings = Settings.default ++ Seq(
      name := "client"
    )
  ) dependsOn( api )

  lazy val server = Project(
    id = "server",
    base = file("server"),
    settings = Settings.default ++ Seq(
      name := "server",
      libraryDependencies += finableOstrich
    )
  ) dependsOn( api )
}
