package animale;

import angajati.AngajatZoo;
import exceptii.AnimalManancaAnimalException;
import exceptii.AnimalManancaOmException;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public class AnimalZooRar extends Animal {

    private String nume;
    private String numeTaraOrigine;

    public AnimalZooRar() {}

    public AnimalZooRar(String nume) {
        this.nume = nume;
    }

    public AnimalZooRar(String nume, String taraOrigine) {
        this.nume = nume;
        this.numeTaraOrigine = taraOrigine;
    }

    @Override
    public void mananca(Object o) {
        if (o instanceof AngajatZoo) {
            throw new AnimalManancaOmException();
        } else if (o instanceof Animal) {
            throw new AnimalManancaAnimalException();
        } else {
            System.out.println("AnimalulZooRar mananca.");
        }
    }

    @Override
    public void seJoaca() {
        System.out.println("AnimalulZooRar se joaca.");
        super.doarme();
    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalulZooRar face baie.");
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumeTaraOrigine() {
        return numeTaraOrigine;
    }

    public void setNumeTaraOrigine(String numeTaraOrigine) {
        this.numeTaraOrigine = numeTaraOrigine;
    }
}
