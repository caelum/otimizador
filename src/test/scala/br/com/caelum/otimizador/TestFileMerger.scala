package br.com.caelum.otimizador

import java.io.File
import br.com.caelum.otimizador.combo.FileMerger

object TestFileMerger {
	def main(args : Array[String]) : Unit = {

		val css1 = new File("src/test/resources/css/simplepackage.css/first.css")
		val css2 = new File("src/test/resources/css/simplepackage.css/second.css")
		val css3 = new File("src/test/resources/css/simplepackage.css/third.css")
		
		val merger = new FileMerger
		val output = merger.merge(css1, css2, css3)
		
		println(output)
	}
}