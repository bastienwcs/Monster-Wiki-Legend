package fr.monsterwikilegend;

/**
 * Created by romain on 16/09/16.
 */
public class SkillSet {
    private int life;
    private int strength;
    private int speed;
    private int stamina;

    public SkillSet(int life, int strength, int speed, int stamina) {
        this.life = life;
        this.strength = strength;
        this.speed = speed;
        this.stamina = stamina;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
}
