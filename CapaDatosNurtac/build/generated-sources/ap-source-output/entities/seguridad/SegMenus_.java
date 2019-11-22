package entities.seguridad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SegMenus.class)
public abstract class SegMenus_ {

	public static volatile SingularAttribute<SegMenus, String> estado;
	public static volatile SingularAttribute<SegMenus, Boolean> guardar;
	public static volatile ListAttribute<SegMenus, SegPermisosgrupos> segPermisosgruposList;
	public static volatile SingularAttribute<SegMenus, String> imagen;
	public static volatile SingularAttribute<SegMenus, Boolean> imprimir;
	public static volatile SingularAttribute<SegMenus, SegModulos> moduloid;
	public static volatile SingularAttribute<SegMenus, String> nombre;
	public static volatile ListAttribute<SegMenus, SegPermisosusuarios> segPermisosusuariosList;
	public static volatile SingularAttribute<SegMenus, String> formulario;
	public static volatile SingularAttribute<SegMenus, Boolean> eliminar;
	public static volatile SingularAttribute<SegMenus, Boolean> buscar;
	public static volatile SingularAttribute<SegMenus, Integer> menuid;
	public static volatile SingularAttribute<SegMenus, Boolean> modificar;
	public static volatile SingularAttribute<SegMenus, SegTiposmenu> tipomenuid;
	public static volatile SingularAttribute<SegMenus, Boolean> anular;

}

