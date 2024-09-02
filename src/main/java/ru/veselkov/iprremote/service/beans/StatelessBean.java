package ru.veselkov.iprremote.service.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import ru.veselkov.iprremote.model.RemoteModel;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class StatelessBean {

    private int statelessInt = 0;
    private List<Integer> list = new ArrayList<>();

    @PostConstruct
    private void constr() {
        System.out.println("StatelessBean created");
    }

    @PreDestroy
    private void destr() {
        System.out.println("StatelessBean destroyed");
    }

    public void increment(RemoteModel model) {
        System.out.println("StatelessBean begin");
        System.out.println(statelessInt);
        ++statelessInt;
        model.setStatlessValue(statelessInt);
        list.add(statelessInt);
        System.out.println("StatelessBean end");
    }

    public int getStatelessInt() {
        return statelessInt;
    }

    public void setStatelessInt(int statelessInt) {
        this.statelessInt = this.statelessInt + statelessInt;
    }
}
