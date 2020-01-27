package net.jonbell.maven.logger;

import java.io.File;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.ExecutionListener;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;

@Component(role = AbstractMavenLifecycleParticipant.class, hint = "plugin-changer")
public class PluginVersionChangingParticipant extends AbstractMavenLifecycleParticipant {

	@Override
	public void afterProjectsRead(MavenSession session) throws MavenExecutionException {
	    if(System.getProperty("surefireVersion") != null){
	    	for(MavenProject p : session.getProjects()){
	    		for(Plugin plug : p.getBuildPlugins()){
	    			if(plug.getGroupId().equals("org.apache.maven.plugins") && (plug.getArtifactId().equals("maven-surefire-plugin") ||
							plug.getArtifactId().equals("maven-failsafe-plugin"))){
	    				plug.setVersion(System.getProperty("surefireVersion"));
					}
				}
			}
		}
	}

}