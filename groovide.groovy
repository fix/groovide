@Grab(group='org.eclipse.jetty', module='jetty-servlet', version='8.0.4.v20111024')
@GrabResolver(name="elasticsearch", root='http://oss.sonatype.org/content/repositories/releases/')
@Grab(group='org.elasticsearch', module='elasticsearch-transport-wares', version='0.18.6')

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.*
import org.eclipse.jetty.server.handler.*

import sun.misc.Signal
import sun.misc.SignalHandler

import org.elasticsearch.wares.NodeServlet

import groovy.servlet.*

def startJetty() {
    def jetty = new Server(9090)
    
    ContextHandlerCollection contexts = new ContextHandlerCollection()
    jetty.setHandler(contexts)
    
    ServletContextHandler explore = new ServletContextHandler(contexts,"/groovide",ServletContextHandler.SESSIONS)
    explore.resourceBase = '.'
    explore.addServlet(GroovyServlet, '/explore/*') 
    explore.addServlet(GroovyServlet, '/auth/*') 
    explore.addServlet(GroovyServlet, '/m/*')
    explore.addServlet(GroovyServlet, '/grails/*')
    explore.addServlet(NodeServlet, '/es/*')
    explore.setAttribute('version', '1.0')
    
    
    ServletContextHandler staticContent = new ServletContextHandler(contexts,"/",ServletContextHandler.SESSIONS)
    staticContent.resourceBase = '/'
    staticContent.addServlet(DefaultServlet, '/*') 

    Signal.handle(new Signal("INT"),new SignalHandler(){
        public void handle(Signal sig){
            jetty.stop()
        }
    });
    
    println "Starting Jetty, press Ctrl+C to stop."
    
    jetty.start()
    jetty.join()
}

startJetty()
