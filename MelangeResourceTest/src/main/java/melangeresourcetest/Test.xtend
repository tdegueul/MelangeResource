package melangeresourcetest

import fr.inria.diverse.melange.resource.ModelType
import fsm.FsmPackage
import melangefsm.fsm.adapters.fsmmt.FsmAdapter
import melangefsm.fsmmt.FSM
import melangefsm.timedfsm.adapters.fsmmt.TimedFsmAdapter
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import timedfsm.TimedfsmPackage
import org.eclipse.emf.ecore.resource.Resource
import fr.inria.diverse.melange.resource.MelangeResourceFactory
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.EPackage

class Test
{
	def static void main(String[] args) {
		register

		doSomethingWithGenericFsm("melange:/resource/MelangeResourceTest/input/Simple.fsm?mt=FsmMT")
		doSomethingWithGenericFsm("melange:/resource/MelangeResourceTest/input/Simple.timedfsm?mt=FsmMT")
	}

	// Will work for both FSM and TimedFSM metamodels
	def static void doSomethingWithGenericFsm(String uri) {
		val rs = new ResourceSetImpl
		val res = rs.getResource(URI.createURI(uri), true)
		val fsm = res.contents.head as FSM

		// Using generic API
		println("root.owned = " + fsm.ownedState.map[name].join(", "))
		println("root.trans = " + fsm.ownedState.map[outgoingTransition].flatten.map[input].join(", "))

		// Invoking generic transformation
		// Cannot at the moment because no in-the-large container :(
		// (in Melange, transfo are typed by the MM/MT themselves, not the root element)
		//melangefsm.myTransfo::call(fsm)
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
