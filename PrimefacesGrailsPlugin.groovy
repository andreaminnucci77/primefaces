import org.slf4j.Logger
import org.slf4j.LoggerFactory
import grails.util.Environment

class PrimefacesGrailsPlugin {
    private Logger log = LoggerFactory.getLogger('grails.plugins.primefaces.PrimefacesGrailsPlugin')
    
    // the plugin version
    def version = "0.1"
    // rmdir /S /Q %USERPROFILE%\.m2\repository\org\grails\plugins\primefaces
    
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3.7 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Primefaces Plugin" // Headline display name of the plugin
    def author = "Andrea Minnucci"
    def authorEmail = "andreaminnucci77@gmail.com"
    def description = '''\
Brief summary/description of the plugin.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/primefaces"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
//    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
//    def scm = [ url: "http://svn.codehaus.org/grails-plugins/" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
        def contextParam = xml.'context-param'

        if (Environment.current == Environment.PRODUCTION) {
            contextParam[contextParam.size() - 1] + {
                'context-param' {
                    'param-name'('javax.faces.PROJECT_STAGE')
                    'param-value'('Production')
                }
            }
        } else {
            contextParam[contextParam.size() - 1] + {
                'context-param' {
                    'param-name'('javax.faces.PROJECT_STAGE')
                    'param-value'('Development')
                }
            }
        } 

        def listenerNode = xml.'listener'
        listenerNode[listenerNode.size() - 1] + {
            listener {
                'listener-class'('org.apache.myfaces.webapp.StartupServletContextListener')
            }
        }
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
        /*
        log.info application.config?.grails?.plugins?.primefaces?.beans?.packages
        if (application.config?.grails?.plugins?.primefaces?.beans?.packages) {
            def packagesForScanning = application.config.grails.plugins.primefaces.beans.packages
            packagesForScanning.each { packageName ->
                log.info "\t " + packageName
                grails.plugins.primefaces.WebApplicationUtils.registryPrimefacesBeans(packageName);	
            }
        }
        */
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { ctx ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
