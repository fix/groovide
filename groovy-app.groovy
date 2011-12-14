import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.*
import org.mortbay.jetty.handler.*
import org.mortbay.servlet.*

import groovy.servlet.*

@Grab(group='org.mortbay.jetty', module='jetty-embedded', version='6.1.14')
def startJetty() {
    def jetty = new Server(9090)
    
    ContextHandlerCollection contexts = new ContextHandlerCollection();
    jetty.setHandler(contexts);
  
    ResourceHandler resource=new ResourceHandler();
    resource.welcomeFiles=["index.html"];
    resource.resourceBase=".";
    contexts.addHandler(resource)

    Context explore = new Context(contexts,"/",Context.SESSIONS);
    explore.resourceBase = '.'
    explore.addServlet(GroovyServlet, '/explore/*') 
    explore.addServlet(GroovyServlet, '/auth/*') 
    explore.addServlet(GroovyServlet, '/m/*')
    explore.setAttribute('version', '1.0')  // Set an context attribute.

    StatisticsHandler stats = new StatisticsHandler();
    contexts.addHandler(stats);
    
    
    jetty.start()
    jetty.join()
}

println "Starting Jetty, press Ctrl+C to stop."
startJetty()
