package lesson2;

public class TestException {
    public static void main(String[] args) {
        int N=4;
        int M=5;
        String [][] arr = new String[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = ""+i+j;
            }
        }
        arr[1][1]="gg";
        arr[2][3]="gg";
        try {
            checkArraySize(arr);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                try {
                   sum += convertToInt(arr[i][j],i,j);
                } catch (MyArrayDataException e) {
                    e.printStackTrace();
                }
                //System.out.print(arr[i][j]+" ");
            }
            //System.out.println();

        }
        System.out.println("sum = "+sum);
    }

    private static int convertToInt(String data,int x, int y) throws MyArrayDataException {
        Integer i;
        try {
            i = Integer.parseInt(data);
        }
        catch (NumberFormatException e){

        throw new MyArrayDataException("Данные в ячейке A["+x+"]["+y+"] не соответствуют требованию!");
        }
        return i;
    }
    private static void checkArraySize(String [][] array ) throws MyArraySizeException {

        if(array.length!=4){
            throw new MyArraySizeException("массив не 4x4");
        }
        for(int i=0;i<array.length;i++){
            if(array[i].length!=4){
                throw new MyArraySizeException("массив не 4x4");
            }
        }
    }
}
