package com.example.rm30966.olimpiadas;

/**
 * Created by RM30966 on 17/10/2016.
 */

import com.example.rm30966.olimpiadas.Modalidade;

import java.util.ArrayList;
import java.util.List;

public class ModalidadeDAO
{
    public static List<Modalidade> listar()
    {
        List<Modalidade> listModalidades = new ArrayList<Modalidade>();
        listModalidades.add(new Modalidade("Natação"));
        listModalidades.add(new Modalidade("Judô"));
        listModalidades.add(new Modalidade("Futebol"));
        listModalidades.add(new Modalidade("Esgrima"));

        return listModalidades;
    }


}
