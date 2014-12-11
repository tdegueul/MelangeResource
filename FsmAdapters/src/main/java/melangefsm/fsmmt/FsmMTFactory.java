package melangefsm.fsmmt;

import fr.inria.diverse.k3.sle.lib.IFactory;

@SuppressWarnings("all")
public interface FsmMTFactory extends IFactory {
  public abstract melangefsm.fsmmt.FSM createFSM();
  
  public abstract melangefsm.fsmmt.State createState();
  
  public abstract melangefsm.fsmmt.Transition createTransition();
}
