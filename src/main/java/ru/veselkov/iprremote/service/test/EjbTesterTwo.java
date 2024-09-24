package ru.veselkov.iprremote.service.test;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import ru.veselkov.iprremote.service.beans.SingletonBean;
import ru.veselkov.iprremote.service.beans.StateFullBean;
import ru.veselkov.iprremote.service.beans.StatelessBean;

@Stateless
public class EjbTesterTwo {

    @EJB
    private StatelessBean statelessBean;
    @EJB
    private StateFullBean stateFullBean;
    @EJB
    private SingletonBean singletonBean;

    private int i = 1;

    public void test() {
        System.out.println(this.getClass().getSimpleName() + " i = " + i);

        statelessBean.setStatelessInt(i);
        System.out.println("statelessBean.getStatelessInt() = " + statelessBean.getStatelessInt());

        stateFullBean.setStatefull(i);
        System.out.println("stateFullBean.getStatefull() = " + stateFullBean.getStatefull());

        singletonBean.setSingleton(i);
        System.out.println("singletonBean.getSingleton() = " + singletonBean.getSingleton());

    }
}
