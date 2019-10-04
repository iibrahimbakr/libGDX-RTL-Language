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
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;
import com.crowni.gdx.rtllang.support.ArFont;
import com.crowni.gdx.rtllang.support.ArUtils;
import com.crowni.gdx.rtllang.utils.BaseScreen;

/**
 * Created by Crowni on 9/14/2017.
 **/
public class TestScreen extends BaseScreen {
    private static final String TAG = TestScreen.class.getSimpleName();

    private static final String ARABIC_LANGUAGE = "اللغة العربية Arabic Languages";
    private static final String INSERT_YOUR_NAME = "أدخل إسمك Insert Your Name";
    private static final String PERSIAN_LANGUAGE = "این متن جهت تست گچپژ می‌باشد.";
    private static final String PERSIAN_COMPLEXT_TEXT = "اتوبوس ۱۲ نفره Bus است!";

    private ArFont arFont = new ArFont();

    @Override
    public void show() {
        super.show();

        Image image = new Image(new Texture("images/arab_wallpaper.png"));
        image.setFillParent(true);
        stage.addActor(image);

        /** FREE TYPE FONT 1 **/
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/jf_flat.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters += ArUtils.getAllChars().toString("");
        parameter.size = 40;
        parameter.color = Color.BROWN;
        parameter.borderColor = Color.GOLD;
        parameter.borderWidth = 1.5f;
        parameter.shadowColor = Color.DARK_GRAY;
        parameter.shadowOffsetX = +5;
        parameter.shadowOffsetY = +5;
        parameter.minFilter = Texture.TextureFilter.Linear;
        parameter.magFilter = Texture.TextureFilter.Linear;

        BitmapFont freeTypeFont = generator.generateFont(parameter);
        Label label = new Label(arFont.getText(ARABIC_LANGUAGE), new Label.LabelStyle(freeTypeFont, Color.WHITE));
        label.layout();
        label.setAlignment(Align.center);
        label.setPosition(512F, 350F, Align.center);
        stage.addActor(label);

        /**
         * BITMAP FONT FONT 1
         **/
//        BitmapFont bitmapFontArabic = new BitmapFont(Gdx.files.internal("fonts/arabic.fnt"));
//        label = new Label(arFont.getText(ARABIC_LANGUAGE), new Label.LabelStyle(bitmapFontJf_flat, Color.WHITE));
//        label.setAlignment(Align.center);
//        label.setPosition(512F + 256F, 400F, Align.right);
//        stage.addActor(label);

        /**
         * BITMAP FONT FONT 2
         **/
        TextArea.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = new BitmapFont(Gdx.files.internal("fonts/jf_flat.fnt"));
        style.fontColor = Color.GOLD;

        TextField textField = new TextField(arFont.getText(INSERT_YOUR_NAME), style);
        textField.setAlignment(Align.right);
        textField.setSize(BaseScreen.WIDTH, 100F);
        textField.setPosition(BaseScreen.WIDTH - 10F, BaseScreen.HEIGHT / 2 - 45F, Align.right);
        stage.addActor(textField);

        textField.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char c) {
                String text = arFont.typing(c);
                textField.setText(text);
            }
        });

        /*
        * Persian test text
         */
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Lalezar.otf"));

        BitmapFont freeTypeFont2 = generator.generateFont(parameter);
        Label persianLabel = new Label(arFont.getText(PERSIAN_LANGUAGE) + "\n" + arFont.getText(PERSIAN_COMPLEXT_TEXT), new Label.LabelStyle(freeTypeFont2, Color.WHITE));
        persianLabel.layout();
        persianLabel.setAlignment(Align.center);
        persianLabel.setPosition(512, 440F, Align.center);
        stage.addActor(persianLabel);

    }
}
