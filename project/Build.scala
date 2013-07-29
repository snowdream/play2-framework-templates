import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

    val appName         = "play2-framework-templates"
    val appVersion      = "1.0"

    val appDependencies = Seq(
	javaCore,
        "securesocial" %% "securesocial" % "master-SNAPSHOT"
        
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(Play2WarPlugin.play2WarSettings: _*).settings(
	resolvers += Resolver.url("sbt-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns)
    ).settings(
    // ... Your own settings here
    Play2WarKeys.servletVersion := "2.5",
    Play2WarKeys.disableWarningWhenWebxmlFileFound :=true
    )

}
