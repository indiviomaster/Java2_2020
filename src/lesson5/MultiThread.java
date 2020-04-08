package lesson5;

import javax.swing.*;

public class MultiThread {
    static final int size = 10_000_000;
    static final int h = size/2;

    public static void main(String[] args) {

        func1();
        try {
            func2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void func1(){
        float [] arr = new float[size];
        for(int i=1; i<size; i++){
            arr[i]=1;
        }
        long a= System.currentTimeMillis();

        arr = calc(arr);
        long b= System.currentTimeMillis();
        System.out.println("Time calculation 1: " + (b-a));

    }
    public static void func2() throws InterruptedException {
        float [] arr = new float[size];
        for(int i=1; i<size; i++){
            arr[i]=1;
        }
        final float [] arrCopy = new float[h];
        final float [] arrCopy2 = new float[h];
        long a= System.currentTimeMillis();

        System.arraycopy(arr,0,arrCopy,0,h);
        System.arraycopy(arr,h,arrCopy2,0,h);

        Thread th1 = new Thread(()->{
            for(int i=1; i<arrCopy.length; i++){
            arrCopy[i]=(float)(arrCopy[i]*
                    Math.sin(0.2f+i/5)*
                    Math.cos(0.2f+i/5)*
                    Math.cos(0.4f+i/2));
        } });

        Thread th2 = new Thread(()->{
            for(int i=1; i<arrCopy2.length; i++){
                arrCopy2[i]=(float)(arrCopy2[i]*
                        Math.sin(0.2f+i/5)*
                        Math.cos(0.2f+i/5)*
                        Math.cos(0.4f+i/2));
            } });

        /*Thread th2 = new Thread(()->{
            float [] arrC2 = new float[h];
            for(int i=1; i<arrCopy2.length; i++){
                arrC2[i]= arrCopy2[i];
            }
            arrC2 = calc(arrC2);
            for(int i=1; i<arrCopy2.length; i++) {
                arrCopy2[i] = arrC2[i];
            }
        });*/

        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.arraycopy(arrCopy,0,arr,0,h);
        System.arraycopy(arrCopy2,0,arr,h,h);

        long b= System.currentTimeMillis();
        System.out.println("Time calculation 2: " + (b-a));

    }
    public static float[] calc(float [] ar){
        for(int i=1; i<ar.length; i++){
            ar[i]=(float)(ar[i]*
                    Math.sin(0.2f+i/5)*
                    Math.cos(0.2f+i/5)*
                    Math.cos(0.4f+i/2));
        }
        return ar;
    }
}
