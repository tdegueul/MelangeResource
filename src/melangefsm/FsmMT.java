package melangefsm;

import fr.inria.diverse.k3.sle.lib.IModelType;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public interface FsmMT {
  public abstract EList<EObject> getContents();
  
  public abstract melangefsm.fsmmt.FsmMTFactory getFactory();
  
  public void save(final String uri) throws IOException;
}
