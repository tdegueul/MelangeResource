package melangefsm.fsmmt;

import java.util.List;

import melangefsm.fsmmt.FSM;

import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public interface State extends EObject {
  public String getName();
  
  public void setName(final String name);
  
  public FSM getOwningFSM();
  
  public void setOwningFSM(final FSM owningFSM);
  
  public List<melangefsm.fsmmt.Transition> getOutgoingTransition();
  
  public List<melangefsm.fsmmt.Transition> getIncomingTransition();
}
