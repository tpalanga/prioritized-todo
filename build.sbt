name := """prioritized-todo"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-java" % "2.44.0" % "test",
  "org.mockito" % "mockito-core" % "1.10.8" % "test",
  jdbc,
  anorm,
  cache,
  ws
)

Seq(jasmineSettings : _*)

appJsDir <+= baseDirectory { src => src / "app" / "assets" / "javascripts"}

appJsLibDir <+= baseDirectory { src => src / "public" / "javascripts" / "libs" }

jasmineTestDir <+= baseDirectory { src => src / "test" / "js" }

jasmineConfFile <+= baseDirectory { src => src / "test" / "js" / "test.dependencies.js" }

jasmineEdition := 1

(test in Test) <<= (test in Test) dependsOn (jasmine)


ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 100

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true

ScoverageSbtPlugin.ScoverageKeys.coverageExcludedFiles := ".*((R|r)everse|routing|template).*"
