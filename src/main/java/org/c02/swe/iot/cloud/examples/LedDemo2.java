package org.c02.swe.iot.cloud.examples;

import java.io.IOException;

import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class LedDemo2 {

	static IParticleApi api = new ParticleApi(new ButtonConnection());

	public static void main(String[] args) throws IOException, ParticleException {

		api.callMethod("ledsOff", null); // Schaltet die LEDs aus
		// nn = Position 01-12
		// rrr = rot
		// ggg = grün
		// bbb = blau
		// nnrrrgggbbb

		api.callMethod("ledMultiple", "0125525525503255255255");

		api.callMethod("ledsOff", null);



	}

}
