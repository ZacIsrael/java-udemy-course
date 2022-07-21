package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));
        System.out.println(isCatPlaying(false, 45));

    }
    public static boolean isCatPlaying(boolean summer, int temperature ){



        if(summer == true && (temperature < 25 || temperature > 45)){
            return false;
        } else if(summer == false && (temperature < 25 || temperature > 45)){
            return false;
        }
        else if ( summer == true && (temperature >= 25)){
            return true;
        } else if( summer == true && (temperature >= 45)){
            return true;
        }
        else if (summer == false && temperature > 35){
            return false;
        } else if(summer == false && temperature <= 35 || temperature >= 25){
            return true;
        }
        else
        return summer;
    }

}
