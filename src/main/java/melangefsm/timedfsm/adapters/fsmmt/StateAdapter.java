package melangefsm.timedfsm.adapters.fsmmt;

import fr.inria.diverse.k3.sle.lib.EObjectAdapter;
import fr.inria.diverse.k3.sle.lib.GenericAdapter;
import timedfsm.State;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory;
import melangefsm.fsmmt.FSM;
import melangefsm.fsmmt.Transition;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public class StateAdapter extends EObjectAdapter<State> implements melangefsm.fsmmt.State {
  private FsmMTAdaptersFactory adaptersFactory = melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
  public String getName() {
    return adaptee.getName() ;
  }
  
  public void setName(final String o) {
    adaptee.setName(o) ;
  }
  
  public FSM getOwningFSM() {
    return adaptersFactory.createFSMAdapter(adaptee.getOwningFSM()) ;
  }
  
  public void setOwningFSM(final FSM o) {
    adaptee.setOwningFSM(((melangefsm.timedfsm.adapters.fsmmt.FSMAdapter) o).getAdaptee()) ;
  }
  
  public List<Transition> getOutgoingTransition() {
    return fr.inria.diverse.k3.sle.lib.ListAdapter.newInstance(adaptee.getOutgoingTransition(), melangefsm.timedfsm.adapters.fsmmt.TransitionAdapter.class) ;
  }
  
  public List<Transition> getIncomingTransition() {
    return fr.inria.diverse.k3.sle.lib.ListAdapter.newInstance(adaptee.getIncomingTransition(), melangefsm.timedfsm.adapters.fsmmt.TransitionAdapter.class) ;
  }
}
