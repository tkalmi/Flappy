package com.tomppa.flappy.level;

import com.tomppa.flappy.graphics.Shader;
import com.tomppa.flappy.graphics.VertexArray;

public class Level {

	private VertexArray background;
	
	public Level() {
		float[] vertices = new float[] {
			-10.0f, -10.0f * 9.0f / 16.0f, 0.0f,
			-10.0f,  10.0f * 9.0f / 16.0f, 0.0f,
			  0.0f,  10.0f * 9.0f / 16.0f, 0.0f,
			  0.0f, -10.0f * 9.0f / 16.0f, 0.0f
		};
		
		byte[] indices = new byte[] {
			0, 1, 2,
			2, 3, 0
		};
		
		float[] tcs = new float[] {
			0, 1,
			0, 0,
			1, 0,
			1, 1
		};
		
		background = new VertexArray(vertices, indices, tcs);
	}
	
	public void render() {
		Shader.BG.enable();
		background.render();
		Shader.BG.disable();
	}
	
}
