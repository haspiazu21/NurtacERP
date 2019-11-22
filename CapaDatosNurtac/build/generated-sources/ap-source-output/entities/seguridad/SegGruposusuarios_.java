package entities.seguridad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SegGruposusuarios.class)
public abstract class SegGruposusuarios_ {

	public static volatile SingularAttribute<SegGruposusuarios, Integer> grupousuarioid;
	public static volatile SingularAttribute<SegGruposusuarios, String> descripcion;
	public static volatile SingularAttribute<SegGruposusuarios, String> estado;
	public static volatile ListAttribute<SegGruposusuarios, SegPermisosgrupos> segPermisosgruposList;
	public static volatile SingularAttribute<SegGruposusuarios, String> nombre;
	public static volatile ListAttribute<SegGruposusuarios, SegUsuarios> segUsuariosList;

}

