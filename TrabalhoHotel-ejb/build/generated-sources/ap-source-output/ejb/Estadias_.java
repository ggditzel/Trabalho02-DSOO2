package ejb;

import ejb.Clientes;
import ejb.Quartos;
import ejb.Servicos;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-07T17:55:51")
@StaticMetamodel(Estadias.class)
public class Estadias_ { 

    public static volatile CollectionAttribute<Estadias, Servicos> servicosCollection;
    public static volatile SingularAttribute<Estadias, String> senha;
    public static volatile SingularAttribute<Estadias, Quartos> quarto;
    public static volatile SingularAttribute<Estadias, Date> entrada;
    public static volatile SingularAttribute<Estadias, BigDecimal> restaurante;
    public static volatile SingularAttribute<Estadias, Clientes> cpf;
    public static volatile SingularAttribute<Estadias, Date> saida;
    public static volatile SingularAttribute<Estadias, Long> id;

}