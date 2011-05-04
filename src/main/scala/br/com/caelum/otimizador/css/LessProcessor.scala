package br.com.caelum.otimizador.css

import com.asual.lesscss.LessEngine

class LessProcessor {
	def process(source: String): String = {
		val less = new LessEngine()
		less.compile(source).replaceAll("\\\\n", "\n")
	}
}