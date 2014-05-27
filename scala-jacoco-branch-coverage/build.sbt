organization := "cpf"

name := "branch-coverage"

version := "1.0"

resolvers += "alfresco release" at "https://maven.alfresco.com/nexus/content/groups/public/"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test"
)

jacoco.settings

testOptions in Test += Tests.Argument("junitxml", "console")