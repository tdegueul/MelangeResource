package melangefsm.timedfsm.adapters.fsmmt;

import melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory;
import melangefsm.fsmmt.FSM;
import melangefsm.fsmmt.FsmMTFactory;
import melangefsm.fsmmt.State;
import melangefsm.fsmmt.Transition;
import timedfsm.TimedfsmFactory;

@SuppressWarnings("all")
public class FsmMTFactoryAdapter implements FsmMTFactory {
  private FsmMTAdaptersFactory adaptersFactory = melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory.getInstance();
  
  private TimedfsmFactory fsmAdaptee = timedfsm.TimedfsmFactory.eINSTANCE;
  
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
