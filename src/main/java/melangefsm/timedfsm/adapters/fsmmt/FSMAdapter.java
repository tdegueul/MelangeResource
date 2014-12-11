package melangefsm.timedfsm.adapters.fsmmt;

import fr.inria.diverse.k3.sle.lib.EObjectAdapter;
import fr.inria.diverse.k3.sle.lib.GenericAdapter;
import timedfsm.FSM;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory;
import melangefsm.fsmmt.State;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

@SuppressWarnings("all")
public class FSMAdapter extends EObjectAdapter<FSM> implements melangefsm.fsmmt.FSM {
  private FsmMTAdaptersFactory adaptersFactory = melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
  public List<State> getOwnedState() {
    return fr.inria.diverse.k3.sle.lib.ListAdapter.newInstance(adaptee.getOwnedState(), melangefsm.timedfsm.adapters.fsmmt.StateAdapter.class) ;
  }
  
  public State getInitialState() {
    return adaptersFactory.createStateAdapter(adaptee.getInitialState()) ;
  }
  
  public void setInitialState(final State o) {
    adaptee.setInitialState(((melangefsm.timedfsm.adapters.fsmmt.StateAdapter) o).getAdaptee()) ;
  }
  
  public List<State> getFinalState() {
    return fr.inria.diverse.k3.sle.lib.ListAdapter.newInstance(adaptee.getFinalState(), melangefsm.timedfsm.adapters.fsmmt.StateAdapter.class) ;
  }
}
