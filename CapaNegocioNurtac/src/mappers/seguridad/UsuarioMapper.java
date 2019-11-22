/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers.seguridad;

import entities.general.GenEmpresas;
import entities.general.GenSucursales;
import entities.seguridad.SegGruposusuarios;
import entities.seguridad.SegUsuarios;
import modelo.general.Empresa;
import modelo.general.Sucursal;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Usuario;

/**
 *
 * @author Ellet
 */
public class UsuarioMapper implements IUsuarioMapper {
    
    @Override
    public Usuario entityToModel(SegUsuarios usuarioEntity) {
        if (usuarioEntity == null) {
            return null;
        }
        
        GrupoUsuario grupoUsuario = null;
        
        if (usuarioEntity.getGrupousuarioid() != null) {
            grupoUsuario = new GrupoUsuario();
            grupoUsuario.setDescripcion(usuarioEntity.getGrupousuarioid().getDescripcion());
            grupoUsuario.setEstado(usuarioEntity.getGrupousuarioid().getEstado().equals("A") ? "Activo" : "Inactivo");
            grupoUsuario.setId(usuarioEntity.getGrupousuarioid().getGrupousuarioid());
            grupoUsuario.setNombre(usuarioEntity.getGrupousuarioid().getNombre());
            
        }
        
        Empresa empresa = null;
        
        if (usuarioEntity.getEmpresaid() != null) {
            empresa = new Empresa();
            empresa.setCedRepLegal(usuarioEntity.getEmpresaid().getCedreplegal());
            empresa.setComercial(usuarioEntity.getEmpresaid().getComercial());
            empresa.setEstado(usuarioEntity.getEmpresaid().getEstado().equals("A") ? "Activo" : "Inactivo");
            empresa.setId(usuarioEntity.getEmpresaid().getEmpresaid());
            empresa.setNombre(usuarioEntity.getEmpresaid().getNombre());
            empresa.setRepLegal(usuarioEntity.getEmpresaid().getReplegal());
            
        }
        
        Sucursal sucursal = null;
        
        if (usuarioEntity.getSucursalid() != null) {
            sucursal = new Sucursal();
            sucursal.setDireccion(usuarioEntity.getSucursalid().getDireccion());
            sucursal.setEmail(usuarioEntity.getSucursalid().getEmail());
            sucursal.setEmpresa(empresa);
            sucursal.setEstado(usuarioEntity.getSucursalid().getEstado().equals("A") ? "Activo" : "Inactivo");
            sucursal.setId(usuarioEntity.getSucursalid().getSucursalid());
            sucursal.setNombre(usuarioEntity.getSucursalid().getNombre());
            sucursal.setTelefono(usuarioEntity.getSucursalid().getTelefono());
            
        }
        
        Usuario usuario = new Usuario();
        usuario.setContrasena(usuarioEntity.getContrasena());
        usuario.setEmpresa(empresa);
        usuario.setEstado(usuarioEntity.getEstado().equals("A") ? "Activo" : "Inactivo");
        usuario.setGrupousuario(grupoUsuario);
        usuario.setId(usuarioEntity.getUsuarioid());
        usuario.setNombre(usuarioEntity.getNombre());
        usuario.setSucursal(sucursal);
        usuario.setUsuario(usuarioEntity.getUsername());
        
        return usuario;
        
    }
    
    @Override
    public SegUsuarios modelToEntity(Usuario usuario) {
        
        GenEmpresas genEmpresas = new GenEmpresas();
        genEmpresas.setEmpresaid(usuario.getEmpresa().getId());
        
        GenSucursales genSucursales = new GenSucursales();
        genSucursales.setSucursalid(usuario.getSucursal().getId());
        
        
        SegGruposusuarios segGruposusuarios = null;
        
        if(usuario.getGrupousuario() != null){
            segGruposusuarios = new SegGruposusuarios();
            segGruposusuarios.setGrupousuarioid(usuario.getGrupousuario().getId());
        }
        
        SegUsuarios segUsuarios = new SegUsuarios();
        segUsuarios.setUsuarioid(usuario.getId());
        segUsuarios.setContrasena(usuario.getContrasena());
        segUsuarios.setEmpresaid(genEmpresas);
        segUsuarios.setEstado(usuario.getEstado().equals("Activo") ? "A" : "I");
        segUsuarios.setGrupousuarioid(segGruposusuarios);
        segUsuarios.setNombre(usuario.getNombre());
        segUsuarios.setSucursalid(genSucursales);
        segUsuarios.setUsername(usuario.getUsuario());
        
        return segUsuarios;
        
    }
    
}
