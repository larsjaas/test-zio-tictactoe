name := "tictactoe"

lazy val sver = "2.13.8"
enablePlugins(BuildInfoPlugin)

lazy val zioVersion = "1.0.0-RC16"

scalaVersion := sver

lazy val commonSettings = Seq(
  ThisBuild / scalaVersion := sver,
  name := "tictactoe"
)

lazy val buildInfoSettings = Seq(
  buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
  buildInfoPackage := "com.github.larsjaas"
)

lazy val buildSettings = Seq(
    libraryDependencies ++= Seq(
        "dev.zio" %% "zio" % zioVersion,
        "dev.zio" %% "zio-test" % zioVersion % "test",
        "dev.zio" %% "zio-test-sbt" % zioVersion % "test"
    )
)

lazy val ziotest = project.in(file("."))
  .settings(commonSettings)
  .settings(buildInfoSettings)
  .settings(buildSettings)

testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
