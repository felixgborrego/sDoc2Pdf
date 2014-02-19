name := "sDoc2Pdf"

description := "Create PDFs using odt or docx documents as a template."

startYear := Some(2014)

organization := "io.github.sDoc2Pdf"

version := "0.0.1"

/* scala versions and options */
scalaVersion := "2.10.3"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.9.3", "2.10.0", "2.10.1", "2.10.2", "2.10.3")

org.scalastyle.sbt.ScalastylePlugin.Settings

libraryDependencies += "com.typesafe" %% "scalalogging-slf4j" % "1.0.1"

libraryDependencies ++= Seq(
  "fr.opensagres.xdocreport" % "fr.opensagres.xdocreport.document.odt" % "1.0.3",
  "fr.opensagres.xdocreport" % "fr.opensagres.xdocreport.template.velocity" % "1.0.3",
  "fr.opensagres.xdocreport" % "fr.opensagres.xdocreport.converter.odt.odfdom" % "1.0.3",
  "fr.opensagres.xdocreport" % "org.odftoolkit.odfdom.converter.pdf" % "1.0.3",
  "fr.opensagres.xdocreport" % "fr.opensagres.xdocreport.itext.extension" % "1.0.3",
  "org.slf4j" % "slf4j-log4j12" % "1.7.0"
)


libraryDependencies += "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2"

libraryDependencies += "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.2"



