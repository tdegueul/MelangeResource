package melangeresource

import fsm.FsmPackage
import melangefsm.fsm.adapters.fsmmt.FsmAdapter
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
import timedfsm.TimedfsmPackage

class MelangeResourceFactory implements Resource.Factory
{
	override Resource createResource(URI uri) {
		val mt = uri.query.split("=").get(1)
		println("Loading " + uri.lastSegment + " as " + mt)
		
		//val legacyUri = uri.toString.replaceFirst("melange:/resource", "")
		// Properly convert from melange:/ to EMF URIs
		return new MelangeResource(URI.createFileURI("../MelangeResource/input/Simple.fsm"))
	}
}

// Parameterized with MyAdapter or something
class MelangeResource extends XMIResourceImpl
{
	new(URI uri) {
		super(uri)
	}
	
	override getContents() {
		val rs = new ResourceSetImpl
		val res = rs.getResource(URI::createFileURI("../MelangeResource/input/Simple.fsm"), true)
		val melangeAdap = new FsmAdapter
		melangeAdap.adaptee = res
		
		return melangeAdap.contents
	}
}

class Test
{
	def static void main(String[] args) {
		register()
		
		try {
			val uri = "melange:/resource/MelangeResource/input/Simple.fsm?mt=MyMT"
			val rs = new ResourceSetImpl
			val res = rs.getResource(URI.createURI(uri), true)
			val root = res.contents.head as melangefsm.fsmmt.FSM

			// Using generic API
			println("root.owned = " + root.ownedState.map[name].join(", "))
			println("root.trans = " + root.ownedState.map[outgoingTransition].flatten.map[input].join(", "))
			
			// Invoking generic transformation
			// Cannot at the moment because no in-the-large container :(
			//melangefsm.myTransfo::call(root)
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
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put(
			"fsm",
			new XMIResourceFactoryImpl
		)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put(
			"timedfsm",
			new XMIResourceFactoryImpl
		)
		
		EPackage.Registry.INSTANCE.put(FsmPackage.eNS_URI, FsmPackage.eINSTANCE)
		EPackage.Registry.INSTANCE.put(TimedfsmPackage.eNS_URI, TimedfsmPackage.eINSTANCE)
	}
}
