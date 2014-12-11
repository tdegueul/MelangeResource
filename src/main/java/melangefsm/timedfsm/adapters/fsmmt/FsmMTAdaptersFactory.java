package melangefsm.timedfsm.adapters.fsmmt;

import melangefsm.timedfsm.adapters.fsmmt.FSMAdapter;
import melangefsm.timedfsm.adapters.fsmmt.StateAdapter;
import melangefsm.timedfsm.adapters.fsmmt.TransitionAdapter;
import timedfsm.FSM;
import timedfsm.State;
import timedfsm.Transition;

@SuppressWarnings("all")
public class FsmMTAdaptersFactory {
  private static FsmMTAdaptersFactory instance;
  
  public static FsmMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new melangefsm.timedfsm.adapters.fsmmt.FsmMTAdaptersFactory() ;
    }
    return instance ;
  }
  
  public FSMAdapter createFSMAdapter(final FSM adaptee) {
    melangefsm.timedfsm.adapters.fsmmt.FSMAdapter adap = new melangefsm.timedfsm.adapters.fsmmt.FSMAdapter() ;
    adap.setAdaptee(adaptee) ;
    return adap ;
  }
  
  public StateAdapter createStateAdapter(final State adaptee) {
    melangefsm.timedfsm.adapters.fsmmt.StateAdapter adap = new melangefsm.timedfsm.adapters.fsmmt.StateAdapter() ;
    adap.setAdaptee(adaptee) ;
    return adap ;
  }
  
  public TransitionAdapter createTransitionAdapter(final Transition adaptee) {
    melangefsm.timedfsm.adapters.fsmmt.TransitionAdapter adap = new melangefsm.timedfsm.adapters.fsmmt.TransitionAdapter() ;
    adap.setAdaptee(adaptee) ;
    return adap ;
  }
}
