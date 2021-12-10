import java.util.Random;
import Object.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        Vector2D[] vector2ds = new Vector2D[10];
        float x, y, z, c;
        for (int i = 0; i<10; i++){
            c = random.nextInt(1);
            if (c == 1){
                x = random.nextInt(10);
                y = random.nextInt(10);
                vector2ds[i] = new Vector2D(x, y);
            }else {
                x = random.nextInt(10);
                y = random.nextInt(10);
                z = random.nextInt(10);
                vector2ds[i] = new Vector3D(x,y,z);
            }
        }
        for (int i = 0; i < 10; i++){
            if (vector2ds[i] instanceof Vector3D){
                System.out.println("Vector 3D thu "+i+" co do dai la: "+((Vector3D)vector2ds[i]).evalModule());
            } else {
                System.out.println("Vector 2D thu "+i+" co do dai la: "+((Vector2D)vector2ds[i]).evalModule());
            }
        }
        System.out.println("Cac cap vector truc giao : ");
        for (int i = 0; i<10-1; i++){
            for (int j = i+1; j<10; j++){
                if (vector2ds[i] instanceof Vector2D && vector2ds[j] instanceof Vector3D){
                    if (((Vector2D)vector2ds[i]).isPerp((Vector2D)vector2ds[j]))
                    System.out.println("Vecto 2D thu :"+i+" va Vecto "+j);
                }else if (vector2ds[i] instanceof Vector3D && vector2ds[j] instanceof Vector3D){
                    if (((Vector3D)vector2ds[i]).isPerp((Vector3D)vector2ds[j]))
                    System.out.println("Vecto 3D thu :"+i+" va Vecto "+j);
                }
            }
        }
    }
}
