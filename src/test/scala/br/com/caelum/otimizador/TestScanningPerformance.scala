package br.com.caelum.otimizador

import java.io.File

object TestScanningPerformance {
  def main(args: Array[String]): Unit = { 
	 var lastTimestamp = 0L
	 
	 while (true) {
		 val init = System.currentTimeMillis
		 lastTimestamp = deepScan(new File("src/test/resources/"), lastTimestamp)
		 
		 println("[LAST MODIFIED "+lastTimestamp+"ms]")
		 println("[SCANNING TIME "+ (System.currentTimeMillis - init) +"ms]")
		 //println
		 
		 Thread.sleep(1000)
		 //return
	 }
  }
  
  def deepScan(folder: File, lastTimestamp:Long):Long = {
	  var returnTimestamp = lastTimestamp
	  
	  folder.listFiles.foreach { file =>
	   	  var modified = 0L
	 	  if (file.isDirectory) {
	 	 	  modified = deepScan(file, returnTimestamp)
	 	 	  
 	  	 	  if (modified > returnTimestamp) {
		 		  returnTimestamp = modified
		 		  println("MODIFIED "+file.getAbsolutePath+"")
 	  	 	  }
	 	  } else if (!file.getName.equals(".DS_Store")) {
	 	 	  modified = file.lastModified
	 	 	  //println(file.getAbsolutePath + " [" + modified + "]")
	 	 	  
 	  	 	  if (modified > returnTimestamp) {
		 		  returnTimestamp = modified
		 		  println("MODIFIED "+file.getAbsolutePath+"")
 	  	 	  }
	 	  }
	  }
	   
	  return returnTimestamp
  }
}