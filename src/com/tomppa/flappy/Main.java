package com.tomppa.flappy;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GLContext;

import com.tomppa.flappy.input.Input;

public class Main implements Runnable {
	
	private int width = 1280;
	private int height = 720;
	
	private Thread thread;
	private boolean running = false;
	
	private long window;
	
	public void start() {
		running = true;
		thread = new Thread(this, "Game"); // Game thread
		thread.start();
	}
	
	private void init() {
		if (glfwInit() != GL_TRUE) {
			// TODO: handle it
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(width, height, "Flappy", NULL, NULL);

		if (window == NULL) {
			// TODO: handle
			return;
		}
		
		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (GLFWvidmode.width(vidmode) - width) / 2, (GLFWvidmode.height(vidmode) - height) / 2);
		
		glfwSetKeyCallback(window, new Input());
		
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		GLContext.createFromCurrent();
		
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		glEnable(GL_DEPTH_TEST);
		System.out.println("OpenGL: " + glGetString(GL_VERSION));
	}
	
	public void run() {
		init();
		while (running) {
			update();
			render();
			
			if (glfwWindowShouldClose(window) == GL_TRUE) 
				running = false;
		}
	}
	
	private void update() {
		glfwPollEvents();
	}
	
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glfwSwapBuffers(window);
	}

	public static void main(String[] args) {
		new Main().start();
	}

}
