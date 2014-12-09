package melangeresource

import fsm.FsmPackage
import melangefsm.fsm.adapters.fsmmt.FsmAdapter
import melangefsm.fsmmt.FSM
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import timedfsm.TimedfsmPackage
import melangefsm.timedfsm.adapters.fsmmt.TimedFsmAdapter

class Test
{
	def static void main(String[] args) {
		register()
		
		try {
			//val uri = "melange:/resource/MelangeResource/input/Simple.fsm?mt=FsmMT"
			val uri = "melange:/resource/MelangeResource/input/Simple.timedfsm?mt=FsmMT"
			val rs = new ResourceSetImpl
			val res = rs.getResource(URI.createURI(uri), true)
			val root = res.contents.head as FSM

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
		// Legacy EMF registration
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

		// ModelType-Specific Stuff
		Resource.Factory.Registry.INSTANCE.protocolToFactoryMap.put(
			"melange",
			new MelangeResourceFactory
		)

		// EMF-style registry for model types...
		ModelType.Registry.INSTANCE.put(FsmPackage.eNS_URI -> "FsmMT", FsmAdapter)
		ModelType.Registry.INSTANCE.put(TimedfsmPackage.eNS_URI -> "FsmMT", TimedFsmAdapter)
	}
}
