package com.backend.daoconnection;

import java.util.List;

public interface IDao <T> {
    T registrar (T t);
    T guardar (int t);

    List<T> listarTodos();


}
