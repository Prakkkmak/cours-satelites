package com.prakkmak;

public class Vector2 {
    private int x;
    private int y;

    public Vector2(){
        x = 0;
        y = 0;
    }

    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(Vector2 vector2){
        return Math.sqrt((this.x - vector2.x) * (this.x - vector2.x) + (this.y - vector2.y) * (this.y - vector2.y));
    }

    public void translate(Vector2 v2){
        this.setX(this.getX() + v2.getX());
        this.setY(this.getY() + v2.getY());
    }

    public Vector2 mul(int val){
        return new Vector2(x * val, y * val);
    }

    public static Vector2 Left = new Vector2(-1, 0);
    public static Vector2 Right = new Vector2(1, 0);
    public static Vector2 Up = new Vector2(0, 1);
    public static Vector2 Down = new Vector2(0, -1);

}
