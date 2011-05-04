package br.com.caelum.otimizador.combo

import java.io.File

class ComboHandler {
	def mkCombo(location: File): String = {
		
		var files:Array[File] = null
		
		val merger = new FileMerger
		merger.merge(files:_*)
	}
}