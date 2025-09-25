package es.upm.miw.devops.code;

import java.util.Objects;
import java.util.stream.Stream;

public class Search {

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName){
        return new UsersDatabase().findAll()
                .filter(x->x.getFamilyName()==familyName)
                .flatMap(user -> user.getFractions().stream().filter(Objects::nonNull))
                .reduce(Fraction::multiply)
                .orElse(null);
    }
}
