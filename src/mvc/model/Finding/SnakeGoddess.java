package mvc.model.Finding;

/**
 * Represents a finding of statue
 *
 */
public class SnakeGoddess implements Finding {

    /** <b>Accessor</b><p>
     * <b>Postcondition </b> Returns SnakeGoddess
     *
     * @return "SnakeGoddess"
     */
    @Override
    public String toString() {
        return "SnakeGoddess";
    }

    /**
     * Methods for graphic interface
     *
     * @return String of image
     */
    @Override
    public String getImage() {
        return "resources/images/findings/snakes.jpg";
    }

    @Override
    public String getDescription() {
        return "<html>Βρήκες ένα άγαλμα της Θεάς των Φιδιών!!!;<br>"
                + "Ως η θεά με τα φίδια ονομάζεται ο τύπος αγαλματίδιου <br>"
                + "που βρέθηκε σε ανασκαφές στους Μινωικούς αρχαιολογικούς τόπους που <br>"
                + "παρουσιάζει γυναίκα να κρατάει φίδια. Τα αγαλματίδα χρονολογούνται στον <br>"
                + "16ο αιώνα π.Χ.. Λίγες πληροφορίες έχουμε για την ερμηνεία των αγαλματιδίων. <br>"
                + "Ο Έβανς συνδέει την θεά των όφεων με την Αιγυπτιακή θεά Ουατζέτ. Είναι <br>"
                + "προπομπός της κρητικής Ρέας και παρουσιάζει μεγάλη ομοιότητα με την φρυγική Κυβέλη <br> "
                + "και την εφεσία Αρτέμιδα.</html>";
    }

}
