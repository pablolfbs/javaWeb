package br.com.caelum.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LogPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 9039601385787424895L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("FASE " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
