package br.com.caelum.otimizador.images

import java.io.File
import java.awt.image.BufferedImage
import javax.imageio._
import java.util.LinkedList
import scala.collection.JavaConversions._

class ImageConcatenation {
	val DEFAULT_SPACE = 10 
	
	def concatenate(output:File, files:File*) = {
		var maxWidth = 0
		var height = 0;

		val images = new LinkedList[BufferedImage]()
		
		files.foreach { file =>
			val image = ImageIO.read(file)
			val imgWidth = image.getWidth
			val imgHeight = image.getHeight
			
			if (imgWidth > maxWidth)
				maxWidth = imgWidth
				
			height += imgHeight + DEFAULT_SPACE
			
			images.add(image)
		}

		val sprite = new BufferedImage(maxWidth, height, BufferedImage.TYPE_INT_ARGB)
		val canvas = sprite.createGraphics
		
		var currentHeight = 0
		images.foreach{ image =>
			canvas.drawImage(image, 0, currentHeight, null)
			currentHeight += image.getHeight + DEFAULT_SPACE
		}
		
		ImageIO.write(sprite, "png", output);
	}
}