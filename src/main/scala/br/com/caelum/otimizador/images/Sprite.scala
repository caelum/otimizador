package br.com.caelum.otimizador.images

import java.awt.image.BufferedImage
import java.io.File

class Sprite(val folder: File, val css: String, val image: BufferedImage) {
	
	/**
	 * Sprite simple name
	 */
	val name = folder.getName
}