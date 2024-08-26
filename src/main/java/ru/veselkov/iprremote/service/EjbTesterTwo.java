package ru.veselkov.iprremote.service;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class EjbTesterTwo {

    @EJB
    private StatelessBean statelessBean;
    @EJB
    private StateFullBean stateFullBean;
    @EJB
    private SingletonBean singletonBean;

    public void test() {
        System.out.println(this.getClass().getSimpleName());

        statelessBean.env();
        statelessBean.increment();
        statelessBean.env2();

        stateFullBean.env();
        stateFullBean.increment();
        stateFullBean.env2();

        singletonBean.env();
        singletonBean.increment();
        singletonBean.env2();
    }
}
