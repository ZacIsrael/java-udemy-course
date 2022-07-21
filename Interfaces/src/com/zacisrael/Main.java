package com.zacisrael;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ITelephone zacsPhone;
        zacsPhone = new DeskPhone(2022885916);
        zacsPhone.powerOn();
        zacsPhone.callPhone(2022885916);
        zacsPhone.answer();

        zacsPhone = new MobilePhone(245653278);
        zacsPhone.powerOn();
        zacsPhone.callPhone(245653278);
        zacsPhone.answer();


    }
}
