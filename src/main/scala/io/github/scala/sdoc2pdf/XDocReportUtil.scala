package io.github.scala.sdoc2pdf

import fr.opensagres.xdocreport.document.registry.XDocReportRegistry
import fr.opensagres.xdocreport.document.IXDocReport
import fr.opensagres.xdocreport.template.{IContext, TemplateEngineKind}

import com.typesafe.scalalogging.slf4j.Logging
import java.io.{ByteArrayOutputStream, FileOutputStream, OutputStream}
import fr.opensagres.xdocreport.converter.{ConverterTypeVia, ConverterTypeTo, Options}
import resource.Resource

trait Template {
  def render : Array[Byte]
  def + (name:String, value:Any) : Template
}

class EmptyTemplate extends Template{
  def render  : Array[Byte]= { Array.empty }
  def + (name:String, value:Any) : Template = {this}
}

case class OdtTemplate(path:String) extends Template with Logging {
  val url = getClass.getResource(path)
  logger.debug(s"Odt report for: ${url.getPath}")
  val input =  getClass.getResourceAsStream(path)
  // 1) Load ODT file by filling Velocity template engine and cache it to the registry
  val report = XDocReportRegistry.getRegistry.loadReport(input,TemplateEngineKind.Velocity)
  val context = report.createContext()

  def + (name:String, value:Any): Template= {
    context.put(name, value)
    this
  }

  def render : Array[Byte]= {
    val out = new ByteArrayOutputStream()

    report.process(context, out)

    val options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM)
    report.convert(context, options, out)

    out.toByteArray
  }
}

