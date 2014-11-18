package melangeresource

import mymetamodel.MymetamodelPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl

class MelangeResourceFactory implements Resource.Factory
{
	new() {
		super()
	}

	override Resource createResource(URI uri) {
		val mt = uri.query.split("=").get(1)
		println("Loading " + uri.lastSegment + " as " + mt)
		
		//val legacyUri = uri.toString.replaceFirst("melange:/resource", "")
		// Properly convert from melange:/ to EMF URIs
		return new MelangeResource(URI.createFileURI("../MelangeResource/input/Foo.xmi"))
	}
}

// Parameterized with MyAdapter or something
class MelangeResource extends XMIResourceImpl
{
	new(URI uri) {
		super(uri)
	}
	
	override getContents() {
		// Call here the appropriate adapter's getContents()
		/*val ret = new BasicInternalEList<EObject>(EObject)
		
		// Assuming there's only A as root
		super.getContents.forEach[
			val adap = new AAdapter(it as mymetamodel.A)
			println("Adding adap = " + adap)
			ret += adap
		]
		
		return ret*/
		return super.getContents
	}
}

class Test
{
	def static void main(String[] args) {
		register()
		
		try {
			val uri = "melange:/resource/MelangeResource/input/Foo.xmi?mt=MyMT"
			val rs = new ResourceSetImpl
			val res = rs.getResource(URI.createURI(uri), true)
			
			println("o = " + res.contents.head)
		} catch (Exception e) {
			e.printStackTrace
		}
	}
	
	def static void register() {
		Resource.Factory.Registry.INSTANCE.protocolToFactoryMap.put(
			"melange",
			new MelangeResourceFactory
		)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put(
			"xmi",
			new XMIResourceFactoryImpl
		)
		
		EPackage.Registry.INSTANCE.put(MymetamodelPackage.eNS_URI, MymetamodelPackage.eINSTANCE)
	}
}
