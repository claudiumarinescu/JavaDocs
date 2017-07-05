package angajati;

import animale.Animal;
import animale.AnimalZooRar;
import exceptii.AnimalPeCaleDeDisparitieException;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {

    private int bonus;

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
        calculeazaBonusSalarial();
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException {
        if ((animal instanceof AnimalZooRar) && (mancare == null)) {
            throw  new AnimalPeCaleDeDisparitieException();
        }
        lucreaza(animal);
        animal.faceBaie();
        animal.seJoaca();
        animal.mananca(mancare);
        calculeazaBonusSalarial();
    }

    @Override
    public void calculeazaBonusSalarial() {
        this.bonus += 3 * valoareBonusPerAnimal;
    }

    public int getBonus() {
        return this.bonus;
    }
}
