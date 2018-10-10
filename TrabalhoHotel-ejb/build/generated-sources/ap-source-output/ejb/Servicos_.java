package ejb;

import ejb.Estadias;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-10T17:09:28")
@StaticMetamodel(Servicos.class)
public class Servicos_ { 

    public static volatile SingularAttribute<Servicos, BigDecimal> valor;
    public static volatile SingularAttribute<Servicos, Integer> id;
    public static volatile CollectionAttribute<Servicos, Estadias> estadiasCollection;
    public static volatile SingularAttribute<Servicos, String> descricao;

}