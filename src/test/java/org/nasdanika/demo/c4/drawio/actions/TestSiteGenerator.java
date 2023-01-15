package org.nasdanika.demo.c4.drawio.actions;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.junit.jupiter.api.Test;
import org.nasdanika.html.model.app.gen.ActionSiteGenerator;

public class TestSiteGenerator {
		
	@Test
	public void generate() throws IOException, DiagnosticException {
		ActionSiteGenerator actionSiteGenerator = new ActionSiteGenerator();
		
		String rootActionResource = "model/actions.yml";
		URI rootActionURI = URI.createFileURI(new File(rootActionResource).getAbsolutePath());
		
		String pageTemplateResource = "model/page-template.yml";
		URI pageTemplateURI = URI.createFileURI(new File(pageTemplateResource).getAbsolutePath());
		
		Map<String, Collection<String>> errors = actionSiteGenerator.generate(
				rootActionURI, 
				pageTemplateURI, 
				"https://nasdanika.org/demo-c4-drawio-actions", 
				new File("docs"), 
				new File("target/action-site"), 
				false);
		
		for (Entry<String, Collection<String>> ee: errors.entrySet()) {
			System.err.println(ee.getKey());
			for (String error: ee.getValue()) {
				System.err.println("\t" + error);
			}
		}
	}
	
}
