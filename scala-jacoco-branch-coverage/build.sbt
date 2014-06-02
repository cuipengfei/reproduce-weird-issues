import de.johoop.jacoco4sbt.JacocoPlugin.jacoco
import de.johoop.jacoco4sbt.{ScalaHTMLReport, Thresholds}

organization := "cpf"

name := "branch-coverage"

version := "1.0"

resolvers += "alfresco release" at "https://maven.alfresco.com/nexus/content/groups/public/"

resolvers ++= Seq(Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases"))

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "org.specs2" % "specs2_2.10" % "2.3.12-scalaz-7.1.0-M6"
)

jacoco.settings

jacoco.thresholds in jacoco.Config := Thresholds(instruction = 80, branch = 80, line = 80, clazz = 80, method = 80, complexity = 80)

jacoco.reportFormats in jacoco.Config := Seq(
  ScalaHTMLReport(withBranchCoverage = true))