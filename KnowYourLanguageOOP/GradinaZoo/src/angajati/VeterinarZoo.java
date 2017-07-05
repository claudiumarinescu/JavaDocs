package angajati;

import animale.Animal;
import animale.AnimalZooFeroce;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {

    private int bonus;

    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal.");
        if (animal instanceof AnimalZooFeroce) {
            animal.faceBaie();
        }
        calculeazaBonusSalarial();
    }

    @Override
    public void calculeazaBonusSalarial() {
        this.bonus += 2 * valoareBonusPerAnimal;
    }

    public int getBonus() {
        return this.bonus;
    }
}
