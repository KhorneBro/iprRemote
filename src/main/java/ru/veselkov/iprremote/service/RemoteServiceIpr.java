package ru.veselkov.iprremote.service;

import jakarta.ejb.Remote;

@Remote
public interface RemoteServiceIpr {

    void callRemote();

    void callRemote(int id);

    void callRemote(long id);
}
