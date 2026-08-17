package com.curso.v0;

public class TestClass {
    static int val = 10;
    public static int reduce(int val){ 
    	
        class Inner{
            public int reduce(int mval){
                return mval-val;
            }
        }
        
        //val--;
        return new Inner().reduce(val);
    }
            
     public static void main(String[] args) {
        reduce(5);
        System.out.println(val);
    }
}