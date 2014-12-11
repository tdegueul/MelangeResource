package melangefsm;

import melangefsm.FsmMT;

import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public class Fsm {
  private Resource resource;
  
  public Resource getResource() {
    return this.resource;
  }
  
  public void setResource(final Resource resource) {
    this.resource = resource;
  }
  
  public FsmMT toFsmMT() {
    melangefsm.fsm.adapters.fsmmt.FsmAdapter adaptee = new melangefsm.fsm.adapters.fsmmt.FsmAdapter() ;
    adaptee.setAdaptee(resource) ;
    return adaptee ;
  }
  
  public static Fsm load(final String uri) {
    org.eclipse.emf.ecore.resource.ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl() ;
    Resource res = rs.getResource(org.eclipse.emf.common.util.URI.createURI(uri), true) ;
    Fsm mm = new Fsm() ;
    mm.setResource(res) ;
    return mm ;
  }
}
