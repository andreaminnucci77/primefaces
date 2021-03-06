//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//

try {
    def baseDir = grails.util.BuildSettingsHolder.settings.baseDir

   	ant.copy (
		file:"${primefacesPluginDir}/scripts/faces-config.xml",
		todir:"${baseDir}/web-app/WEB-INF",
		overwrite: true
	)

        ant.mkdir(dir:"${primefacesPluginDir}/web-app/js/primefaces")
    
	ant.copy(todir: "${baseDir}/web-app/js/primefaces") {
            fileset(dir: "${primefacesPluginDir}/web-app/js/primefaces")
	}
	
} catch (Throwable e) {
    e.printStackTrace()
}