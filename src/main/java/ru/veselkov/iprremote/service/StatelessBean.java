package ru.veselkov.iprremote.service;

import jakarta.ejb.Stateless;
import ru.veselkov.iprremote.model.RemoteModel;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class StatelessBean {

    private int statelessInt = 1;
    private List<Integer> list = new ArrayList<>();

    public void increment(RemoteModel model) {
        System.out.println(statelessInt);
        statelessInt = model.getStatlessValue() == 0 ? statelessInt + 1 : model.getStatlessValue() + statelessInt;
        model.setStatlessValue(statelessInt);
        list.add(statelessInt);
    }

    public void increment() {
        statelessInt++;
        list.add(statelessInt);
    }

    public void env() {
        System.out.println("StatelessBean begin");
        System.out.println(statelessInt);
        System.out.println(list);
    }

    public void env2() {
        System.out.println("StatelessBean end");
        System.out.println(statelessInt);
        System.out.println(list);
    }
}
