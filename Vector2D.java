package Object;
public class Vector2D {
    float x;
    float y;

    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public double evalModule(){
        return Math.sqrt(this.x*this.x+this.y*this.y);
    }

    public boolean isPerp(Vector2D vector2D){
        return this.x*vector2D.x + this.y*vector2D.y == 0 ? true:false;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
}
