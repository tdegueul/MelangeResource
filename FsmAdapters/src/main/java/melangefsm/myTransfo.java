package melangefsm;

import java.util.List;

import melangefsm.FsmMT;
import melangefsm.fsmmt.FSM;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class myTransfo {
  public static void call(final FsmMT m) {
    EList<EObject> _contents = m.getContents();
    Object _head = IterableExtensions.<EObject>head(_contents);
    final FSM root = ((FSM) _head);
    InputOutput.<String>println(("MyTransfo: root = " + root));
  }
}
