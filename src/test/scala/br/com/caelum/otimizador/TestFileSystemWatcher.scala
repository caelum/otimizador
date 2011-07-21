package br.com.caelum.otimizador

import java.io.File
import local._

object TestFileSystemWatcher {

  def main(args: Array[String]): Unit = { 
	  val watcher = new Java7FileSystemWatcher
	  watcher.watch(new File("."))
  }

}