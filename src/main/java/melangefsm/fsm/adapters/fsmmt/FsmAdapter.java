package melangefsm.fsm.adapters.fsmmt;

import fr.inria.diverse.k3.sle.lib.GenericAdapter;
import fr.inria.diverse.k3.sle.lib.ResourceAdapter;

import java.io.IOException;
import java.util.List;

import melangefsm.FsmMT;
import melangefsm.fsm.adapters.fsmmt.FsmMTAdaptersFactory;
import melangefsm.fsmmt.FsmMTFactory;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicInternalEList;

@SuppressWarnings("all")
public class FsmAdapter extends ResourceAdapter implements FsmMT {
  private FsmMTAdaptersFactory adaptersFactory = melangefsm.fsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
  public EList<EObject> getContents() {
    EList<EObject> ret = new BasicInternalEList<EObject>(EObject.class);
    
    for (org.eclipse.emf.ecore.EObject o : adaptee.getContents()) {
    if (o instanceof fsm.FSM) {
    	ret.add(adaptersFactory.createFSMAdapter((fsm.FSM) o)) ;
    } else
    						if (o instanceof fsm.State) {
    	ret.add(adaptersFactory.createStateAdapter((fsm.State) o)) ;
    } else
    						if (o instanceof fsm.Transition) {
    	ret.add(adaptersFactory.createTransitionAdapter((fsm.Transition) o)) ;
    } else
    						 ret.add(o) ;
    }
    
    return ret ;
  }
  
  public FsmMTFactory getFactory() {
    return new melangefsm.fsm.adapters.fsmmt.FsmMTFactoryAdapter() ;
  }
  
  public void save(final String uri) throws IOException {
    this.adaptee.setURI(org.eclipse.emf.common.util.URI.createURI(uri));
    this.adaptee.save(null);
  }
}
