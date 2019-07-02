
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sandro Córdova
 */
public class variablesAleatorias_binomial {

    static JFreeChart Grafica;
    static DefaultCategoryDataset Datos = new DefaultCategoryDataset();

    public static void main(String[] args) {

        //Total de variables a crear 
        int variables = 100;
        //n = 5 n = total de número aleatorios que se crearán por intervalo,
        int n = 5;
        //en esta ocasión se hará con 100 intervalos de 5 números aleatorios cada uno
        //p = 0.2 la probabilidad de que dicho evento se dé
        double p = 0.2;
        //Crear Matríz
        double numeros[][] = new double[variables][n];
        //Llenar Matriz
        for (int i = 0; i < variables; i++) {
            //String fila = "";
            for (int j = 0; j < n; j++) {
                numeros[i][j] = Math.random();
                //fila +=numeros[i][j]+" ";
            }
            //System.out.println(fila);
        }

        int arregloP[] = new int[variables];
        ArrayList<Integer> y = new ArrayList<Integer>();

        int contP = 0;
        //recolectar aquellos datos que están dentro de la probabilidad P 
        for (int i = 0; i < variables; i++) {
            //String fila = "";
            for (int j = 0; j < n; j++) {
                if (numeros[i][j] < p) {
                    contP++;
                }
                //fila +=numeros[i][j]+" ";
            }
            //contiene los cúmeros que e stán dentro de la probabilidad
            arregloP[i] = contP;
            if (!y.contains(contP)) {
                y.add(contP);
            }
            contP = 0;
            //System.out.println(fila);
        }
        //numero mayor
        int tamaño = y.size();
        int x[] = new int[tamaño];
        int aux = 0;
        int total = 0;
        System.out.println("Casos posibles y su frecuencia: ");
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < arregloP.length; j++) {
                if (i == arregloP[j]) {
                    aux++;
                }
            }
            x[i] = aux;
            total += aux;
            System.out.println(i + " = " + aux);
            Datos.addValue(aux, "Binomial", String.valueOf(i));

            aux = 0;
        }

        Grafica = ChartFactory.createBarChart("Histograma",
                "X", "Y", Datos,
                PlotOrientation.VERTICAL, true, true, false);
        ChartPanel Panel = new ChartPanel(Grafica);
        JFrame Ventana = new JFrame("JFreeChart");
        Ventana.getContentPane().add(Panel);
        Ventana.pack();
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //media
        double data[] = new double[variables*n];
        double prom = 0;
        int contador = 0;
        for (int i = 0; i < variables; i++) {
            for (int j = 0; j < n; j++) {
                data[contador] = numeros[i][j];
                prom += numeros[i][j];
                contador++;
            }
        }
        double media = prom / (double) (variables * n);
        System.out.println("Media = " + media);
        //desviación
        double sum = 0;
         for (int i = 0; i < variables; i++) {
            for (int j = 0; j < n; j++) {
                 sum += Math.pow(numeros[i][j] - media, 2);
            }
        }
        System.out.println("Mediana = "+mediana(data));
        double varianza = Math.sqrt(sum / (double) (variables*n));
        System.out.println("varianza = " + varianza);
        double desviacion = Math.sqrt(varianza);
        System.out.println("Desviación = " + desviacion);
        
    }
    
    public static double [ ] burbuja ( double [ ] v, int ord ) {
    int i, j, n = v.length;
    double aux = 0;
    
    for ( i = 0; i < n - 1; i++ )
      for ( j = i + 1; j < n; j++ )
        if ( ord == 0 )
          if ( v [ i ] > v [ j ] ) {
            aux = v [ j ];
            v [ j ] = v [ i ];
            v [ i ] = aux;
          }
    return v;
  }
    public static double mediana ( double [ ] v ) {
    int pos = 0, n = v.length;
    int temp = 0, temp0 = 0;    
    v = burbuja ( v, 0 );
    temp = n / 2;
    return v[temp];
  }

}
