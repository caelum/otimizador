package br.com.caelum.otimizador

import java.io.File
import br.com.caelum.otimizador.images.ImageConcatenation

object TestImageConcatenation {
	def main(args : Array[String]) : Unit = {

		val init = System.currentTimeMillis
		
		val img1 = new File("src/test/resources/image/bigsprite.png/FJ-11.png")
		val img2 = new File("src/test/resources/image/bigsprite.png/FJ-21.png")
		val img3 = new File("src/test/resources/image/bigsprite.png/FJ-16.png")
		val img4 = new File("src/test/resources/image/bigsprite.png/CS-01.png")
		val img5 = new File("src/test/resources/image/bigsprite.png/CS-14.png")
		val img6 = new File("src/test/resources/image/bigsprite.png/FJ-19.png")
		val img7 = new File("src/test/resources/image/bigsprite.png/FJ-25.png")
		val img8 = new File("src/test/resources/image/bigsprite.png/FJ-26.png")
		val img9 = new File("src/test/resources/image/bigsprite.png/FJ-31.png")
		val img10= new File("src/test/resources/image/bigsprite.png/FJ-27.png")
		val img11= new File("src/test/resources/image/bigsprite.png/FJ-28.png")
		val img12= new File("src/test/resources/image/bigsprite.png/FJ-34.png")
		val img13= new File("src/test/resources/image/bigsprite.png/FJ-55.png")
		val img14= new File("src/test/resources/image/bigsprite.png/FJ-57.png")
		val img15= new File("src/test/resources/image/bigsprite.png/FJ-91.png")
		val img16= new File("src/test/resources/image/bigsprite.png/PM-83.png")
		val img17= new File("src/test/resources/image/bigsprite.png/PM-87.png")
		val img18= new File("src/test/resources/image/bigsprite.png/RR-71.png")
		val img19= new File("src/test/resources/image/bigsprite.png/RR-75.png")
		val img20= new File("src/test/resources/image/bigsprite.png/WD-41.png")
		val img21= new File("src/test/resources/image/bigsprite.png/WD-43.png")
		val img22= new File("src/test/resources/image/bigsprite.png/TV-61.png")
		val img23= new File("src/test/resources/image/bigsprite.png/TV-62.png")
		
		val concat = new ImageConcatenation
		concat.concatenate(new File("/tmp/output1.png"), Array(img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23):_*)
		
		println(System.currentTimeMillis - init + " ms")
		

		Thread.sleep(5000)
		main(null)
	}
}