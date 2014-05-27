resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("de.johoop" % "jacoco4sbt" % "2.1.5")