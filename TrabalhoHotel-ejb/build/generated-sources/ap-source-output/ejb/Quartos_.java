package ejb;

import ejb.Estadias;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-07T17:55:51")
@StaticMetamodel(Quartos.class)
public class Quartos_ { 

    public static volatile SingularAttribute<Quartos, Integer> camasolteiro;
    public static volatile SingularAttribute<Quartos, Integer> banheira;
    public static volatile SingularAttribute<Quartos, Integer> ar;
    public static volatile SingularAttribute<Quartos, String> tipo;
    public static volatile SingularAttribute<Quartos, Integer> tv;
    public static volatile SingularAttribute<Quartos, Integer> numero;
    public static volatile SingularAttribute<Quartos, BigDecimal> diaria;
    public static volatile SingularAttribute<Quartos, Integer> frigobar;
    public static volatile SingularAttribute<Quartos, Integer> camacasal;
    public static volatile CollectionAttribute<Quartos, Estadias> estadiasCollection;

}