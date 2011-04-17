package br.com.caelum.otimizador.images

import java.io.File
object SpriteFactory {
	def create(file: File): Sprite = {
		
		var css   = "TODO"
		var image = null; 
			
		new Sprite(file, css, image)
	}
}