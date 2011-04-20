package br.com.caelum.otimizador.javascript

import com.yahoo.platform.yui.compressor._
import org.mozilla.javascript.ErrorReporter
import org.mozilla.javascript.EvaluatorException
import java.io._
import java.net.{URLClassLoader,URL}

/**
 * A super complicated way to call YUI Compressor safely. 
 * Thanks to Sun's embedded Rhino implementation.
 *  
 * @author Sérgio Lopes
 */
class YUIJavaScriptCompressor extends JSCompressor {
	def compress(source: String):String = {
		
		val in = new StringReader(source)
		val out = new StringWriter
		
		try {
			val loader = createLoader
			val clazz = loader.loadClass("com.yahoo.platform.yui.compressor.JavaScriptCompressor")
			val constructor = clazz.getDeclaredConstructors.last
			val method = clazz.getMethod("compress", classOf[Writer], Integer.TYPE, 
					java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE, java.lang.Boolean.TYPE)
					
			val compressor = constructor.newInstance(in, createErrorReporter(loader))
			method.invoke(compressor, out, 
					new Integer(-1), java.lang.Boolean.FALSE, java.lang.Boolean.FALSE, java.lang.Boolean.FALSE, java.lang.Boolean.FALSE)
		
			out.toString

		} finally {
        	in.close
        	out.close
        }
	}
	
	private def createLoader() = {
		val yuiclassname = "/" + classOf[YUICompressor].getName.replace('.', '/') + ".class"
		val yuijar = classOf[YUICompressor].getResource(yuiclassname).getFile.replaceAll("!"+yuiclassname, "")
		
		val appclassname = "/" + classOf[RhinoErrorReporter].getName.replace('.', '/') + ".class"
		val apppath = "file:" + classOf[RhinoErrorReporter].getResource(appclassname).getFile.replaceAll(appclassname, "") + "/"
		
		new URLClassLoader(Array(new URL(apppath), new URL(yuijar)), null)
	}
	
	private def createErrorReporter(loader:ClassLoader):Object = {
		loader
			.loadClass(classOf[RhinoErrorReporter].getName)
			.newInstance.asInstanceOf[AnyRef]
	}
}
// to be called in the same classloader as YUI
class RhinoErrorReporter extends ErrorReporter {
    def warning(message:String, sourceName:String,
            line:Int, lineSource:String, lineOffset:Int) {
        if (line < 0) {
            System.err.println("\n[WARNING] " + message);
        } else {
            System.err.println("\n[WARNING] " + line + ':' + lineOffset + ':' + message);
        }
    }

    def error(message:String, sourceName:String,
            line:Int, lineSource:String, lineOffset:Int) {
        if (line < 0) {
            System.err.println("\n[ERROR] " + message);
        } else {
            System.err.println("\n[ERROR] " + line + ':' + lineOffset + ':' + message);
        }
    }

    def runtimeError(message:String, sourceName:String,
            line:Int, lineSource:String, lineOffset:Int):EvaluatorException = {
        error(message, sourceName, line, lineSource, lineOffset);
        new EvaluatorException(message);
    }
}