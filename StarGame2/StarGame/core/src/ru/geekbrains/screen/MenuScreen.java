package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    private SpriteBatch batch;
    private Texture img;
    private Vector2 touch;
    private Vector2 pos;
    private Vector2 v;
    private boolean tch;
    private int key;
    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0, 0);
        touch = new Vector2();
        v = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.51f, 0.34f, 0.64f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
        pos.add(v);
        if(tch){
            v.set(touch.cpy().sub(pos));
            v.nor();
            tch = false;
        }
        if(touch.cpy().sub(pos).len() < v.len()){
            pos.set(touch);
            v.setZero();
        }
        switch (key){
            case 19: pos.add(0,1);
                     break;
            case 20: pos.add(0,-1);
                     break;
            case 21: pos.add(-1,0);
                     break;
            case 22: pos.add(1,0);
                     break;
        }
    }
    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        tch = true;
        System.out.println("touch x = " + touch.x + " touch.y = " + touch.y);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean keyDown(int keycode) {
        key = keycode;
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        key =0;
        return super.keyUp(keycode);
    }
}
