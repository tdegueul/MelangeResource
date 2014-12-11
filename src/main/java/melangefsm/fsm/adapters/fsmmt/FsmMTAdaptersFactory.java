package melangefsm.fsm.adapters.fsmmt;

import melangefsm.fsm.adapters.fsmmt.FSMAdapter;
import melangefsm.fsm.adapters.fsmmt.StateAdapter;
import melangefsm.fsm.adapters.fsmmt.TransitionAdapter;
import fsm.FSM;
import fsm.State;
import fsm.Transition;

@SuppressWarnings("all")
public class FsmMTAdaptersFactory {
  private static FsmMTAdaptersFactory instance;
  
  public static FsmMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new melangefsm.fsm.adapters.fsmmt.FsmMTAdaptersFactory() ;
    }
    return instance ;
  }
  
  public FSMAdapter createFSMAdapter(final FSM adaptee) {
    melangefsm.fsm.adapters.fsmmt.FSMAdapter adap = new melangefsm.fsm.adapters.fsmmt.FSMAdapter() ;
    adap.setAdaptee(adaptee) ;
    return adap ;
  }
  
  public StateAdapter createStateAdapter(final State adaptee) {
    melangefsm.fsm.adapters.fsmmt.StateAdapter adap = new melangefsm.fsm.adapters.fsmmt.StateAdapter() ;
    adap.setAdaptee(adaptee) ;
    return adap ;
  }
  
  public TransitionAdapter createTransitionAdapter(final Transition adaptee) {
    melangefsm.fsm.adapters.fsmmt.TransitionAdapter adap = new melangefsm.fsm.adapters.fsmmt.TransitionAdapter() ;
    adap.setAdaptee(adaptee) ;
    return adap ;
  }
}
