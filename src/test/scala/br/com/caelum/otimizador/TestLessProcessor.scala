package br.com.caelum.otimizador

import br.com.caelum.otimizador.css._

object TestLessProcessor {
	def main(args : Array[String]) : Unit = {
		val cssource = "#test { a { margin-top: 10px * 2; } }"
		
		val less = new LessProcessor	
		val output = less.process(cssource)
		
		println(output)
	}
}