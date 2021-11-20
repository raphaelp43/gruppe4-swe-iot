package org.c02.swe.iot.examples;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.Button;
import org.c02.swe.iot.LedStatus;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class LedButtonAPIDemo {

	static IParticleApi api = new ParticleApi(new ButtonConnection());
	
	public static void main(String[] args) throws ParticleException {

		//This example works after the Button Implementation has been finished
		IButton button = new Button(api);

		button.setLed(1, Color.ORANGE);
		button.setLed(2, Color.white);
		button.setLed(3, Color.green);
		button.setLed(4, Color.red);
		button.setLed(5, Color.blue);

		button.allLedsOff();
	}

}
