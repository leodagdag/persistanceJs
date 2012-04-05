import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName = "persistanceJs"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.mongodb.casbah" %% "casbah-gridfs" % "2.1.5-1",
    "com.novus" %% "salat-core" % "0.0.8-SNAPSHOT"
  )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA)
    .settings(
    lessEntryPoints <<= baseDirectory(customLessEntryPoints)
  )

  // Only compile the bootstrap bootstrap.less file and any other *.less file in the stylesheets directory
  def customLessEntryPoints(base: File): PathFinder = (
    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
      (base / "app" / "assets" / "stylesheets" / "bootstrap" * "responsive.less"))

}
