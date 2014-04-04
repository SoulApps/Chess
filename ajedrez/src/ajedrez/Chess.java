/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Ramón
 */
public class Chess {

    private char[][] chessTable;
    private int rowSize;
    private int colSize;

    private Point startSelectedMov;

    private Point finalSelectedMov;

    private ArrayList<Point> chessPosList = new ArrayList();

    public static final char EMPTY = '.';
    public static final char KING = '+';
    public static final char QUEEN = '*';
    public static final char WALL = '#';
    public static final char ROOK = 'R';
    public static final char KNIGHT = 'K';
    public static final char PAWN = 'P';
    public static final char BISHOP = 'B';

    public static final byte DERECHA = 0;
    public static final byte IZQUIERDA = 1;
    public static final byte ARRIBA = 2;
    public static final byte ABAJO = 3;

    /*
     Información contenida en el tablero:
     ' ': Vacío
     '@': Cabeza
     '=': Cuerpo
     '#': Muro
     '$': Fruta
     */
    public Chess(int fileSize, int colSize) {
        //Asignar el valor de los datos para guardarlos arriba y que se puedan tener en otro método.
        this.rowSize = fileSize;
        this.colSize = colSize;
        chessTable = new char[fileSize][colSize];
        //Inicializamos el tablero con todo vacío
        for (int f = 0; f < fileSize; f++) {
            for (int c = 0; c < colSize; c++) {
                chessTable[f][c] = EMPTY;
            }
        }
        //NEGRAS
        chessTable[0][0] = ROOK;
        chessTable[0][1] = KNIGHT;
        chessTable[0][2] = BISHOP;
        chessTable[0][3] = KING;
        chessTable[0][4] = QUEEN;
        chessTable[0][5] = BISHOP;
        chessTable[0][6] = KNIGHT;
        chessTable[0][7] = ROOK;
        //Colocar el peón
        for (int i = 0; i <= 7; i++) {
            chessTable[1][i] = PAWN;
        }

        //BLANCAS
        for (int i = 0; i <= 7; i++) {
            chessTable[6][i] = PAWN;
        }
        chessTable[7][0] = ROOK;
        chessTable[7][1] = KNIGHT;
        chessTable[7][2] = BISHOP;
        chessTable[7][3] = QUEEN;
        chessTable[7][4] = KING;
        chessTable[7][5] = BISHOP;
        chessTable[7][6] = KNIGHT;
        chessTable[7][7] = ROOK;
    }

    public void setMovement(byte startRowMov, byte startColMov, byte finalRowMov, byte finalColMov) {
    char initialPiece;
    
    initialPiece  = chessTable[startRowMov][startColMov];
    chessTable[startRowMov][startColMov] = EMPTY;
    chessTable [finalRowMov][finalColMov] = initialPiece ;
    

}

public String toString() {
        String retorno = "";
        for (int f = 0; f < rowSize; f++) {
            for (int c = 0; c < colSize; c++) {
                retorno += chessTable[f][c];
            }
            retorno += '\n';
        }
        return retorno;
    }
}
