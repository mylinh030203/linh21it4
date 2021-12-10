package Object;
public class Vector3D extends Vector2D {
    float z;

    public Vector3D(){
        super();
        this.z = 0;
    }

    public Vector3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public boolean isPerp(Vector3D vector3D){
        return this.x*vector3D.x + this.y*vector3D.y == 0 + this.z*vector3D.z? true:false;
    }

    public double evalModule(){
        return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
    }
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }


}
