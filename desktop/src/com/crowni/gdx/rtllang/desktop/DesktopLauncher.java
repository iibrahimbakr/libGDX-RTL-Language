package com.crowni.gdx.rtllang.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.crowni.gdx.rtllang.Test.Begin;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "RTL Languages Test";
        config.width = 1024;
        config.height = 534;
        new LwjglApplication(new Begin(), config);
    }
}
