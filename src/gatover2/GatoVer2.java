/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatover2;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.Scanner;

/**
 *
 * @author Santiago
 */
public class GatoVer2 {
    public static int TamTablero=3;
    public int TableroP[][];
    int Depth=1;
    boolean changedPlayer;

       public GatoVer2(int[][] Tablero){
        TableroP=Tablero;
        changedPlayer=false;
        while(!JuegoTerminado(TableroP) && (EsGanador(TableroP)!=1 &&  EsGanador(TableroP)!=2) )
        {
            LeerNumeros();
            if ((EsGanador(TableroP)!=1 &&  EsGanador(TableroP)!=2) && changedPlayer && !JuegoTerminado(TableroP)) {
                minMAX(TableroP);
            }
            ImprimirTablero(TableroP);
        }
    }
       public boolean JuegoTerminado(int m[][])
    {
        for (int i = 0; i < TamTablero; i++) {
            for (int j = 0; j < TamTablero; j++) {
                if (m[i][j]  ==0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
         int Tablero[][];
        Tablero= new int[TamTablero][TamTablero];
        
        for (int i = 0; i < TamTablero; i++) {
            for (int j = 0; j < TamTablero; j++) {
                Tablero[i][j]=0;
            }
        }
        System.out.println("Instrucciones");
        System.out.println("El tablero esta dividido en nueve secciones");
        System.out.println("1|2|3");
        System.out.println("4|5|6");
        System.out.println("7|8|9");
        System.out.println("Introduce un numero del 1 al 9 y pulsa enter para marcar la casilla que deseas");
        new GatoVer2(Tablero);
    }
    
    private void LeerNumeros() {
        Scanner leer= new Scanner(System.in);
        int i=0,j=0;
        boolean ver=true;
        System.out.println("Introduce la casilla que deseas marcar");
      do {
       
        int valor;
        valor=leer.nextInt();
            switch (valor)
               {
                   case 1 -> {
                       if (TableroP[0][0]==0) {
                           TableroP[0][0]=1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   case 2 -> {
                       if (TableroP[0][1]==0 ) {
                           TableroP[0][1] =1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   case 3 -> {
                       if (TableroP[0][2]==0 ) {
                           TableroP[0][2]=1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   case 4 -> {
                       if (TableroP[1][0]==0 ) {
                           TableroP[1][0]=1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   case 5 -> {
                       if (TableroP[1][1]==0) {
                           TableroP[1][1]=1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   case 6 -> {
                       if (TableroP[1][2]==0 ) {
                           TableroP[1][2]=1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   case 7 -> {
                       if (TableroP[2][0]==0) {
                           TableroP[2][0] =1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   case 8 -> {
                       if (TableroP[2][1]==0 ) {
                           TableroP[2][1]=1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   case 9 -> {
                       if (TableroP[2][2]==0 ) {
                           TableroP[2][2]=1;
                           ver = false;
                       }else
                       {
                           System.out.println("Selecciona otra casilla esta ya fue marcada");
                       }
                }
                   default -> {
                       System.out.println("Valor ingresado no contenido en la tabla");
                       ver = true;
                }
               }
           } while (ver);
       changedPlayer=true; 
    }

    private int EsGanador(int m[][]) {
        
        for (int i = 0; i < TamTablero; i++) {
            for (int j = 0; j < TamTablero; j++) {
                if (j + 2<TamTablero) {
                    if (m[i][j] == 1 &&  m[i][j+ 1] == 1 && m[i][j+ 2]==1) {
                        return 1;
                    }
                }
                if (i + 2<TamTablero) {
                    if (m[i][j]    == 1 &&  m[i + 1][j]== 1 && m[i+ 2][j]==1) {
                        return 1;
                    }
                }
                if (i + 2 < TamTablero && j + 2<TamTablero) {
                    if (m[i][j] == 1 &&  m[i + 1][j + 1] == 1 && m[i + 2][j + 2]==1) {
                        return 1;
                    }
                }
                if (i - 3 > -1 && j + 3<TamTablero) {
                    if (m[i][j]    == 1 &&  m[i - 1][j + 1] == 1 && m[i - 2][j + 2]==1) {
                        return 1;
                    }
                }
                if (i + 2 < TamTablero && j - 2 > -1) {
                    if (m[i][j]  == 1 &&  m[i + 1][j - 1]== 1 && m[i + 2][j - 2]==1) {
                        return 1;
                    }
                }
                 if (j + 2<TamTablero) {
                    if (m[i][j]    == 2 &&  m[i][j + 1] == 2 && m[i][j + 2]==2) {
                        return 2;
                    }
                }
                 if (i + 2<TamTablero) {
                    if (m[i][j]    == 2 &&  m[i+ 1][j] == 2 && m[i + 2][j]==2) {
                        return 2;
                    }
                }
                 if (i + 2 < TamTablero && j + 2<TamTablero) {
                     if (m[i][j]  == 2 &&  m[i + 1][j + 1] == 2 && m[i + 2][j + 2]==2) {
                        return 2;
                    }
                }
                 if (i - 2 > -1 && j + 2<TamTablero) {
                    if (m[i][j]    == 2 &&  m[i - 1][j + 1]== 2 && m[i - 2][j + 2]==2) {
                        return 2;
                    }
                }
                 if (i + 2 < TamTablero && j -+ 2 > -1) {
                    if (m[i][j]    == 2 &&  m[i + 1][j - 1] == 2 && m[i + 2][j - 2]==2) {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }
    
    private void ImprimirTablero(int m[][]) {
        System.out.println("");
        System.out.println("");
        if (EsGanador(m)==1) {
            System.out.println("El jugador es el ganador");
          
        }
        if (EsGanador(m)==2) {
            System.out.println("La AI es la ganador");
             
        }
         for (int i = 0; i < TamTablero; i++)
            {
                if (i != 0)
                {
                    System.out.println("");
                    System.out.println("   " + "--|---|--");
                }

                for (int j = 0; j < TamTablero; j++)
                {
                    if (j == 2)
                    {
                        System.out.print(m[i][j]   );
                    }
                    else if (j == 0)
                    {
                        System.out.print("   " + m[i][j]    + " | ");
                    }
                    else
                    {
                       System.out.print(m[i][j]    + " | ");
                    }

                }
            }
            System.out.println("");
    }
    
    private void minMAX(int[][] m) {
        int MejorFila = -1,MejorColumna = -1;
        int max,maxActual;
        max= Integer.MIN_VALUE;
      for (int i = 0; i < TamTablero; i++) {
            for (int j = 0; j < TamTablero; j++) {
                if (m[i][j]  == 0) {
                    int tempFila,tempColum;
                    m[i][j] =2;
                    tempFila=i;
                    tempColum=j;
                   maxActual= ValorMin(m,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
                   m[tempFila][tempColum]=0;
                    if (max < maxActual) {
                        max= maxActual;
                        MejorFila=tempFila;
                        MejorColumna=tempColum;
                    }
                }
            }
        }
      m[MejorFila][MejorColumna]=2;
      changedPlayer=false;
    }
    public int ValorMin(int[][] m, int deph, int alpha, int beta)
    {
        if (EsGanador(m)==1 || EsGanador(m)==2) {
            return Heuristica(m);
        }else if (JuegoTerminado(m))
        {
             return Heuristica(m);
        }else if (Depth<deph)
        {
            return Heuristica(m);
        }else
        {
            for (int i = 0; i < TamTablero; i++) {
            for (int j = 0; j < TamTablero; j++) {
                if (m[i][j]  == 0) {
                    int tempFila,tempColum;
                    m[i][j] =1;
                    tempFila=i;
                    tempColum=j;
                   beta= min(beta,ValorMax(m,deph+1,alpha,beta));
                   m[tempFila][tempColum]=0;
                    if (alpha >= beta) {
                        return alpha;
                    }
                }
            }
          }
             return beta;
       }
    }
    public int ValorMax(int[][] m, int deph, int alpha, int beta)
    {
         if (EsGanador(m)==1 || EsGanador(m)==2) {
            return Heuristica(m);
        }else if (JuegoTerminado(m))
        {
             return Heuristica(m);
        }else
        {
                for (int i = 0; i < TamTablero; i++) {
                     for (int j = 0; j < TamTablero; j++) {
                         if (m[i][j]  == 0) {
                             int tempFila,tempColum;
                             m[i][j] =2;
                             tempFila=i;
                             tempColum=j;
                            alpha= max(alpha,ValorMin(m,deph+1,alpha,beta));
                            m[tempFila][tempColum]=0;
                             if (alpha >= beta) {
                                 return beta;
                             }
                         }
                     }
                 }
                 return alpha;
       }
    }
    public int Heuristica(int[][] m)
    {
        int costo;
        costo=Costo(m,2)-Costo(m,1);
        return costo;
    }
    public int Costo(int[][] m,int player)
    {
        int value=0;
        for (int i = 0; i < TamTablero; i++) {
            for (int j = 0; j < TamTablero; j++) {
                if (j + 2 < TamTablero) {
                    if (m[i][j]    == player && m[i][j + 1] == player && m[i][j + 2] == player) {
                       return 500; 
                    }
                }
                if (i + 2 < TamTablero) {
                    if (m[i][j]    == player && m[i + 1][j] == player && m[i + 2][j] == player) {
                       return 500; 
                    }
                }
                if (i + 2 < TamTablero && j + 2 < TamTablero) {
                    if (m[i][j]    == player && m[i + 1][j + 1] == player && m[i + 2][j + 2] == player) {
                       return 500; 
                    }
                }
                if (i - 2 > -1 && j + 2 < TamTablero) {
                    if (m[i][j]    == player && m[i - 1][j + 1] == player && m[i - 2][j + 2] == player) {
                       return 500; 
                    }
                }
                if (i + 2 < TamTablero && j - 2 > -1 ) {
                    if (m[i][j]    == player && m[i + 1][j - 1]== player && m[i + 2][j - 2] == player) {
                       return 500; 
                    }
                }
                if (j + 1 < TamTablero) {
                    if (m[i][j]    == player && m[i][j + 1] == player ) {
                       value =300; 
                    }
                }
                if (i + 1 < TamTablero) {
                    if (m[i][j]    == player && m[j][i + 1]== player) {
                       value =300; 
                    }
                }
                 if (i + 1 < TamTablero && j + 1 < TamTablero) {
                    if (m[i][j]  == player && m[i + 1][j + 1] == player) {
                       value =300; 
                    }
                }
                  if (i - 1 > -1 && j + 1 < TamTablero) {
                    if (m[i][j]  == player && m[i - 1][j + 1] == player) {
                       value =300; 
                    }
                }
                  if ( i + 1 < TamTablero && j - 1 > -1) {
                    if (m[i][j]  == player && m[i + 1][j - 1]== player) {
                       value =300; 
                    }
                }
            }
        }
        return value;
    }
    
}
