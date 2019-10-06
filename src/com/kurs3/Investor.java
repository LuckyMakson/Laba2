package com.kurs3;

public class Investor {
    String FIO;
    String contractNumber;
    String address;
    int deposit;
    int contractTerm;

    public Investor() {
    }

    public Investor(String FIO, String contractNumber, String address, int deposit, int contractTerm) {
        this.setFIO(FIO);
        this.setContractNumber(contractNumber);
        this.setAddress(address);
        this.setDeposit(deposit);
        this.setContractTerm(contractTerm);
    }

    public String getFIO() { return FIO; }
    public String getContractNumber() { return contractNumber; }
    public String getAddress() { return address; }
    public int getDeposit() { return deposit; }
    public int getContractTerm() { return contractTerm; }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void setContractTerm(int contractTerm) {
        this.contractTerm = contractTerm;
    }

    public static boolean CheckCorrectFIO(String str){
        return  str.matches("^\\D*$");
    }

    public static boolean CheckCorrectNumber(String str){
        double deposit;
        try {
            deposit = Double.parseDouble(str) > 0 ? Double.parseDouble(str) : -1;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "FIO='" + FIO + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", address='" + address + '\'' +
                ", deposit=" + deposit +
                ", contractTerm=" + contractTerm +
                '}';
    }
}
