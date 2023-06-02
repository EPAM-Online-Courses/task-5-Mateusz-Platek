package efs.task.collections.data;

import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.*;
import java.util.stream.Collectors;

public class DataProvider {

    public static final String DATA_SEPARATOR = ",";

    // TODO Utwórz listę miast na podstawie tablicy Data.baseTownsArray.
    //  Tablica zawiera String zawierający nazwę miasta oraz dwie klasy bohatera związane z tym miastem oddzielone przecinkami.
    //  Korzystając z funkcji split() oraz stałej DATA_SEPARATOR utwórz listę obiektów klasy efs.task.collections.entities.Town.
    //  Funkcja zwraca listę obiektów typu Town ze wszystkimi dziewięcioma podstawowymi miastami.
    public List<Town> getTownsList() {
        return Arrays.stream(Data.baseTownsArray).map(line -> {
            String[] split = line.split(DATA_SEPARATOR);
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].trim();
            }
            return new Town(split[0], Arrays.asList(split[1], split[2]));
        }).collect(Collectors.toList());
    }

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        return Arrays.stream(Data.dlcTownsArray).map(line -> {
            String[] split = line.split(DATA_SEPARATOR);
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].trim();
            }
            return new Town(split[0], Arrays.asList(split[1], split[2]));
        }).collect(Collectors.toList());
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
        return Arrays.stream(Data.baseCharactersArray).map(line -> {
            String[] split = line.split(DATA_SEPARATOR);
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].trim();
            }
            return new Hero(split[0], split[1]);
        }).collect(Collectors.toSet());
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        return Arrays.stream(Data.dlcCharactersArray).map(line -> {
            String[] split = line.split(DATA_SEPARATOR);
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].trim();
            }
            return new Hero(split[0], split[1]);
        }).collect(Collectors.toSet());
    }
}
