package melangefsm.timedfsm.adapters.fsmmt;

import java.lang.reflect.InvocationTargetException;

import melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory;
import melangefsm.fsmmt.State;

import fr.inria.diverse.k3.sle.lib.EObjectAdapter;
import fr.inria.diverse.k3.sle.lib.GenericAdapter;
import timedfsm.Transition;

@SuppressWarnings("all")
public class TransitionAdapter extends EObjectAdapter<Transition> implements melangefsm.fsmmt.Transition {
  private FsmMTAdaptersFactory adaptersFactory = melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
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
    adaptee.setSource(((melangefsm.timedfsm.adapters.fsmmt.StateAdapter) o).getAdaptee()) ;
  }
  
  public State getTarget() {
    return adaptersFactory.createStateAdapter(adaptee.getTarget()) ;
  }
  
  public void setTarget(final State o) {
    adaptee.setTarget(((melangefsm.timedfsm.adapters.fsmmt.StateAdapter) o).getAdaptee()) ;
  }
}
