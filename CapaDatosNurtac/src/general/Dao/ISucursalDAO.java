/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general.Dao;

import general.entities.GenSucursales;
import java.util.List;

/**
 *
 * @author Ellet
 */
public interface ISucursalDAO {

    void create(GenSucursales sucursal);

    void merge(GenSucursales sucursal);

    void delete(int sucursalId);

    GenSucursales find(int id);

    List<GenSucursales> findAll();
    
    List<GenSucursales> findAllByEmpresa(int empresaId);

    int getNextId();
}
