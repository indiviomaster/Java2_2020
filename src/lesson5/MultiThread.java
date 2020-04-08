package lesson5;

public class MultiThread {
    static final int size = 10_000_000;
    static final int h = size/2;
    static float [] arr = new float[size];
    static float [] array1 = new float[size];
    static float [] array2 = new float[size];

    public static void main(String[] args) {

        func1();

        try {
            func2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0; i<array1.length;i++) {
            if((array1[i]-array2[i])!=0) {
                System.out.print(i +" " +(array1[i]-array2[i]) );
                break;
            }
        }
    }

    public static void func1(){
        for(int i=0; i<arr.length; i++){
            arr[i]=1;
        }
        long a= System.currentTimeMillis();

        for(int i=0; i<arr.length; i++){
            array1[i]=(float)(arr[i]*
                    Math.sin(0.2f+i/5)*
                    Math.cos(0.2f+i/5)*
                    Math.cos(0.4f+i/2));
        }

        long b= System.currentTimeMillis();
        System.out.println("Time calculation 1: " + (b-a));

    }
    public static void func2() throws InterruptedException {
        for(int i=0; i<arr.length; i++){
            arr[i]=1;
        }
        float [] arrCopy1 = new float[h];
        float [] arrCopy2 = new float[h];
        long a= System.currentTimeMillis();

        System.arraycopy(arr,0,arrCopy1,0,h);
        System.arraycopy(arr,h,arrCopy2,0,h);

        Task task1  = new Task(arrCopy1,0);
        Thread th1 = new Thread(task1);
        arrCopy1 = task1.getArrayIn();

        Task task2  = new Task(arrCopy2,h);
        Thread th2 = new Thread(task2);
        arrCopy2 = task2.getArrayIn();

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.arraycopy(arrCopy1,0,array2,0,h);
        System.arraycopy(arrCopy2,0,array2,h,h);

        long b= System.currentTimeMillis();
        System.out.println("Time calculation 2: " + (b-a));
    }

    static class Task implements Runnable{
        float [] arrayIn;
        int index;

        public Task(float[] arrayIn, int index) {

            this.arrayIn = arrayIn;
            this.index = index;
        }

        public float[] getArrayIn() {
            return arrayIn;
        }

        public void run() {

            for(int i=0; i<arrayIn.length; i++){
                arrayIn[i]=(float)(arrayIn[i]*
                        Math.sin(0.2f+(i+index)/5)*
                        Math.cos(0.2f+(i+index)/5)*
                        Math.cos(0.4f+(i+index)/2));
            }
        }
    }
}
