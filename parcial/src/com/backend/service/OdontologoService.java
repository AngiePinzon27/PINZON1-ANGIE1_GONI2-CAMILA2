package com.backend.service;

import com.backend.Odontologo;

import java.util.List;

public interface OdontologoService {
    Odontologo registarOdontologo (Odontologo odontologo);

    List<Odontologo> listarOdontologo();
    Odontologo guardarOdontologo(int id);
}
