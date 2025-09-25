package es.upm.miw.devops.code;

import java.util.Objects;
import java.util.stream.Stream;

public class Search {

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName){
        return new UsersDatabase().findAll()
                .filter(x->x.getFamilyName().equals(familyName))
                .flatMap(user -> user.getFractions().stream().filter(Objects::nonNull))
                .reduce(Fraction::multiply)
                .orElse(null);
    }


    public Stream<Double> findDecimalImproperFractionByUserName(String name){
        return new UsersDatabase().findAll()
                .filter(x -> x.getName().equals(name))
                .flatMap(user -> user.getFractions().stream().filter(Objects::nonNull))
                .filter(Fraction::isImproper)
                .map(Fraction::decimal);
    }

    public Stream<Double> findDecimalFractionByUserName(String name){
        return new UsersDatabase().findAll()
                .filter(x -> x.getName().equals(name))
                .flatMap(user -> user.getFractions().stream().filter(Objects::nonNull))
                .map(Fraction::decimal);
    }

    public Stream<String> findUserFamilyNameBySomeImproperFraction(){
        return new UsersDatabase().findAll()
                .filter( x-> x.getFractions().stream().anyMatch(Fraction::isImproper))
                .map(User::getFamilyName);
    }
}
