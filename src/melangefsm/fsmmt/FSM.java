package melangefsm.fsmmt;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public interface FSM extends EObject {
  public List<melangefsm.fsmmt.State> getOwnedState();
  
  public melangefsm.fsmmt.State getInitialState();
  
  public void setInitialState(final melangefsm.fsmmt.State initialState);
  
  public List<melangefsm.fsmmt.State> getFinalState();
}
