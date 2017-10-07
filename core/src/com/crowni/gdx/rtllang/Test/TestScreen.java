/*
 * *****************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.crowni.gdx.rtllang.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;
import com.crowni.gdx.rtllang.arabic.ArFont;
import com.crowni.gdx.rtllang.utils.BaseScreen;

/**
 * Created by Crowni on 9/14/2017.
 **/
public class TestScreen extends BaseScreen {
    private static final String TAG = TestScreen.class.getSimpleName();

    private static final String ARABIC_LANGUAGE = "اللغة العربية";
    private static final String INSERT_YOUR_NAME = "أدخل إسمك";
    private Label label;

    private ArFont arFont = new ArFont();

    @Override
    public void show() {
        super.show();

        Image image = new Image(new Texture("images/arab_wallpaper.png"));
        image.setFillParent(true);
        stage.addActor(image);

        BitmapFont fontJf_flat = new BitmapFont(Gdx.files.internal("fonts/jf_flat.fnt"));
        label = new Label("", new Label.LabelStyle(fontJf_flat, Color.WHITE));
        label.setAlignment(Align.center);
        label.setPosition(512F, 400F, Align.right);
        label.setText(arFont.getText(ARABIC_LANGUAGE));
        stage.addActor(label);

        BitmapFont fontArabic = new BitmapFont(Gdx.files.internal("fonts/arabic.fnt"));
        TextArea.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = fontArabic;
        style.fontColor = Color.GOLD;
        TextField textField = new TextField(arFont.getText(INSERT_YOUR_NAME), style);
        textField.setAlignment(Align.right);
        textField.setSize(BaseScreen.WIDTH, 100F);
        textField.setPosition(BaseScreen.WIDTH - 10F, BaseScreen.HEIGHT / 2 - 30F, Align.right);
        stage.addActor(textField);

        textField.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char c) {
                String text = arFont.typing(c);
                textField.setText(text);
            }
        });
    }
}
