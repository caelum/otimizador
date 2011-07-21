package br.com.caelum.otimizador

import java.io.File
import local._

object TestJNotifyFileSystemWatcher {

  def main(args: Array[String]): Unit = { 
	  val watcher = new JNotifyFileSystemWatcher
	  watcher.watch(new File("."))
  }

}