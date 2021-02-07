import java.util.Scanner;
public class Matriks {
    int row,col;
    int[][] elm;
    Matriks(int r, int c){
        row=r; col=c;
        elm=new int[row][col];
    }
    boolean isEqOrdo(Matriks M){
        if (row==M.row)
            if(col==M.col)
                return true;
            else
                return false;
        else return false;
    }
    void Baca(){
        Scanner baca = new Scanner(System.in);
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++){
                System.out.print("elemen ("+i+","+j+") = ");
                elm[i][j]=baca.nextInt();
            }
    }
    void Cetak(){
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++)
                System.out.print(elm[i][j]+" ");
                System.out.println();
        }
    }    
    Matriks tambah(Matriks M){
        Matriks T = new Matriks(row,col);
        for (int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                T.elm[i][j]=elm[i][j]+M.elm[i][j];
        return T;
    }
    Matriks kurang(Matriks M){
        Matriks T = new Matriks(row,col);
        for (int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                T.elm[i][j]=elm[i][j]-M.elm[i][j];
        return T;
    }
    Matriks kali(Matriks M){
        Matriks T = new Matriks(row,col);
        for (int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                T.elm[0][0]=elm[0][0]*M.elm[0][0]+elm[0][1]*M.elm[0][1];
                T.elm[0][1]=elm[0][0]*M.elm[0][1]+elm[0][1]*M.elm[1][1];
                T.elm[1][0]=elm[1][0]*M.elm[0][0]+elm[1][1]*M.elm[1][0];
                T.elm[1][1]=elm[1][0]*M.elm[0][1]+elm[1][1]*M.elm[1][1];
        return T;
    }
    Matriks transpose(Matriks M){
        Matriks T = new Matriks(row,col);
        for (int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                T.elm[i][j]=elm[j][i];
        return T;
    }
    public static void main(String[] args) {
        Matriks M = new Matriks(2,2);
        Matriks N = new Matriks(2,2);
        
        if(N.isEqOrdo(M)){
            Matriks Penjumlahan=new Matriks(2,2);
            Matriks Pengurangan=new Matriks(2,2);
            Matriks Perkalian = new Matriks(2,2);
            Matriks Transpose = new Matriks(2,2);
            
            System.out.println("Matriks Pertama: ");
                M.Baca();
            System.out.println("\n"+"Matriks Kedua: ");
                N.Baca();
            Penjumlahan=M.tambah(N);
                System.out.println("\n"+"Hasil Penjumlahan Matriks: ");
                Penjumlahan.Cetak();
            Pengurangan=M.kurang(N);
                System.out.println("\n"+"Hasil Pengurangan Matriks: ");
                Pengurangan.Cetak();
            Perkalian=M.kali(N);
                System.out.println("\n"+"Hasil Perkalian Matriks: ");
                Perkalian.Cetak();
            Transpose=M.transpose(N);
                System.out.println("\n"+"Matriks Pertama-Transpose: ");
                Transpose.Cetak();
            Transpose=N.transpose(M);
                System.out.println("\n"+"Matriks Kedua-Transpose: ");
                Transpose.Cetak();
        }
    }
}
