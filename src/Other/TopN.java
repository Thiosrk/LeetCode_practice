package Other;

import java.util.Random;

public class TopN {

    public static class Main{
        public static void main(String[] args) {
            TopN topN = new TopN();

            //first test
            int[] arr1 = new int[]{56,30,71,18,29,93,44,75,20,65,68,34};

            System.out.println("Original data: ");
            topN.print(arr1);
            topN.findTopN(5,arr1);
            System.out.println("Adjust data: ");
            topN.print(arr1);

            //second test
            int[] arr2 = new int[1000];
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = i + 1;
            }

            System.out.println("Original data: ");
            topN.print(arr2);
            topN.findTopN(50,arr2);
            System.out.println("Adjust data: ");
            topN.print(arr2);

            //third test
            Random random = new Random();
            int[] arr3 = new int[1000];
            for (int i = 0; i < arr3.length; i++) {
                arr3[i] = random.nextInt();
            }

            System.out.println("Original data: ");
            topN.print(arr3);
            topN.findTopN(50,arr3);
            System.out.println("Adjust data: ");
            topN.print(arr3);
        }
    }




    //father
    private int parent(int n){
        return (n-1) / 2;
    }

    //leftchild
    private int left(int n){
        return 2*n + 1;
    }

    //rightchild
    private int right(int n){
        return 2*n + 2;
    }

    //build heap
    private void buildHeap(int n,int[] data){
        for (int i = 0; i < n; i++) {
            int t = 1;
            //adjust heap
            while (t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    //adjust data[i]
    private void adjust(int i,int n,int[] data){
        if (data[i] <= data[0]){
            return;
        }
        //exchange heaptop
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        //adjust heaptop
        int t = 0;
        while (left(t) < n && data[t] > data[left(t)]
            || (right(t) < n && data[t] > data[right(t)])) {
            if (right(t) < n && data[right(t)] <data[left(t)]){
                //rightchild < leftchild < t,exchange right
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                //exchange left
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }

        }
    }

    //find TopN ,sort data ,let TopN first
    public void findTopN(int n,int[] data){
        buildHeap(n,data);
        for (int i = n; i < data.length; i++) {
            adjust(i,n,data);
        }
    }

    //print data
    public void print(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
