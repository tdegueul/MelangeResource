package melangefsm.fsm.adapters.fsmmt;

import melangefsm.fsm.adapters.fsmmt.FsmMTAdaptersFactory;
import melangefsm.fsmmt.FSM;
import melangefsm.fsmmt.FsmMTFactory;
import melangefsm.fsmmt.State;
import melangefsm.fsmmt.Transition;
import fsm.FsmFactory;

@SuppressWarnings("all")
public class FsmMTFactoryAdapter implements FsmMTFactory {
  private FsmMTAdaptersFactory adaptersFactory = melangefsm.fsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
  private FsmFactory fsmAdaptee = fsm.FsmFactory.eINSTANCE;
  
  public FSM createFSM() {
    return adaptersFactory.createFSMAdapter(fsmAdaptee.createFSM()) ;
  }
  
  public State createState() {
    return adaptersFactory.createStateAdapter(fsmAdaptee.createState()) ;
  }
  
  public Transition createTransition() {
    return adaptersFactory.createTransitionAdapter(fsmAdaptee.createTransition()) ;
  }
}
