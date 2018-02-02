package application.model;

import java.time.LocalDate;

public class Tilmelding {
    public LocalDate ankomstDato;
    public LocalDate afrejseDato;
    public boolean foredragsholder;

    public Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder) {
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.foredragsholder = foredragsholder;
    }

    /**
     * @return the ankomstDato
     */
    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    /**
     * @param ankomstDato
     *            the ankomstDato to set
     */
    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    /**
     * @return the afrejseDato
     */
    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    /**
     * @param afrejseDato
     *            the afrejseDato to set
     */
    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    /**
     * @return the foredragsholder
     */
    public boolean isForedragsholder() {
        return foredragsholder;
    }

    /**
     * @param foredragsholder
     *            the foredragsholder to set
     */
    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }
}
