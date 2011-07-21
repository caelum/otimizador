package br.com.caelum.otimizador.local

import java.nio.file._
import java.io.File
import scala.collection.JavaConversions._

class Java7FileSystemWatcher {

	def watch(baseFolder:File):Unit = {
		val watchService = FileSystems.getDefault.newWatchService
		val path = Paths.get(baseFolder.getAbsolutePath)
		
	    val key = path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY)
		
		while(true){
		    // take() will block until a file has been created/deleted
		    val signalledKey = watchService.take
		
		    // get list of events from key
		    val list = signalledKey.pollEvents
		
		    // VERY IMPORTANT! call reset() AFTER pollEvents() to allow the
		    // key to be reported again by the watch service
		    signalledKey.reset
		
		    // we'll simply print what has happened; real applications
		    // will do something more sensible here
		    list.foreach { e =>
		        var message = ""
		        if(e.kind() == StandardWatchEventKinds.ENTRY_CREATE){
		            val context = e.context();
		            message = context.toString() + " created";
		        } else if(e.kind() == StandardWatchEventKinds.ENTRY_DELETE){
		            val context = e.context();
		            message = context.toString() + " deleted";
		        } else if(e.kind() == StandardWatchEventKinds.ENTRY_MODIFY){
		            val context = e.context();
		            message = context.toString() + " modified";
		        } else if(e.kind() == StandardWatchEventKinds.OVERFLOW){
		            message = "OVERFLOW: more changes happened than we could retreive";
		        }
		        println(message)
		    }
		}
	}
	
}