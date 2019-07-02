
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class variablesAleatorias_normal {
 static JFreeChart Grafica;
    static DefaultCategoryDataset Datos = new DefaultCategoryDataset();

    public static void main(String[] args) {
        int numVariables = 100;
        double numeros[] = new double[numVariables];
        //Llenar Matriz
        for (int i = 0; i < numVariables; i++) {
            numeros[i] = Math.random();
        }

        //media
        double data[] = new double[numVariables];
        double prom = 0;
        int contador2 = 0;
        for (int i = 0; i < numVariables; i++) {
            prom += numeros[i];
            contador2++;

        }
        double media = prom / (double) (numVariables);
        System.out.println("Media = " + media);
        //desviación
        double sum = 0;
        for (int i = 0; i < numVariables; i++) {
            sum += Math.pow(numeros[i] - media, 2);
        }
        double varianza = Math.sqrt(sum / (double) (numVariables));
        System.out.println("Mediana = " + mediana(numeros));
        System.out.println("varianza = " + varianza);
        double desviacion = Math.sqrt(varianza);
        System.out.println("Desviación = " + desviacion);

        for (int i = 0; i < numVariables; i++) {
            numeros[i] = (numeros[i]-media)/desviacion;
            System.out.println(numeros[i]);
            Datos.addValue(numeros[i], "Uniforme", ""+String.valueOf(i));
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
        
        
    }

    public static double[] burbuja(double[] v, int ord) {
        int i, j, n = v.length;
        double aux = 0;

        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if (ord == 0) {
                    if (v[i] > v[j]) {
                        aux = v[j];
                        v[j] = v[i];
                        v[i] = aux;
                    }
                }
            }
        }
        return v;
    }

    public static double mediana(double[] v) {
        int pos = 0, n = v.length;
        int temp = 0, temp0 = 0;
        v = burbuja(v, 0);
        temp = n / 2;
        return v[temp];
    }
}
