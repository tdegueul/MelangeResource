package fr.inria.diverse.melange.resource

import java.util.Map
import java.util.HashMap
import java.io.IOException
import fr.inria.diverse.k3.sle.lib.GenericAdapter
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject;

interface ModelType
{
	def EList<EObject> getContents();

	def void save(String uri) throws IOException;

	interface Registry extends Map<Pair<String, String>, Class<? extends GenericAdapter<Resource>>> {
		// Make it global
		Registry INSTANCE = ModelTypeRegistryImpl.getInstance()
	}

	static class ModelTypeRegistryImpl extends HashMap<Pair<String, String>, Class<? extends GenericAdapter<Resource>>> implements ModelType.Registry {
		static ModelType.Registry instance

		def static ModelType.Registry getInstance() {
			if (instance === null)
				instance = new ModelTypeRegistryImpl

			return instance
		}
	}
}
