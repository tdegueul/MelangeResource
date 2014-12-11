package melangefsm.timedfsm.adapters.fsmmt;

import fr.inria.diverse.k3.sle.lib.GenericAdapter;
import fr.inria.diverse.k3.sle.lib.ResourceAdapter;

import java.io.IOException;
import java.util.List;

import melangefsm.FsmMT;
import melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory;
import melangefsm.fsmmt.FsmMTFactory;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicInternalEList;

@SuppressWarnings("all")
public class TimedFsmAdapter extends ResourceAdapter implements FsmMT {
  private FsmMTAdaptersFactory adaptersFactory = melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
  public EList<EObject> getContents() {
    EList<EObject> ret = new BasicInternalEList<EObject>(EObject.class);
    
    for (org.eclipse.emf.ecore.EObject o : adaptee.getContents()) {
    if (o instanceof timedfsm.FSM) {
    	ret.add(adaptersFactory.createFSMAdapter((timedfsm.FSM) o)) ;
    } else
    						if (o instanceof timedfsm.State) {
    	ret.add(adaptersFactory.createStateAdapter((timedfsm.State) o)) ;
    } else
    						if (o instanceof timedfsm.Transition) {
    	ret.add(adaptersFactory.createTransitionAdapter((timedfsm.Transition) o)) ;
    } else
    						 ret.add(o) ;
    }
    
    return ret ;
  }
  
  public FsmMTFactory getFactory() {
    return new melangefsm.timedfsm.adapters.fsmmt.FsmMTFactoryAdapter() ;
  }
  
  public void save(final String uri) throws IOException {
    this.adaptee.setURI(org.eclipse.emf.common.util.URI.createURI(uri));
    this.adaptee.save(null);
  }
}
