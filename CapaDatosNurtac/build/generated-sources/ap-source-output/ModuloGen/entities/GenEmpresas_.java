package ModuloGen.entities;

import ModuloSeg.entities.SegUsuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GenEmpresas.class)
public abstract class GenEmpresas_ {

	public static volatile SingularAttribute<GenEmpresas, String> comercial;
	public static volatile SingularAttribute<GenEmpresas, String> estado;
	public static volatile SingularAttribute<GenEmpresas, Integer> empresaid;
	public static volatile SingularAttribute<GenEmpresas, String> replegal;
	public static volatile ListAttribute<GenEmpresas, GenSucursales> genSucursalesList;
	public static volatile SingularAttribute<GenEmpresas, String> nombre;
	public static volatile ListAttribute<GenEmpresas, SegUsuarios> segUsuariosList;
	public static volatile SingularAttribute<GenEmpresas, String> cedreplegal;

}

