package br.com.caelum.otimizador.server

import java.util.Scanner
import java.io.File
import org.simpleframework.http.Response
import org.simpleframework.http.Request
import org.simpleframework.http.core.Container

class ServerContainer (val rootFolder: File) extends Container {

	def handle(request:Request , response:Response) {
		
		val url = request.getPath.getPath
		val completePath = rootFolder.getAbsolutePath + url
		val filePath = new File(completePath)
		
		if (filePath.isDirectory) {
			
			// css packages
			if (url.endsWith(".css")) { // TODO suportar .css/ ?
				response.set("Content-Type", "text/css; charset=UTF-8");
				response.setDate("Date", System.currentTimeMillis());
				response.setDate("Expires", 0);
		
				val body = response.getPrintStream();
				for (file <- filePath.listFiles) {
					val content = new Scanner(file, "UTF-8").useDelimiter("\\Z").next()
					body.println(content)
				}
				body.close
			} else {
				// TODO js, images
				do404(response)
			}
		} else if (filePath.isFile) {
			if (url.endsWith(".css")) {
				response.set("Content-Type", "text/css; charset=UTF-8");
			} else if (url.endsWith(".js")) {
				response.set("Content-Type", "application/javascript; charset=UTF-8");
			}
			response.setDate("Date", System.currentTimeMillis());
			response.setDate("Expires", 0);
	
			val body = response.getPrintStream();
			val content = new Scanner(filePath, "UTF-8").useDelimiter("\\Z").next()
			body.println(content)
			body.close
			
		} else {
			do404(response)
		}
   }
	
	def do404(response:Response) = {
		response.setCode(404)
		response.setText("Not Found")
		response.set("Content-Type", "text/plain")
		response.setDate("Date", System.currentTimeMillis())
		
		val body = response.getPrintStream();
		body.println("Not Found")
		body.close
	}
	
}