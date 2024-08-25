package ru.veselkov.iprremote.service;

import jakarta.ejb.Remote;
import ru.veselkov.iprremote.model.RemoteModel;

@Remote
public interface RemoteServiceIpr {

    void callRemote();

    void callRemote(RemoteModel model);

    void callRemote(long id);
}
