package sample;

public class Juego {

    private int[][] panel=new int[3][3];
    private int fichasColocadas=0;

    private int turno;

    public int getfichasColocadas() {
        return fichasColocadas;

    }



    public Juego() {
     turno=(int)(Math.random()*2)+1;
     fichasColocadas=0;

    }

    public int[][] getTablero() {
        return panel;
    }

    public int getTurno() {
        return turno;
    }

    public void AsignarTurno() {
        if (turno==1) turno=2;
        else turno=1;
    }
    public boolean colocarFicha(int f, int c){

        if (panel[f][c]==0){
            panel[f][c]=turno;
            fichasColocadas++;

            return true;
        }
        else return false;
    }

    public  boolean comprobarFila(int fila){
        for (int j = 0; j <3 ; j++) {
            if(panel[fila][j]!=turno) return false;

        }
        return true;

    }
    public  boolean comprobarColumna(int col){

        for (int i = 0; i <3 ; i++) {
            if(panel[i][col]!=turno) return false;

        }
        return true;
    }
    public  boolean comprobarDiagonalPrincipal(){
        for (int i = 0; i <3 ; i++) {
            if(panel[i][i]!=turno) return false;

        }
        return true;

        }


    public  boolean comprobarDiagonalInversa(){
        int j=2;
        for (int i = 0; i <3 ; i++) {
            if(panel[i][j]!=turno) return false;
            j--;
        }
        return true;

    }

    }


