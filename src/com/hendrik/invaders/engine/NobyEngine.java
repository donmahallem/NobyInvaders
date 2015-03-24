package com.hendrik.invaders.engine;

import com.hendrik.invaders.Log;
import org.lwjgl.Sys;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

import java.nio.ByteBuffer;

import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;

/**
 * Created by Don on 24/03/2015.
 */
public class NobyEngine {
    private final int DEFAULT_WINDOW_HEIGHT = 480, DEFAULT_WINDOW_WIDTH = 640;
    private GLFWErrorCallback mGLFWErrorCallback;
    private GLFWKeyCallback mGLFWKeyCallback;
    private long mWindowHandle;
    private Scene mScene;

    public NobyEngine() {

    }

    public void setScene(final Scene scene) {
        synchronized (this) {
            this.mScene = scene;
        }
    }

    public void run() {
        Log.d("App started with lwjgl version: " + Sys.getVersion());
        try {
            init(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
            loop();
            GLFW.glfwDestroyWindow(this.mWindowHandle);
            this.mGLFWKeyCallback.release();
        } finally {
            GLFW.glfwTerminate();
            mGLFWErrorCallback.release();
        }
    }

    private void init(final int width, final int height) {
        GLFW.glfwSetErrorCallback(this.mGLFWErrorCallback = errorCallbackPrint(System.err));
        if (GLFW.glfwInit() != GL11.GL_TRUE) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GL11.GL_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GL11.GL_FALSE);
        this.mWindowHandle = GLFW.glfwCreateWindow(width, height, "test", 0, 0);
        if (this.mWindowHandle == 0)
            throw new RuntimeException("Couldnt create Window");
        GLFW.glfwSetKeyCallback(this.mWindowHandle, this.mGLFWKeyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_RELEASE) {
                    GLFW.glfwSetWindowShouldClose(NobyEngine.this.mWindowHandle, GL11.GL_TRUE);
                } else {
                    Log.d("Key: " + key + " Action: " + action);
                }
            }
        });// Get the resolution of the primary monitor
        ByteBuffer vidmode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        // Center our window
        GLFW.glfwSetWindowPos(this.mWindowHandle, (GLFWvidmode.width(vidmode) - width) / 2, (GLFWvidmode.height(vidmode) - height) / 2);
// Make the OpenGL context current
        GLFW.glfwMakeContextCurrent(this.mWindowHandle);
// Enable v-sync

        GLFW.glfwSwapInterval(1);
// Make the window visible
        GLFW.glfwShowWindow(this.mWindowHandle);

    }

    private void loop() {
// This line is critical for LWJGL's interoperation with GLFW's
// OpenGL context, or any context that is managed externally.
// LWJGL detects the context that is current in the current thread,
// creates the ContextCapabilities instance and makes the OpenGL
// bindings available for use.
        GLContext.createFromCurrent();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glOrtho(-3.2, 3.2, -2.4, 2.4, -1, 1);
// Set the clear color
        GL11.glClearColor(0.05f, 0.05f, 0.05f, 0.0f);
// Run the rendering loop until the user has attempted to close
// the window or has pressed the ESCAPE key.
        long lastTime = System.currentTimeMillis();
        while (GLFW.glfwWindowShouldClose(this.mWindowHandle) == GL11.GL_FALSE) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            final float delta = (System.currentTimeMillis() - lastTime) / 1000f;
            lastTime = System.currentTimeMillis();
            //GL11.glRotatef(rotation,0,1f,0f);

            synchronized (this) {
                if (this.mScene != null) {
                    this.mScene.render(delta);
                }
            }
            GLFW.glfwSwapBuffers(this.mWindowHandle); // swap the color buffers
// Poll for window events. The key callback above will only be
// invoked during this call.
            GLFW.glfwPollEvents();
        }
    }
}
