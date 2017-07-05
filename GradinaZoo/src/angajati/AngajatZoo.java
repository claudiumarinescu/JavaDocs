package angajati;

import animale.Animal;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public interface AngajatZoo {

    Integer valoareBonusPerAnimal = 50;
    void lucreaza(Animal animal);
    void calculeazaBonusSalarial();
    int getBonus();

}
