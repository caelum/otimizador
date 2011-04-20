package br.com.caelum.otimizador.css

import com.yahoo.platform.yui.compressor._
import org.mozilla.javascript.ErrorReporter
import org.mozilla.javascript.EvaluatorException
import java.io._

class YUICssCompressor extends CSSCompressor {
	def compress(source: String):String = {
		
		val in = new StringReader(source)
		val out = new StringWriter

		try {
            val compressor = new CssCompressor(in)
            compressor.compress(out, -1)
        } finally {
        	in.close
        	out.close
        }
		
		out.toString
	}
}