package itschool;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner in;

    public static void main(String[] args) {
        Investors investors = new Investors();

        in = new Scanner(System.in);
        int num = -1;
        boolean check = false;
        do {
            try {
                System.out.print("Input a number of investors: ");
                String number = in.nextLine();
                num = Integer.parseInt(number);
                if (num > 0)
                    check = true;
            } catch (InputMismatchException exc) {
                System.out.println(exc.getLocalizedMessage());
            } catch (Exception exc) {
                System.out.println(exc.getLocalizedMessage());
            }
        } while (!check);


        //investors.resize(num);

        for (int i = 0; i < num; i++) {
            investors.add(getNewInvestor());
        }

        System.out.println(investors);


        investors.add(getNewInvestor(), 2);
        System.out.println(investors);

        System.out.println("Investors with deposit greater than 10000: " + investors.getWithGraterDeposit(10000));

        investors.clear();
        System.out.printf("\n" + Arrays.toString(investors.getList()));
    }

    private static Investor getNewInvestor() {
        String FIO;
        String contractNumber;
        String address;
        String deposit;
        String contractTerm;

        do {
            System.out.print("Input FIO: ");
            FIO = in.nextLine();
        }
        while (!Investor.CheckCorrectFIO(FIO));

        System.out.print("Input Contract Number: ");
        contractNumber = in.nextLine();

        System.out.print("Input address: ");
        address = in.nextLine();

        do {
            System.out.print("Input deposit: ");
        }
        while (!Investor.CheckCorrectNumber(deposit = in.nextLine()));

        do {
            System.out.print("Input Term: ");
        } while (!Investor.CheckCorrectNumber(contractTerm = in.nextLine()));

        return new Investor(FIO, contractNumber, address, Integer.parseInt(deposit), Integer.parseInt(contractTerm));
    }
}
