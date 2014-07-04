resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("cuipengfei" % "jacoco4sbt-qd" % "2.1.5")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")