package br.com.caelum.otimizador.combo

import java.io.{File,FileInputStream}
import java.util.Scanner
import io.Source

class FileMerger {
	def merge(files: File*):String = {
		val out = new StringBuilder
		
		files.foreach { file =>
			out.append("/* "+ file.getName +" */\n")
			out.append(Source.fromFile(file, "UTF-8").mkString)
			out.append("\n\n")
		}
		
		out.toString
	}	
}