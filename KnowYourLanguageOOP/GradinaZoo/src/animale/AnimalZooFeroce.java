package animale;

import angajati.AngajatZoo;
import exceptii.AnimalManancaAnimalException;
import exceptii.AnimalManancaOmException;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {


    @Override
    public void mananca(Object o) {
        if (o instanceof AngajatZoo) {
            throw new AnimalManancaOmException();
        } else if (o instanceof Animal) {
            throw new AnimalManancaAnimalException();
        } else {
            System.out.println("AnimalulZooFeroce mananca.");
        }
    }

    @Override
    public void seJoaca() {
        System.out.println("AnimalulZooFeroce se joaca.");
        doarme();
    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalulZooFeroce face baie.");
    }

    public void doarme() {
        super.doarme();
        System.out.println("Animalul feroce vaneaza.");
    }
}
