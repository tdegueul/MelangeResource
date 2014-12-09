package melangefsm;

import melangefsm.FsmMT;

import org.eclipse.emf.ecore.resource.Resource;

@SuppressWarnings("all")
public class TimedFsm {
  private Resource resource;
  
  public Resource getResource() {
    return this.resource;
  }
  
  public void setResource(final Resource resource) {
    this.resource = resource;
  }
  
  public FsmMT toFsmMT() {
    melangefsm.timedfsm.adapters.fsmmt.TimedFsmAdapter adaptee = new melangefsm.timedfsm.adapters.fsmmt.TimedFsmAdapter() ;
    adaptee.setAdaptee(resource) ;
    return adaptee ;
  }
  
  public static TimedFsm load(final String uri) {
    org.eclipse.emf.ecore.resource.ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl() ;
    Resource res = rs.getResource(org.eclipse.emf.common.util.URI.createURI(uri), true) ;
    TimedFsm mm = new TimedFsm() ;
    mm.setResource(res) ;
    return mm ;
  }
}
