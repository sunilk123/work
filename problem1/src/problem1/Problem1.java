/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author SUNIL PC
 */
public class Problem1 {

    static String sentence;
    static String[] words;
    static Scanner console = new Scanner(System.in);
    static Map<String,Integer> uniquewords=new HashMap<String,Integer>(); 
    public static void main(String[] args) {
        
        //----reading the sentence----
        sentence= console.nextLine();
        //System.out.println(sentence);
        
        //----split into words----
        
        words=sentence.split("\\W");
        System.out.println("Number of words in the string = "+words.length);
        System.out.println("the words are :");
        for(int i=0;i<words.length;i++)
            System.out.println(words[i]);
        
        //----copying the words into Map----
        for(int i=0;i<words.length;i++){
            int value = 1;
            for(int j=i+1;j<words.length;j++){
                if(words[i].equals(words[j]))
                    value+=1;
            }
            uniquewords.putIfAbsent(words[i],value);
        }
        
        //----displaying a map----
        Set set= uniquewords.entrySet();
        Iterator it= set.iterator();
        System.out.println("words and their frequencies : ");
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        
        //----displaying words appearing more than once----
        System.out.println("words with frquency greater than one : ");
        it= set.iterator();
        while(it.hasNext()){
            Map.Entry me = (Map.Entry)it.next();
            if((Integer)me.getValue()>1){
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
            }
        }
            
    
    }
    
}
