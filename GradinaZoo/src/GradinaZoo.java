import angajati.IngrijitorZoo;
import animale.AnimalZooRar;

import java.util.Date;

/**
 * Created by Claudiu.Marinescu on 7/4/2017.
 */
public final class GradinaZoo {
    private final String denumireGradinaZoo;
    private Date dataDeschideriiGradinii;
    private AnimalZooRar animalRar;
    private IngrijitorZoo angajatulLunii;

    public GradinaZoo(String nume, Date dataDeschidere) {
        this.denumireGradinaZoo = nume;
        this.dataDeschideriiGradinii = dataDeschidere;
    }

    public GradinaZoo(String nume, Date dataDeschidere, AnimalZooRar animal, IngrijitorZoo ang) {
        this.denumireGradinaZoo = nume;
        this.dataDeschideriiGradinii = dataDeschidere;
        this.setAnimalRar(animal);
        this.setAngajatulLunii(ang);
    }

    public Date getDataDeschideriiGradinii() {
        return this.dataDeschideriiGradinii;
    }

    public String getDenumireGradinaZoo() {
        return this.denumireGradinaZoo;
    }

    public AnimalZooRar getAnimalRar() {
        return animalRar;
    }

    public void setAnimalRar(AnimalZooRar animalRar) {
        this.animalRar = animalRar;
    }

    public IngrijitorZoo getAngajatulLunii() {
        return angajatulLunii;
    }

    public void setAngajatulLunii(IngrijitorZoo angajatulLunii) {
        this.angajatulLunii = angajatulLunii;
    }
}
