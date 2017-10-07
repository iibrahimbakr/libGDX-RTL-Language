# RTL-Language Test in libGDX
This is a simple project can be render RTL language correctly using `BitmapFont` and `FreeType`:
* **Arabic Test**

![](https://media.giphy.com/media/26FfbTemBGnNneLM4/giphy.gif)

***
### 1. Using `BitmapFont`
1. Open `Hiero.jar`.
2. Put any freetype font `.ttf` , `.otf` which support RTL languages into `Hiero.jar`.
3. Add RTL letters in `Hiero`.
4. Save it as `.fnt` file and import it into assets folder in your project.

* **Example**
1. RTL letters:
> ء
> آ
> أ
> ؤ
> إ
> ئ
> ا
> ب
> ة
> ت
> ث
> ج
> ح
> خ
> د
> ذ
> ر
> ز
> س
> ش
> ص
> ض
> ط
> ظ
> ع
> غ
> ـ
> ف
> ق
> ك
> ل
> م
> ن
> ه
> و
> ى
> ي
> ً
> ٌ
> ٍ
> َ
> ُ
> ِ
> ّ
> ْ
> ٓ
> ٔ
> ٕ
> ٠
> ١
> ٢
> ٣
> ٤
> ٥
> ٦
> ٧
> ٨
> ٩
> ٪
> ٫
> ٬
> ٭
> ٰ
> ﱟ
> ﱠ
> ﱡ
> ﴾
> ﴿
> ﷲ
> ﺀ
> ﺁ
> ﺂ
> ﺃ
> ﺄ
> ﺅ
> ﺆ
> ﺇ
> ﺈ
> ﺉ
> ﺊ
> ﺋ
> ﺌ
> ﺍ
> ﺎ
> ﺏ
> ﺐ
> ﺑ
> ﺒ
> ﺓ
> ﺔ
> ﺕ
> ﺖ
> ﺗ
> ﺘ
> ﺙ
> ﺚ
> ﺛ
> ﺜ
> ﺝ
> ﺞ
> ﺟ
> ﺠ
> ﺡ
> ﺢ
> ﺣ
> ﺤ
> ﺥ
> ﺦ
> ﺧ
> ﺨ
> ﺩ
> ﺪ
> ﺫ
> ﺬ
> ﺭ
> ﺮ
> ﺯ
> ﺰ
> ﺱ
> ﺲ
> ﺳ
> ﺴ
> ﺵ
> ﺶ
> ﺷ
> ﺸ
> ﺹ
> ﺺ
> ﺻ
> ﺼ
> ﺽ
> ﺾ
> ﺿ
> ﻀ
> ﻁ
> ﻂ
> ﻃ
> ﻄ
> ﻅ
> ﻆ
> ﻇ
> ﻈ
> ﻉ
> ﻊ
> ﻋ
> ﻌ
> ﻍ
> ﻎ
> ﻏ
> ﻐ
> ﻑ
> ﻒ
> ﻓ
> ﻔ
> ﻕ
> ﻖ
> ﻗ
> ﻘ
> ﻙ
> ﻚ
> ﻛ
> ﻜ
> ﻝ
> ﻞ
> ﻟ
> ﻠ
> ﻡ
> ﻢ
> ﻣ
> ﻤ
> ﻥ
> ﻦ
> ﻧ
> ﻨ
> ﻩ
> ﻪ
> ﻫ
> ﻬ
> ﻭ
> ﻮ
> ﻯ
> ﻰ
> ﻱ
> ﻲ
> ﻳ
> ﻴ
> ﻵ
> ﻶ
> ﻷ
> ﻸ
> ﻹ
> ﻺ
> ﻻ
> ﻼ
2. Code
``` java
ArFont arFont = new ArFont();
arFont.getRTLText("string");         // arabic text putting as a parameter to return correct RTL string.
arFont.typing('char');               // type arabic letter by letter.
```

***
### 2. Using `FreeType`
``` java
FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/jf_flat.ttf"));
FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        
parameter.characters += ArUtils.getAllChars().toString(""); // Arabic characters addition to exist characters.
parameter.size = 48;
parameter.color = Color.BROWN;
parameter.borderColor = Color.GOLD;
parameter.borderWidth = 1.5f;
parameter.minFilter = Texture.TextureFilter.Linear;
parameter.magFilter = Texture.TextureFilter.Linear;

BitmapFont freeTypeFont = generator.generateFont(parameter);
```

**That's it**
