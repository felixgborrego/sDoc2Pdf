# SDoc2Pdf Scala lib

SDoc2Pdf is a Scala library that makes it easy to create complex PDFs from Odt or Docx templates

On the backed it uses [xdocreport](https://code.google.com/p/xdocreport), Inspired by [sPDF](https://github.com/cloudify/sPDF)

WARNING: This lib is a work in progress and it´s not ready for production usage. Actually it´s just prototype so far.

## Usage

This library allow you to generate pdf documents or reports with your data from templates in a easy way!

```scala
// create a new report using a template document
val template = OdtTemplate("/template1.odt")

// add data to the report
template + ("user_name","Felix Garcia Borrego")
template + ("project_name","sDoc2Pdf")

// generate the new pdf
var out=template.render
```

![](https://raw2.github.com/felixgborrego/sDoc2Pdf/master/docs/diagram.png)



## Roadmap

This project is still in a early stage, many things that should be need to be improved:

- [ ] Use a a better scala idiom for the API
- [ ] Use non-blocking IO
- [ ] Add Test and production ready
- [ ] Streaming API (with `scalaz-stream`)
- [ ] Simplified API with implicits
- [ ] Integration with Play for streaming PDFs in HTTP responses
- [ ] Etc...
