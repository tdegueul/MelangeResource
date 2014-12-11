package fr.inria.diverse.melange.resource

import java.util.Map
import java.util.HashMap
import java.io.IOException
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject;
import fr.inria.diverse.k3.sle.lib.ResourceAdapter

interface ModelType
{
	def EList<EObject> getContents();

	def void save(String uri) throws IOException;

	interface Registry extends Map<Pair<String, String>, Class<? extends ResourceAdapter>> {
		// Make it global
		Registry INSTANCE = ModelTypeRegistryImpl.getInstance()
	}

	static class ModelTypeRegistryImpl extends HashMap<Pair<String, String>, Class<? extends ResourceAdapter>> implements ModelType.Registry {
		static ModelType.Registry instance

		def static ModelType.Registry getInstance() {
			if (instance === null)
				instance = new ModelTypeRegistryImpl

			return instance
		}
	}
}
