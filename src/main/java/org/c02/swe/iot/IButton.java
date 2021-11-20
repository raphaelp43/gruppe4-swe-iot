package org.c02.swe.iot;

import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.Color;
import java.util.List;

public interface IButton {

	void setLed(int position, Color color) throws ParticleException;

	void allLedsOff() throws ParticleException;

	// ignore until setp 3
	void setLed(LedStatus status) throws ParticleException;

	void setLeds(List<LedStatus> statuses) throws ParticleException;



}
