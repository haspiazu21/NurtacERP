/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.general.EmpresaDAO;
import dao.general.IEmpresaDAO;
import dao.general.ISucursalDAO;
import dao.general.SucursalDAO;
import dao.seguridad.GrupoUsuarioDAO;
import dao.seguridad.IGrupoUsuarioDAO;
import dao.seguridad.IUsuarioDAO;
import dao.seguridad.UsuarioDAO;
import entities.general.GenEmpresas;
import entities.general.GenSucursales;
import entities.seguridad.SegGruposusuarios;
import entities.seguridad.SegUsuarios;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mappers.general.EmpresaMapper;
import mappers.general.IEmpresaMapper;
import mappers.general.ISucursalMapper;
import mappers.general.SucursalMapper;
import mappers.seguridad.GrupoUsuarioMapper;
import mappers.seguridad.IGrupoUsuarioMapper;
import mappers.seguridad.IUsuarioMapper;
import mappers.seguridad.UsuarioMapper;
import modelo.general.Empresa;
import modelo.general.Sucursal;
import modelo.seguridad.GrupoUsuario;
import modelo.seguridad.Usuario;

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
    private final IEmpresaMapper empresaMapper;
    private final ISucursalMapper sucursalMapper;
    private final IGrupoUsuarioMapper grupoUsuarioMapper;
    private final IUsuarioMapper usuarioMapper;

    public FacadeMantUsuario() {
        empresaDAO = new EmpresaDAO();
        sucursalDAO = new SucursalDAO();
        grupoUsuarioDAO = new GrupoUsuarioDAO();
        usuarioDAO = new UsuarioDAO();

        empresaMapper = new EmpresaMapper();
        sucursalMapper = new SucursalMapper();
        grupoUsuarioMapper = new GrupoUsuarioMapper();
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
