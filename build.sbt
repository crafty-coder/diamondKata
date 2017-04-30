
name := "diamondsKata"
version := "1.0"
scalaVersion := "2.12.1"
scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8", "-target:jvm-1.8", "-Xfatal-warnings", "-Xfuture")


libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % Test

unmanagedSourceDirectories in Compile := Seq(baseDirectory.value / "src/main/scala")

unmanagedSourceDirectories in Test := Seq(baseDirectory.value / "src/test/unit")

