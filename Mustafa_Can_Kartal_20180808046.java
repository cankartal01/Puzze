/**
 * @author  Mustafa Can Kartal
 * @since   02.11.2021
 */

import java.util.*;

public class Mustafa_Can_Kartal_20180808046 {
    public  static StringBuilder write(String word, int[] array, String resum){
        StringBuilder a = new StringBuilder();
        for (int i = 0;i<word.length();i++){
            char A = word.charAt(i);
            String s= Character.toString(A);
            int c = resum.indexOf(s);
            a.append(array[c]);
        }
        return a;

    }

    public static int sum_finder(String word,String resum,int[] array){
        int sum=0;

        for (int i =0; i<word.length(); i++){
            char A = word.charAt(i);

            String s = Character.toString(A);
            sum +=  array[resum.indexOf(s)] *  (Math.pow(10,word.length()-i-1)  );

        }
        return sum;

    }

    public static int[]  number_finder(List<Integer> list,String sum) {

        int[] array=new int[sum.length()];
        list.clear();
        while (list.size()!=sum.length()){
            int a = (int) (Math.random()*10);
            if(!list.contains(a)){
                list.add(a);
            }
        }

        for (int i=0;i<sum.length();i++){
            array[i]=list.get(i);
        }


        return array;
    }
    public static void main(String[] args) {

        String sum = "";
        String resum = "";
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 1st input value:");
        String word_1 = scanner.nextLine();
        if (word_1.length()<2||word_1.length()>6){
            throw new RuntimeException("Lenght can't be greater 6 or smaller 2 ");
        }
        System.out.print("Enter 2st input value:");
        String word_2 = scanner.nextLine();
        if (word_2.length()<2||word_2.length()>6){
            throw new RuntimeException("Lenght can't be greater 6 or smaller 2 ");
        }
        System.out.print("Enter Output value:");
        String word_3 = scanner.nextLine();
        if (word_3.length()<2||word_3.length()>6){
            throw new RuntimeException("Lenght can't be greater 6 or smaller 2 ");
        }
        sum = word_1 + word_2 + word_3;

        for (int i = 0; i < sum.length(); i++) {
            char f = sum.charAt(i);
            if (!resum.contains(String.valueOf(f)))
                resum += sum.charAt(i);

        }
        ArrayList<int[]> lists =new ArrayList<>();
        int a = 0;

        while(a<11){

            int[] array=number_finder(list,resum);

            if (sum_finder(word_1,resum,array)+sum_finder(word_2,resum,array)==sum_finder(word_3,resum,array)){

                if (!lists.contains(array)){
                    a++;
                    lists.add(array);
                    System.out.println("searching...found!");
                    System.out.println(word_1+":    "+ write(word_1,array,resum) );
                    System.out.println(word_2+":    "+ write(word_2,array,resum) );
                    System.out.println(word_3+":    "+ write(word_3,array,resum) );

                }

            }
        }
    }

}
