package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;

public class Ship extends Sprite {
    private TextureAtlas atlas;
    private Rect worldBounds;
    private int damage;
    private int health;
    private Vector2 v = new Vector2();
    private Vector2 v0 = new Vector2();
    private Vector2 vBullet = new Vector2();
    public Ship(TextureAtlas atlas, String name) {
        super(atlas.findRegion(name), 1, 2, 2);
        this.atlas = atlas;

    }
    public void set(float size, int damege, int health, Vector2 v0, Vector2 vBullet){
        setHeightProportion(size);
        this.damage = damege;
        this.health = health;
        this.v0.set(v0);
        this.vBullet.set(vBullet);

    }
    @Override
    public void update(float delta) {
        pos.mulAdd(v0,delta);
        if (isOutside(worldBounds)|| health < 0) {
            destroy();
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
