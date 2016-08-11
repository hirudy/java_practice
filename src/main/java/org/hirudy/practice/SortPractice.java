package org.hirudy.practice;

/**
 * @author: rudy
 * @date: 2016/08/10
 * 选择排序,插入排序,希尔排序的java实现
 */
public class SortPractice {
    /**
     * 获取调用函数的函数名称
     * @return String
     */
    public static String getMethodName() {
        StackTraceElement traceElement = ((new Exception()).getStackTrace())[2];
        return traceElement.getMethodName();
    }

    /**
     * 打印数组
     * @param data T
     * @param <T> T
     */
    public static <T> void printArray(T[] data){
        System.out.print(getMethodName()+":");
        for(T row : data){
            System.out.print(row.toString());
            System.out.print(" ");
        }
        System.out.println("");
    }

    /**
     * 交换数组中的两个元素
     * @param data T[]
     * @param i int
     * @param j int
     * @param <T> T[]
     */
    public static <T> void switchArray(T[] data, int i, int j){
        T switchTemp = data[i];
        data[i] = data[j];
        data[j] = switchTemp;
    }

    /**
     * 选择排序
     * @param data Comparable[]
     */
    public static void selectSort(Comparable[] data){
        int dataLength = data.length;
        for (int i=0; i< dataLength; i++){
            int min = i;
            for (int j=i; j<dataLength; j++){
                if (data[min].compareTo(data[j]) > 0){
                    min = j;
                }
            }
            switchArray(data, i, min);
        }
        printArray(data);
    }

    /**
     * 插入排序
     * @param data Comparable[]
     */
    public static void insertSort(Comparable[] data){
        int dataLength = data.length;
        for (int i=0; i< dataLength; i++){
            for (int j=i; j>0 && data[j].compareTo(data[j-1])<0; j--){
                switchArray(data,j,j-1);
            }
        }
        printArray(data);
    }

    /**
     * 希尔排序
     * @param data Comparable[]
     */
    public static void shellSort(Comparable[] data){
        int dataLength = data.length;
        int h = 1;
        while (h < dataLength/3) h = 3*h + 1;
        while (h >= 1){
            for (int i=h; i< dataLength; i++){
                for (int j=i; j>=h && data[j].compareTo(data[j-h]) < 0;j -=h){
                    switchArray(data,j,j-h);
                }
            }
            h = h/3;
        }
        printArray(data);
    }


    public static void main(String[] args){
        Integer[] data = new Integer[]{12,1,7,19,8,2,6,1,5,10,4,3,7};
        printArray(data);
//        String[] data = new String[]{"ab","12","xz","aa","ac"};

        selectSort(data);

        insertSort(data);

        shellSort(data);
    }
}
