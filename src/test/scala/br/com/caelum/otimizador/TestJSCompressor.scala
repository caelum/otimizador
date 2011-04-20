package br.com.caelum.otimizador

import br.com.caelum.otimizador.javascript._

object TestJSCompressor {
	def main(args : Array[String]) : Unit = {
		val jssource = "document.getElementById('test').innerHTML = document.getElementById('test').innerHTML;"
		
		val compressor = new YUIJavaScriptCompressor
		val output = compressor.compress(jssource)
		
		println(output)
	}
}