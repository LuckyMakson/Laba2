package com.kurs3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Main {

    public static void main(String[] args) {
        String FIO;
        String contractNumber;
        String address;
        String deposit;
        String contractTerm;

        Investors investors = new Investors(1);

        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of investors: ");
        int num = in.nextInt();

        investors.resize(num);

        for (int i = 0; i < investors.getList().length; i++) {
            System.out.print("Input FIO: ");
            while (!Investor.CheckCorrectFIO(FIO = in.nextLine())) {
            }
            System.out.print("Input Contract Number: ");
            contractNumber = in.nextLine();
            System.out.print("Input address: ");
            address = in.nextLine();
            System.out.print("Input deposit: ");
            while (!Investor.CheckCorrectNumber(deposit = in.nextLine())) {
            }
            System.out.print("Input Term: ");
            while (!Investor.CheckCorrectNumber(contractTerm = in.nextLine())) {
            }
            investors.add(new Investor(FIO, contractNumber, address, Integer.parseInt(deposit), Integer.parseInt(contractTerm)));
        }

        System.out.printf(Arrays.toString(investors.getList()) + "\n");

        System.out.print("Input FIO: ");
        while (!Investor.CheckCorrectFIO(FIO = in.nextLine())) {
        }
        System.out.print("Input Contract Number: ");
        contractNumber = in.nextLine();
        System.out.print("Input address: ");
        address = in.nextLine();
        System.out.print("Input deposit: ");
        while (!Investor.CheckCorrectNumber(deposit = in.nextLine())) {
        }
        System.out.print("Input Term: ");
        while (!Investor.CheckCorrectNumber(contractTerm = in.nextLine())) {
        }

        investors.add(new Investor(FIO, contractNumber, address, Integer.parseInt(deposit), Integer.parseInt(contractTerm)),2);
        System.out.printf(Arrays.toString(investors.getList()));

        investors.clear();
        System.out.printf("\n" + Arrays.toString(investors.getList()));
    }
}
