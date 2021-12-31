name := "tictactoe"

enablePlugins(BuildInfoPlugin)

lazy val commonSettings = Seq(
  ThisBuild / scalaVersion := "3.1.0",
  name := "tictactoe"
)

lazy val buildInfoSettings = Seq(
  buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
  buildInfoPackage := "com.github.larsjaas"
)

lazy val buildSettings = Seq(
    libraryDependencies ++= Seq(
        "dev.zio" %% "zio" % "2.0.0-RC1"
    )
)

lazy val ziotest = project.in(file("."))
  .settings(commonSettings)
  .settings(buildInfoSettings)
  .settings(buildSettings)
