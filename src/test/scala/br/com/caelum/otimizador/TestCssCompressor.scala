package br.com.caelum.otimizador

import br.com.caelum.otimizador.css._

object TestCssCompressor {
	def main(args : Array[String]) : Unit = {
		val cssource = "#test {margin-top: 0px; margin-bottom: 0px; margin-left:0; margin-right:10px;}"
		
		val compressor = new YUICssCompressor
		val output = compressor.compress(cssource)
		
		println(output)
	}
}