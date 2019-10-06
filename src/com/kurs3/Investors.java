package com.kurs3;

import java.util.ArrayList;
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

    public void resize(int newLength)
    {
        Investor[] tempList = new Investor[newLength];
        tempList = Arrays.copyOf(this.list, newLength);

        this.list = tempList;
    }

    public void add(Investor investor, int position) {
        if (position > list.length-1) {
            this.resize(position);
            list[position-1] = investor;
        }
        else if (position > 0 && position < list.length)
            list[position-1] = investor;
    }

    public void add(Investor investor)
    {
        int i = list.length-1;
        for (; i >= 0 && list[i] != null; i--);

        if (i == -1) {
            resize(list.length + 1);
            list[list.length-1] = investor;
        }
        else
            list[i] = investor;
    }

    public Investor remove(int position)
    {
        if (position >=0 && position < list.length)
        {
            Investor investor = list[position-1];
            for (int i = position-1; i < list.length-1; i++) {
                list[i] = list[i+1];
            }

            resize(list.length-1);

            return investor;
        }
        return null;
    }

    public void clear()
    {
        resize(0);
    }
}
