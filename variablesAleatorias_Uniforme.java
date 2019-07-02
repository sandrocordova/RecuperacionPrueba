
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
public class variablesAleatorias_Uniforme {

    static JFreeChart Grafica;
    static DefaultCategoryDataset Datos = new DefaultCategoryDataset();

    public static void main(String[] args) {
        int numVariables = 100;
        double numeros[] = new double[numVariables];
        //Llenar Matriz
        for (int i = 0; i < numVariables; i++) {
            numeros[i] = Math.random();
        }

        //Aleatorios con distribución uniforme distribuidas entre cero y uno
        int a = 0;
        int b = 1;
        for (int i = 0; i < numVariables; i++) {
            numeros[i] = a + (b - a) * numeros[i];
            
        }

        //Elaborando los intervalos 
        double yaux[] = new double[5];
        double aux = 0;
        for (int i = 0; i < yaux.length; i++) {
            aux += 0.2;
            yaux[i] = aux;
        }

        int y[] = new int[5];
        int contador = 0;
        int carry = 0;
        int total = 0;
        for (int i = 0; i < y.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                if (i == 0) {
                    if (numeros[j] < yaux[i]) {
                        contador++;
                    }
                }else
                if (numeros[j] < yaux[i]&&numeros[j] > yaux[i-1]) {
                    contador++;
                }
            }
            y[i] = contador - carry;
            carry = contador;
            total += contador;
            //System.out.println("Cuando " + yaux[i] + " hay datos " + y[i]);
            System.out.println(yaux[i]+" = "+y[i]);
            Datos.addValue(y[i], "Uniforme", ""+String.valueOf(yaux[i]));
        }
        System.out.println("Total = " + carry);
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
        System.out.println("Mediana = "+mediana(numeros));
        double varianza = Math.sqrt(sum / (double) (numVariables));
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
