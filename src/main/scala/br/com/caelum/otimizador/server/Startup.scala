package br.com.caelum.otimizador.server

import java.io.File
import java.net.InetSocketAddress
import org.simpleframework.transport.connect.SocketConnection

object Startup {
  val PORT_NUMBER = 9090;
	
  def main(args : Array[String]) : Unit = {
	  
	  // TODO implementar mais argumentos na linha de comando
	  var root = new File(".");
	  if (args.length == 1) {
	 	  root = new File(args(0))
	  }
	  
	   println("Starting Simple HTTP server on port " + PORT_NUMBER)
	   println("Using ROOT folder " + root.getAbsolutePath)
	   
      val container = new ServerContainer(root)
      val connection = new SocketConnection(container);
      val address = new InetSocketAddress(PORT_NUMBER);

      connection.connect(address);
  }
}
