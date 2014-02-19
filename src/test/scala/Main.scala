import io.github.scala.sdoc2pdf.OdtTemplate
import scalax.io.Resource
import scala.util.Failure

/**
 * Example of use.
 */
object Main extends App{

  // create a new report using a template document
  val template = OdtTemplate("/template1.odt")

  // add data to the report
  template + ("user_name","Felix Garcia Borrego")
  template + ("project_name","sDoc2Pdf")

  // generate the new pdf
  var out=template.render

  val pdf = Resource.fromFile("temp.pdf")
  pdf.write(out)

}
