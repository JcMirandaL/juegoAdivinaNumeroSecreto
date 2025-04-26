
//Algoritmo juego adivina el numero secreto, con metodos y generando el #secreto con ramdon de 0 a 100
//Autor: Julio miranda
//FechaMod: 8/4/2025

import java.util.Random;
import java.util.Scanner;

public class juegoAdivnRamdMetod {
    
    //calse para poder leer los datos
    static Scanner scan = new Scanner(System.in);
    //calse para poder leer los datos aleatorios
    static Random random = new Random();

    public static void main(String[] args) {

        //declaro e inicio variable
        int opcion = 0;

        //imprime msjs
        System.out.println("BIENVENIDO AL JUEGO ADIVINA EL NUMERO SECRETO");
        System.out.println("");
        System.out.println("<======================= MENU PRINCIPAL ========================>");
        System.out.println("1. JUGAR");
        System.out.println("2. SALIR");

        //BUCLE PARA obligar a digitar opcion valida
        do {
            //solicito datos
            System.out.println("Digite la opcion deseada");
            //los leo y almaceno
            opcion = scan.nextInt();
        //case para que entre a la opcion digitada    
        switch (opcion) {
            case 1:
            //llamo al metodo jugar, y vaya a hacer lo que tenga que hacer
                jugar();
                break;
            case 2:
                //imprime msj
                System.out.println("¡GRACIAS TE ESPERAMOS DE VUELTA PRONTO!"); 
                System.out.println("");   
                break;
            default:
                //si la opc no es 1 ni 2 imprime msj
                System.out.println("Digite una opcion valida");
                break;
            }

        //si la opc no es 1 ni 2 repita    
        } while (opcion < 1 || opcion > 2);
        
    //Cierre del main    
    }
    
    //metodo dnd empieza el juego
    public static void jugar() {
        
        //declaro einicio variable
        int num = 0, volverJugar = 0;

        //bucle para repetir si quiere volver a jugar
        do {
            //declaro variable para resivir metodos
            int numeroSecreto;
            boolean ganar;
    
            //declaro e inicio variables
            int intentos = 10;
            int totIntentos = 0;
            boolean gano = false;

            //llamo almetodo metodo generarNumeroAleatorio y lo recibo en numeroSecreto
            numeroSecreto = generarNumeroAleatorio();

            //bucle para repetir si el numero es mas bajo o alto
            do {
                //resto intentos y sumo totIntentos en 1 x vuelta
                intentos--;
                totIntentos++;
                //bucle para obligar a digitar #s entre 0 a 100
                do {
                    //impresion
                    System.out.println("---------------------------------------------");
                    //solcito datos de entrada
                    System.out.println("Digite un numero para adivinar el numero secreto (De 0 a 100)");
                    //los leo
                    num = scan.nextInt();

                    //valido si el num no esta entre 0 y 100
                    if (num > 100 || num < 0) {
                        //imprime msj
                        System.out.println("Digite un numero valido, ¡Vuelva a intentar!");
                    }
                //si el num no esta entre 0 y 100, repita    
                } while (num > 100 || num < 0);

                //llamo al metod validar numero para que haga lo que tenga que hacer
                verificarNumeroSecretoEsMayorMenor(numeroSecreto, num);
                //llamo al metodo y lo recibo en ganar
                ganar = validarGane(numeroSecreto, num, gano);
                //llamo al metodo para que haga lo que tenga que hacer
                mostrarResultados(totIntentos, intentos, ganar, numeroSecreto);

            //si el numero es diferente del numero secreto repita    
            } while (!ganar && totIntentos < 10);

            //pregunta al usuario
            System.out.println("¿Desea vovlver a jugar? (1.Si 2.No)");
            //leo resp
            volverJugar = scan.nextInt();
        //si volverJugar es 1, repita
        } while (volverJugar == 1);
     
    //cierre del metodo jugar()    
    }

    //metodo para generar el numero secreto
    public static int generarNumeroAleatorio(){

        //declaro variable y la inicializo en ramdom de 1 a 100 para generar el numSecreto
        int numSecreto = random.nextInt(100)+1;

        //devuelve el numero generado aleatoriamente
        return numSecreto;
    
    //cierre del metdod generarNumeroAleatorio()    
    }

    //metodo para validar si es mas alto o bajo que el numero secreto, en parametros llamo a numeroSecreto y num
    public static void verificarNumeroSecretoEsMayorMenor(int numeroSecreto, int num){

        //valido si el numSecreto es mayor menor o igual segun sea el caso asi imprime msjs
        if (numeroSecreto > num) {
            //imprimo msjs
            System.out.println("El numero Secreto es más alto ¡Vuelve a Intentar!");

        }else if (numeroSecreto < num){
            //imprimo msjs
            System.out.println("El numero Secreto es más bajo ¡Vuelve a Intentar!");
        }

    //cierre del metodo verificarNumeroSecretoEsMayorMenor()    
    }

    //metodo para validar gane
    public static boolean validarGane(int numeroSecreto, int num, boolean gano){
        
        //valido si num es igual al #Secreto
        if (numeroSecreto == num) {
            //actualizo el boolean
            gano = true;
            //lo retorna en true
            return gano;
        }

        //si no, retorna falso
        return gano;    
    //cierre del metodo validarGane()    
    }


    //metodo para mostrar resultados
    public static void mostrarResultados(int totIntentos, int intentos, boolean ganar, int numeroSecreto){

        //valido para saber si no gano, haga
        if (!ganar){
            System.out.println("Te quedan " +intentos+ " intentos");
        //Sino, si gano, haga aqui
        }else if (ganar = true) {
            //imprime
            System.out.println("¡FELICIDADES! Has adivinado el numero. SI era el "+numeroSecreto);
            System.out.println("Total de intentos usados: " +totIntentos);
        
        }

        //valido si se quedo sin intentos, haga
        if (intentos == 0){
            System.out.println("¡GAME OVER! No te quedan intentos, el numero secreto era: "+numeroSecreto);
        }
     
    //cierre del metodo mostrarResultados()    
    }

//Cierre del algoritmo    
}
