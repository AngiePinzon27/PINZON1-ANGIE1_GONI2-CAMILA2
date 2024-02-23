package com.backend.service;

import com.backend.Odontologo;
import com.backend.daoconnection.IDao;

import java.util.List;

public class OdontologoSer implements OdontologoService{
    private IDao<Odontologo> odontologoIDao;
    public OdontologoSer(IDao<Odontologo> odontologoIDao){
        this.odontologoIDao=odontologoIDao;
    }

    @Override
    public Odontologo registarOdontologo(Odontologo odontologo) {
        return odontologoIDao.registrar(odontologo);
    }

    public List<Odontologo> listarOdontologo(){
        return odontologoIDao.listarTodos();
    }

    @Override
    public Odontologo guardarOdontologo(int id) {
        return odontologoIDao.guardar(id);
    }

}
