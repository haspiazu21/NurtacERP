/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloGen.facade;

import ModuloGen.Dao.EmpresaDAO;
import ModuloGen.Dao.IEmpresaDAO;
import ModuloGen.Dao.ISucursalDAO;
import ModuloGen.Dao.SucursalDAO;
import ModuloSeg.Dao.GrupoUsuarioDAO;
import ModuloSeg.Dao.IGrupoUsuarioDAO;
import ModuloSeg.Dao.IUsuarioDAO;
import ModuloSeg.Dao.UsuarioDAO;
import ModuloGen.entities.GenEmpresas;
import ModuloGen.entities.GenSucursales;
import ModuloSeg.entities.SegGruposusuarios;
import ModuloSeg.entities.SegUsuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ModuloGen.mappers.EmpresaMapper;
import ModuloGen.mappers.IEmpresaMapper;
import ModuloGen.mappers.ISucursalMapper;
import ModuloGen.mappers.SucursalMapper;
import ModuloSeg.mappers.GrupoUsuarioMapper;
import ModuloSeg.mappers.IGrupoUsuarioMapper;
import ModuloSeg.mappers.IUsuarioMapper;
import ModuloSeg.mappers.UsuarioMapper;
import ModuloGen.modelo.Empresa;
import ModuloGen.modelo.Sucursal;
import ModuloSeg.modelo.GrupoUsuario;
import ModuloSeg.modelo.Usuario;

/**
 *
 * @author Ellet
 */
public class FacadeMantUsuario implements IFacadeMantUsuario, Serializable {

    /*
    Data Transfer Objects (DAO)
     */
    private final IEmpresaDAO empresaDAO;
    private final ISucursalDAO sucursalDAO;
    private final IGrupoUsuarioDAO grupoUsuarioDAO;
    private final IUsuarioDAO usuarioDAO;
    /*
    DTO Mappers
     */
    public final IEmpresaMapper empresaMapper;
    public final ISucursalMapper sucursalMapper;
    public final IGrupoUsuarioMapper grupoUsuarioMapper;
    public final IUsuarioMapper usuarioMapper;

    public FacadeMantUsuario() {
        empresaDAO = new EmpresaDAO();
        sucursalDAO = new SucursalDAO();
        grupoUsuarioDAO = new GrupoUsuarioDAO();
        usuarioDAO = new UsuarioDAO();

        empresaMapper = new EmpresaMapper();
        sucursalMapper = new SucursalMapper();
        grupoUsuarioMapper = new GrupoUsuarioMapper() {};
        usuarioMapper = new UsuarioMapper();

    }

    @Override
    public List<Empresa> findAllEmpresas() {
        List<Empresa> empresas = new ArrayList<>();
        List<GenEmpresas> entities = empresaDAO.findAll();
        for (GenEmpresas entity : entities) {
            Empresa empresa = empresaMapper.entityToModel(entity);
            empresas.add(empresa);
        }
        return empresas;
    }

    @Override
    public List<Sucursal> findSucursalesByEmpresa(int empresaid) {
        List<Sucursal> sucursales = new ArrayList<>();
        List<GenSucursales> entities = sucursalDAO.findAllByEmpresa(empresaid);
        for (GenSucursales entity : entities) {
            Sucursal sucursal = sucursalMapper.entityToModel(entity);
            sucursales.add(sucursal);
        }
        return sucursales;
    }

    @Override
    public List<GrupoUsuario> findAllGruposUsuarios() {
        List<GrupoUsuario> gruposUsuarios = new ArrayList<>();
        List<SegGruposusuarios> entities = grupoUsuarioDAO.findAll();
        for (SegGruposusuarios entity : entities) {
            GrupoUsuario grupoUsuario = grupoUsuarioMapper.entityToModel(entity);
            gruposUsuarios.add(grupoUsuario);
        }
        return gruposUsuarios;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        List<SegUsuarios> entities = usuarioDAO.findAll();
        for (SegUsuarios entity : entities) {
            Usuario usuario = usuarioMapper.entityToModel(entity);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuario.setEstado(usuario.getEstado() == null ? "Activo" : usuario.getEstado());
        SegUsuarios segUsuarios = usuarioMapper.modelToEntity(usuario);
        if (usuario.getId() == 0) {
            usuarioDAO.create(segUsuarios);
        } else {
            usuarioDAO.merge(segUsuarios);
        }

    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario.getId());
    }

}
