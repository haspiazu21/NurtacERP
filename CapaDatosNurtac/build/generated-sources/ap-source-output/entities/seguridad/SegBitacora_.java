package entities.seguridad;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SegBitacora.class)
public abstract class SegBitacora_ {

	public static volatile SingularAttribute<SegBitacora, String> accion;
	public static volatile SingularAttribute<SegBitacora, Date> fecha;
	public static volatile SingularAttribute<SegBitacora, Integer> codigo;
	public static volatile SingularAttribute<SegBitacora, String> sucursal;
	public static volatile SingularAttribute<SegBitacora, String> usuario;
	public static volatile SingularAttribute<SegBitacora, String> empresa;
	public static volatile SingularAttribute<SegBitacora, String> grupousuario;
	public static volatile SingularAttribute<SegBitacora, String> modulo;

}

