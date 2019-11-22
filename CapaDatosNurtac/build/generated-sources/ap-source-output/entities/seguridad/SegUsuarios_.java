package entities.seguridad;

import entities.general.GenEmpresas;
import entities.general.GenSucursales;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SegUsuarios.class)
public abstract class SegUsuarios_ {

	public static volatile SingularAttribute<SegUsuarios, SegGruposusuarios> grupousuarioid;
	public static volatile SingularAttribute<SegUsuarios, String> estado;
	public static volatile SingularAttribute<SegUsuarios, GenEmpresas> empresaid;
	public static volatile SingularAttribute<SegUsuarios, GenSucursales> sucursalid;
	public static volatile SingularAttribute<SegUsuarios, String> contrasena;
	public static volatile SingularAttribute<SegUsuarios, Integer> usuarioid;
	public static volatile SingularAttribute<SegUsuarios, String> nombre;
	public static volatile ListAttribute<SegUsuarios, SegPermisosusuarios> segPermisosusuariosList;
	public static volatile SingularAttribute<SegUsuarios, String> username;

}

