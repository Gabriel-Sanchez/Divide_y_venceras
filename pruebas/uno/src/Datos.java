import java.util.Arrays;
import java.util.Random;

public class Datos {
public static final int MAX = 1000000;
private static final Random RANDOM;
private static final int[] datosAleatorios;
private static final int[] datosPrueba;
private final int N;
static {
    RANDOM = new Random();
    datosAleatorios = new int[MAX];
    for (int i = 0; i < MAX; i++)
        datosAleatorios[i] = RANDOM.nextInt();
    datosPrueba = new int[MAX];
}

public Datos(int N) {
    this.N = N;
    int n0 = RANDOM.nextInt(MAX - N);
    System.arraycopy(datosAleatorios, n0, datosPrueba, 0, N);
}

public void algoritmo() {
    Arrays.sort(datosPrueba, 0, N);
}
}