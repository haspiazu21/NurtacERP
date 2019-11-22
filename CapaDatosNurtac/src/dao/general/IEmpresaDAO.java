/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.general;

import entities.general.GenEmpresas;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface IEmpresaDAO {
    
    void create(GenEmpresas empresa);

    void merge(GenEmpresas empresa);

    void delete(int empresaId);

    GenEmpresas find(int id);

    List<GenEmpresas> findAll();

    int getNextId();
    
    
    
}
