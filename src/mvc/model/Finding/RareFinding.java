package mvc.model.Finding;

/**
 * Enum class of the 4 rare Findings to be placed in one of each paths
 *
 */
public enum RareFinding implements Finding {
    DiskOfFaistos(35),
    RingOfMinoa(25),
    JewelOfMalia(25),
    RhytonOfZakros(25);

    final private int value;

    /** <b>Constructor</b>
     * <b>Postcondition</b> Initializes points and name of rare finding
     */
    private RareFinding(int value) {
        this.value = value;
    }

    /** <b>Accessor</b> 
     * <p>
     * <b>Postcondition</b> Returns a string of the description of the finding
     * @return String name of enum
     */
    @Override
    public String getDescription() {
        switch (this) {
            case DiskOfFaistos:
                return "<html>Ανακάλυψες το Δίσκο της Φαιστού!!!;<br>"
                        + "Ο Δίσκος της Φαιστού είναι ένα αρχαιολογικό εύρημα από τη Μινωική πόλη της Φαιστού <br>"
                        + "στη νότια Κρήτη και χρονολογείται πιθανώς στον 17ο αιώνα π.Χ.. Αποτελεί ένα από τα <br>"
                        + "γνωστότερα μυστήρια της αρχαιολογίας, αφού ο σκοπός της κατασκευής του και το νόημα <br>"
                        + "των όσων αναγράφονται σε αυτόν παραμένουν άγνωστα. Ο δίσκος ανακαλύφθηκε στις <br>"
                        + "3 Ιουλίου 1908 από τον Ιταλό αρχαιολόγο Λουίτζι Περνιέ (Luigi Pernier) και φυλάσσεται <br>"
                        + "σήμερα στο Αρχαιολογικό Μουσείο Ηρακλείου.</html>";
            case JewelOfMalia:
                return "<html>Ανακάλυψες το Κόσμημα των Μαλίων!!!;<br>"
                        + "Το χρυσό κόσμημα των μελισσών που φιλοξενείται στο Αρχαιολογικό Μουσείο Ηρακλείου, <br>"
                        + "είναι διάσημο αρχαιολογικό εύρημα από τον Χρυσόλακκο, τον ταφικό περίβολο της νεκρόπολης <br>"
                        + "των Μαλίων. </html>";
            case RhytonOfZakros:
                return "<html> Ανακάλυψες το Ρυτό της Ζάκρου!!!;<br>"
                        + "Το αγγείο βρέθηκε στο θησαυροφυλάκιο του ανακτόρου της Ζάκρου μαζί με άλλα μοναδικά <br> "
                        + "στο είδος τους τελετουργικά σκεύη της νεοανακτορικής εποχής και αποτελεί χαρακτηριστικό <br>"
                        + "παράδειγμα της εφευρετικότητας και καλαισθησίας των Μινωιτών τεχνιτών.</html>";
            case RingOfMinoa:
                return "<html>Ανακάλυψες το Δαχτυλίδι του Μίνωα !!!;<br>"
                        + " Το «Δαχτυλίδι του Μίνωα», ένα από τα μεγαλύτερα και σπανιότερα χρυσά σφραγιδικά στον <br>"
                        + "κόσμο, θεωρείται από τα καλύτερα δείγματα της κρητομυκηναϊκής σφραγιδικής. Φέρει σύνθετη θρησκευτική <br>"
                        + "παράσταση, που απεικονίζει μορφές οι οποίες εντάσσονται στην κρητομυκηναϊκή θεματολογία, δεντρολατρία <br>"
                        + "με καθιστή θεά, ουρανό, γη και θάλασσα, με ιερό πλοίο που έχει μορφή ιππόκαμπου.</html>";
            default:
                throw new AssertionError(this.name());

        }
       
    }

    /** <b>Accessor</b> Overriden method toString
     * <p>
     * <b>Postcondition</b> Returns a string of the name of the enum expression
     *
     * @return String name of enum
     */
    @Override
    public String toString() {
        return this.name();
    }

    /** <b>Accessor</b><p>
     * <b>Postcondition</b> Returns the points value of the Finding
     *
     * @return Integer of the value of the enum
     */
    public int getValue() {
        return value;
    }

    /**
     * Methods for the graphic interface
     *
     * @return String
     */
    @Override
    public String getImage() {
        return "resources/images/findings/"+this.name() +".jpg";
    }

}
