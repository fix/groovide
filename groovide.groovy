@Grab(group='org.eclipse.jetty', module='jetty-servlet', version='8.0.4.v20111024')

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.*
import org.eclipse.jetty.server.handler.*

import groovy.servlet.*

def startJetty() {
    def jetty = new Server(9090)
    
    ContextHandlerCollection contexts = new ContextHandlerCollection()
    jetty.setHandler(contexts)
    
    ServletContextHandler explore = new ServletContextHandler(contexts,"/",ServletContextHandler.SESSIONS)
    explore.resourceBase = '.'
    explore.addServlet(GroovyServlet, '/explore/*') 
    explore.addServlet(GroovyServlet, '/auth/*') 
    explore.addServlet(GroovyServlet, '/m/*')
    explore.addServlet(GroovyServlet, '/grails/*')
    explore.setAttribute('version', '1.0')
    
    jetty.start()
    jetty.join()
}

startJetty()
println "Starting Jetty, press Ctrl+C to stop."
