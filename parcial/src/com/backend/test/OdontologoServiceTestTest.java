package com.backend.test;

import com.backend.Odontologo;
import com.backend.daoconnection.H2DaoOdontologo;
import com.backend.service.OdontologoSer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTestTest {
    private OdontologoSer odontologoSer;
    @Test

    void deberiaRegistrarUnOdontologoYRetornarUnIdEnH2(){
        odontologoSer=new OdontologoSer(new H2DaoOdontologo());
        Odontologo odontologo = new Odontologo("Jose","Perez",1234);

    }
}

