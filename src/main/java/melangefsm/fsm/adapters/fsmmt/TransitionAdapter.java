package melangefsm.fsm.adapters.fsmmt;

import java.lang.reflect.InvocationTargetException;

import melangefsm.fsm.adapters.fsmmt.FsmMTAdaptersFactory;
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
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.diverse.k3.sle.lib.GenericAdapter;
import fsm.Transition;

@SuppressWarnings("all")
public class TransitionAdapter extends EObjectImpl implements GenericAdapter<Transition>, melangefsm.fsmmt.Transition {
  private Transition adaptee;
  
  public Transition getAdaptee() {
    return this.adaptee;
  }
  
  public void setAdaptee(final Transition adaptee) {
    this.adaptee = adaptee;
  }
  
  private FsmMTAdaptersFactory adaptersFactory = melangefsm.fsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
  public String getInput() {
    return adaptee.getInput() ;
  }
  
  public void setInput(final String o) {
    adaptee.setInput(o) ;
  }
  
  public String getOutput() {
    return adaptee.getOutput() ;
  }
  
  public void setOutput(final String o) {
    adaptee.setOutput(o) ;
  }
  
  public State getSource() {
    return adaptersFactory.createStateAdapter(adaptee.getSource()) ;
  }
  
  public void setSource(final State o) {
    adaptee.setSource(((melangefsm.fsm.adapters.fsmmt.StateAdapter) o).getAdaptee()) ;
  }
  
  public State getTarget() {
    return adaptersFactory.createStateAdapter(adaptee.getTarget()) ;
  }
  
  public void setTarget(final State o) {
    adaptee.setTarget(((melangefsm.fsm.adapters.fsmmt.StateAdapter) o).getAdaptee()) ;
  }

@Override
public EList<Adapter> eAdapters() {
	return adaptee.eAdapters();
}

@Override
public boolean eDeliver() {
	return adaptee.eDeliver();
}

@Override
public void eSetDeliver(boolean deliver) {
	adaptee.eSetDeliver(deliver);
}

@Override
public void eNotify(Notification notification) {
	// TODO Auto-generated method stub
	adaptee.eNotify(notification);
}

@Override
public EClass eClass() {
	// TODO Auto-generated method stub
	return adaptee.eClass();
}

@Override
public Resource eResource() {
	// TODO Auto-generated method stub
	return adaptee.eResource();
}

@Override
public EObject eContainer() {
	// TODO Auto-generated method stub
	return adaptee.eContainer();
}

@Override
public EStructuralFeature eContainingFeature() {
	// TODO Auto-generated method stub
	return adaptee.eContainingFeature();
}

@Override
public EReference eContainmentFeature() {
	// TODO Auto-generated method stub
	return adaptee.eContainmentFeature();
}

@Override
public EList<EObject> eContents() {
	// TODO Auto-generated method stub
	return adaptee.eContents();
}

@Override
public TreeIterator<EObject> eAllContents() {
	// TODO Auto-generated method stub
	return adaptee.eAllContents();
}

@Override
public boolean eIsProxy() {
	// TODO Auto-generated method stub
	return adaptee.eIsProxy();
}

@Override
public EList<EObject> eCrossReferences() {
	// TODO Auto-generated method stub
	return adaptee.eCrossReferences();
}

@Override
public Object eGet(EStructuralFeature feature) {
	// TODO Auto-generated method stub
	return adaptee.eGet(feature);
}

@Override
public Object eGet(EStructuralFeature feature, boolean resolve) {
	// TODO Auto-generated method stub
	return adaptee.eGet(feature, resolve);
}

@Override
public void eSet(EStructuralFeature feature, Object newValue) {
	// TODO Auto-generated method stub
	adaptee.eSet(feature, newValue);
}

@Override
public boolean eIsSet(EStructuralFeature feature) {
	// TODO Auto-generated method stub
	return adaptee.eIsSet(feature);
}

@Override
public void eUnset(EStructuralFeature feature) {
	// TODO Auto-generated method stub
	adaptee.eUnset(feature);
}

@Override
public Object eInvoke(EOperation operation, EList<?> arguments)
		throws InvocationTargetException {
	return adaptee.eInvoke(operation, arguments);
}
}
