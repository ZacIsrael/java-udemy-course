package com.zacisrael;

public class ScopeCheck {

    //Scope refers to the lifetime and accessibility of a variable.
    // How large the scope is depends on where a variable is declared.
    // For example, if a variable is declared at the top of a class then it will accessible to all of the class methods.
    // If it's declared in a method then it can only be used in that method.

    public  int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + ": varOne = " + varOne);

    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo(){
        int varTwo = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + i * varTwo);
        }
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
    }

    public class InnerClass{
        public int varThree = 3;

        public InnerClass() {
            System.out.println("InnerClass created , varOne is " + varOne + " and varThree is " + varThree);
        }
        public void timesTwo(){
            System.out.println("varOne is still available here " + varOne);
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times two is " + i * varThree);
            }
        }
    }
}
