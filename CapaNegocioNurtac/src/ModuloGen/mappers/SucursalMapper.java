/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.mappers;

import ModuloGen.entities.GenSucursales;
import ModuloGen.modelo.Empresa;
import ModuloGen.modelo.Sucursal;

/**
 *
 * @author Ellet
 */
public class SucursalMapper implements ISucursalMapper {

    @Override
    public Sucursal entityToModel(GenSucursales sucursalEntity) {
        if (sucursalEntity == null) {
            return null;
        }

        Empresa empresa = null;

        if (sucursalEntity.getEmpresaid() != null) {
            empresa = new Empresa();
            empresa.setCedRepLegal(sucursalEntity.getEmpresaid().getCedreplegal());
            empresa.setComercial(sucursalEntity.getEmpresaid().getComercial());
            empresa.setEstado(sucursalEntity.getEmpresaid().getEstado().equals("A") ? "Activo" : "Inactivo");
            empresa.setId(sucursalEntity.getEmpresaid().getEmpresaid());
            empresa.setNombre(sucursalEntity.getEmpresaid().getNombre());
            empresa.setRepLegal(sucursalEntity.getEmpresaid().getReplegal());
        }

        Sucursal sucursal = new Sucursal();
        sucursal.setDireccion(sucursalEntity.getDireccion());
        sucursal.setEmail(sucursalEntity.getEmail());
        sucursal.setEmpresa(empresa);
        sucursal.setEstado(sucursalEntity.getEstado().equals("A") ? "Activo" : "Inactivo");
        sucursal.setId(sucursalEntity.getSucursalid());
        sucursal.setNombre(sucursalEntity.getNombre());
        sucursal.setTelefono(sucursalEntity.getTelefono());
        sucursal.setRuc(sucursalEntity.getRuc());

        return sucursal;
    }

    @Override
    public GenSucursales modelToEntity(Sucursal sucursal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
