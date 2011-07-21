package br.com.caelum.otimizador.local

import net.contentobjects.jnotify._
import java.io.File
import scala.collection.JavaConversions._

class JNotifyFileSystemWatcher {

	def watch(baseFolder:File):Unit = {

		val path = baseFolder.getAbsolutePath

    // watch mask, specify events you care about,
    // or JNotify.FILE_ANY for all events.
    val mask = JNotify.FILE_CREATED  | 
               JNotify.FILE_DELETED  | 
               JNotify.FILE_MODIFIED | 
               JNotify.FILE_RENAMED;

    // watch subtree?
    val watchSubtree = true;

    // add actual watch
    val watchID = JNotify.addWatch(path, mask, watchSubtree, new Listener());

    // sleep a little, the application will exit if you
    // don't (watching is asynchronous), depending on your
    // application, this may not be required
    Thread.sleep(1000000);

    // to remove watch the watch
    val res = JNotify.removeWatch(watchID);
    if (!res) {
      // invalid watch ID specified.
    }
  }
  class Listener extends JNotifyListener {
    def fileRenamed(wd:Int, rootPath:String, oldName:String, newName:String) {
      print("renamed " + rootPath + " : " + oldName + " -> " + newName);
    }
    def fileModified(wd:Int, rootPath:String, name:String) {
      print("modified " + rootPath + " : " + name);
    }
    def fileDeleted(wd:Int, rootPath:String, name:String) {
      print("deleted " + rootPath + " : " + name);
    }
    def fileCreated(wd:Int, rootPath:String, name:String) {
      print("created " + rootPath + " : " + name);
    }
    def print(msg: String) {
      System.err.println(msg);
    }	
	
	}
	
}