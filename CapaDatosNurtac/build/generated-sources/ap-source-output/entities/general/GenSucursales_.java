package entities.general;

import entities.seguridad.SegUsuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GenSucursales.class)
public abstract class GenSucursales_ {

	public static volatile SingularAttribute<GenSucursales, String> ruc;
	public static volatile SingularAttribute<GenSucursales, String> estado;
	public static volatile SingularAttribute<GenSucursales, GenEmpresas> empresaid;
	public static volatile SingularAttribute<GenSucursales, Integer> sucursalid;
	public static volatile SingularAttribute<GenSucursales, String> direccion;
	public static volatile SingularAttribute<GenSucursales, String> telefono;
	public static volatile SingularAttribute<GenSucursales, String> nombre;
	public static volatile SingularAttribute<GenSucursales, String> email;
	public static volatile ListAttribute<GenSucursales, SegUsuarios> segUsuariosList;

}

