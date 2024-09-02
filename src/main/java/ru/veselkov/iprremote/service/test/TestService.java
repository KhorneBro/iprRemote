package ru.veselkov.iprremote.service.test;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class TestService {

    @EJB
    private EjbTesterOne ejbTesterOne;
    @EJB
    private EjbTesterTwo ejbTesterTwo;

    public void test() {
        ejbTesterOne.test();
        ejbTesterTwo.test();
    }
}
