package com.kurs3;
import java.util.Arrays;

public class Investors {

    private Investor[] list;

    public Investor[] getList() {
        return list;
    }

    public Investors() {
        this.list = new Investor[0];
    }

    public Investors(int length) {
        this.list = new Investor[length];
    }

    public void resize(int newLength) {
        Investor[] tempList = new Investor[newLength];
        tempList = Arrays.copyOf(this.list, newLength);

        this.list = tempList;
    }

    public void add(Investor investor, int position) {
        if (position > list.length - 1) {
            this.resize(list.length + 1);
            list[list.length - 1] = investor;
        } else if (position > 0 && position < list.length) {
            this.resize(list.length + 1);
            Investor subinvestor = list[position-1];
            Investor subinvestor2;
            list[position - 1] = investor;
            for(int i=position; i<list.length-1; i++) {
                subinvestor2=list[i];
                list[i] = subinvestor;
                subinvestor = list[i+1];
                list[i+1] = subinvestor2;
            }
        }
    }

    public void add(Investor investor) {
        this.resize(list.length + 1);
        list[list.length - 1] = investor;
    }

    public Investor remove(int position) {
        if (position >= 0 && position < list.length) {
            Investor investor = list[position - 1];
            for (int i = position - 1; i < list.length - 1; i++) {
                list[i] = list[i + 1];
            }

            resize(list.length - 1);

            return investor;
        }
        return null;
    }

    public void clear() {
        resize(0);
    }

    public Investors getWithGraterDeposit(double deposit) {
        Investors sublist = new Investors();
        for (Investor investor : this.list) {
            if (investor.deposit > deposit)
                sublist.add(investor);
        }
        return sublist;
    }

    public Investors getWithGraterTempDeposit(double temp) {
        Investors sublist = new Investors();
        for (Investor investor : this.list) {
            if (investor.contractTerm > temp)
                sublist.add(investor);
        }
        return sublist;
    }

    public Investors getWithFIO(String FIO) {
        Investors sublist = new Investors();
        for (Investor investor : this.list) {
            if (investor.FIO.equals(FIO))
                sublist.add(investor);
        }
        return sublist;
    }

    public Investor[] deleteWithFIO(String FIO) {
        Investor[] sublist = new Investor[0];
        for (Investor investor : this.list) {
            if (!investor.FIO.equals(FIO)) {
                sublist = Arrays.copyOf(sublist, sublist.length + 1);
                sublist[sublist.length - 1] = investor;
            }
        }
        this.list = Arrays.copyOf(sublist, sublist.length);

        return this.list;
    }

    @Override
    public String toString() {
        return "Investors{" +
                "list=" + Arrays.toString(list) +
                '}';
    }
}
