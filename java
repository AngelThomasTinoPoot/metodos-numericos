package metodosnumericos;

import java.util.Scanner;
public class MetodosNumericos {

    public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       int respuesta;
       boolean salir=false;
        
        do{
        System.out.println("         MENU DE LAS ECUACIONES       ");
        System.out.println(" 1: e^x");
        System.out.println(" 2: e^-x");
        System.out.println(" 3: Varianza");
        System.out.println(" 4: Ecuacion cuadratica con 3 metodos diferentes");
        System.out.println(" 5: Salir del programa");
            
        System.out.println("¡Escriba uno de los numeros del menu!");
        respuesta=teclado.nextInt();
         System.out.println("-------------------------------------------------------------------------");
          
            
        switch(respuesta){
            //aqui se realiza la operacion de euler a la x
            case 1:
                System.out.println("calculo de e^x usando su formula igualitaria e^x=∑(n) x^j/j!");
                System.out.println("***************************************************************");
                System.out.println("");
                System.out.println("introduzca X");
                int x1 = teclado.nextInt();
                System.out.println("introduzca j");
                int x2 = teclado.nextInt();
                double suma = 0;
                for (int i = 0; i < x2+1; i++) {
                    suma = suma + Math.pow(x1, i) / (factorial(i));
                }
                System.out.println("");
                System.out.println(" su resultado es: " + suma);
                System.out.println("-----------------------------------------------------------------");
                System.out.println("");
            break;
            
            case 2:
                //aqui se realiza la operacion de euler a la menos x
                System.out.println("e^-x usando su formula igualitaria e^-x=1/∑(n) (x^j/j!)");
                System.out.println("*******************************************************************");
                System.out.println("");
                System.out.println("introduzca X");
                int a1 = teclado.nextInt();
                System.out.println("introduzca j");
                int a2 = teclado.nextInt();
                double suma2 = 0;

                for (int i = 0; i < a2 + 1; i++) {
                    suma2 = suma2 + 1 / (Math.pow(a1, i) / (factorial(i)));
                }
                System.out.println("");
                System.out.println("resultado: " + suma2);
                System.out.println("----------------------------------------------------------------");
                System.out.println("");
            break;
            
            case 3:
               
                double numeros[];
                double summed = 0, varianza, media,sumvar=0;
                System.out.println("calcular la varianza " );
                System.out.println("formula a utlizar: varianza=((x-x̅)^2+(x2-x̅)^2+...+(xn-x̅)^2)/n");
                System.out.println("******************************************************************");
                System.out.println("");
                System.out.println("cuantos numeros quiere agregar?");
                int datos = teclado.nextInt();
               
                numeros = new double[datos];
                for (int i = 0; i < datos; i++) {
                    numeros[i] =Math.random();                 
                }
                for (int i = 0; i < datos; i++) {
                    summed += numeros[i];
                }
                media = summed / datos;           
                for (int i = 0; i < datos; i++) {               
                   sumvar+=Math.pow(numeros[i]-media, 2);
                }
                varianza=sumvar/datos;       
                System.out.println("la varianza es: "+varianza); 
                System.out.println("----------------------------------------------------------------");
                System.out.println("");
            break;
            
            case 4:
        //aqui se realiza la operacion de una ecuasion cuadratica por 3 metodos diferentes, formula general, metodo de po-shen loh y formula general a la inversa
                double a,b,c,igual;
                System.out.println("Ecuacion cuadratica por 3 metodos diferentes");
                System.out.println("primer metodo: Formula general");
                System.out.println("segundo metodo: Po-Shen Loh");
                System.out.println("Tercer metodo: Formula general a la inversa");
                System.out.println("********************************************");
                System.out.println("");
                System.out.println("Ingresa el valor de a(x^2)");
                a=teclado.nextDouble();
                System.out.println("Ingresa el valor de b(x)");
                b=teclado.nextDouble();
                System.out.println("Ingresa el valor de c(termino independiente)");
                c=teclado.nextDouble();
                System.out.println("");
                
                System.out.println("Formula general:");
                FormulaGeneral(a,b,c);
                System.out.println("");
                
                System.out.println("Metodo de Po-Shen Loh");
                PoShenLoh(a,b,c);
                System.out.println("");
                
                System.out.println("Formula General a la Inversa");
                FormulaGeneralInversa(a,b,c);
                System.out.println("----------------------------------------------------------------");
                System.out.println("");
            break;
            
            case 5:
                salir=true;
                System.out.println("¡Gracias por utilizar este programa, vuelva pronto!");
            break;
            default:
                System.out.println("Este numero no se encuentra en el menu");
                System.out.println("favor de ingresar nuevamente el numero correcto");
                System.out.println("---------------------------------------------------------------");
                System.out.println("");
            break;
        }
        }while(salir!=true);
       
    }
    
    
    
    
    
    
    
    public static boolean discriminante(double a,double b,double c){
        double discriminante;
        discriminante=(Math.pow(b,2))-(4*(a)*(c));
        if(discriminante<0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void FormulaGeneral(double a,double b,double c){
        double ac,x1,x2;
        ac=(Math.pow(b,2))-(4*(a)*(c));
        if(discriminante(a,b,c)==true){
            System.out.println("NO TIENE SOLUCION");
        }
        else{
            x1=(-(b)+Math.sqrt(ac))/(2*(a));
            x2=(-(b)-Math.sqrt(ac))/(2*(a));
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);
        }
    }
    public static void PoShenLoh(double a,double b,double c){
        if(discriminante(a,b,c)==true){
            System.out.println("NO TIENE SOLUCION");
        }
        else{
            double b1=b/a;
            double c1=c/a;
            double p=-(b1)/2;
            double u=Math.sqrt((c1-(Math.pow(p, 2)))*-1);
            double x1=p+u;
            double x2=p-u;
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);  
        }
        
    }
    public static int factorial (int numero) {
        double factorial;
        if (numero==0)
        return 1;
        else
        return numero * factorial(numero-1);
    }
    
    public static void FormulaGeneralInversa(double a,double b,double c){
        if(discriminante(a,b,c)==true){
            System.out.println("NO TIENE SOLUCION");
        }
        else{
            double x1=(-2*c)/(b+(Math.sqrt(Math.pow(b,2)-(4*a*c))));
            double x2=(-2*c)/(b-(Math.sqrt(Math.pow(b,2)-(4*a*c))));
            System.out.println("x1="+x1);
            System.out.println("x2="+x2);    
        }
        
    }
    
}
