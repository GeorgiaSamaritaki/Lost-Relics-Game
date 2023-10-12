package mvc.model.Finding;
/**
 * Represents a fresco ingame
 */
public enum Fresco implements Finding {
    fresco1(20),
    fresco2(20),
    fresco3(15),
    fresco4(20),
    fresco5(15),
    fresco6(15);
    final private int value;
    private final String Image;

    /** <b>Constructor</b>
     * <b>Postcondition</b> Initializes points and name of rare finding
     */
    private Fresco(int value) {
        this.value = value;
        this.Image = "resources/images/findings/" + this.name() + "_" + this.getValue() + ".jpg";
    }

    /** <b>Accessor</b> Overridden method toString
     * <p>
     * <b>Postcondition</b> Returns a string of the name of the enum expression
     *
     * @return String name of enumeration
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
        return Image;
    }

    @Override
    public String getDescription() {
        switch (this) {
            case fresco1:
                return "<html>Φωτογράφισες την Τοιχογραφία: Οι γαλάζεις κυρίες!!!; <br>"
                        + "Όμορφες Μινωίτισσες που κουβεντιάζουν. Έχουν ωραία φορέματα, <br>"
                        + "σύμφωνα με τη μόδα της εποχής, όμορφα χτενισμένα μαλλιά και <br>"
                        + "πολύτιμα κοσμήματα.</html>";
            case fresco2:
                return "<html>Φωτογράφισες την Τοιχογραφία: Τα ταυροκαθάψια!!!;<br>"
                        + "Τα ταυροκαθάψια ήταν ένα αγώνισμα που συνηθιζόταν πολύ στα <br>"
                        + "μινωικά χρόνια. Περιλάμβανε το πιάσιμο του ταύρου από τα <br>"
                        + "κέρατα, το επικίνδυνο άλμα στη ράχη του ζώου και τέλος το πήδημα <br>"
                        + "στο έδαφος πίσω του.</html>";
            case fresco3:
                return "<html>Φωτογράφισες την Τοιχογραφία: Τα δελφίνια!!!;<br>"
                        + "Η τοιχογραφία αυτή προέρχεται από τo μέγαρο της βασίλισσας. <br>"
                        + "Δελφίνια κολυμπούν ανάμεσα σε ψάρια, μέσα στα κύματα.</html>";
            case fresco4:
                return "<html>Φωτογράφισες την Τοιχογραφία: Ο πρίγκιπας με τα κρίνα;<br>"
                        + "Εικονίζεται επιβλητική ανδρική μορφή, που βαδίζει προς τα αριστερά <br>"
                        + "σε απροσδιόριστο ερυθρό φόντο. Φοράει το τυπικό μινωικό περίζωμα με <br>"
                        + "φαρδιά ζώνη, περιδέραιο στο λαιμό και πλούσιο κάλυμμα κεφαλής διακοσμημένο <br>"
                        + "με κρίνα και φτερά παγωνιού. Η στάση των χεριών του δείχνει ότι ίσως έσερνε <br>"
                        + "με το αριστερό του χέρι ένα ζώο ή κάποιο μυθικό τέρας, γρύπα ή σφίγγα. <br>"
                        + "Ο νέος ονομάσθηκε από τους ερευνητές «πρίγκηπας», γιατί θεωρήθηκε ότι αποδίδει <br>"
                        + "το βασιλιά-ιερέα, που ζούσε στο ανάκτορο της Κνωσού.!!!</html>";
            case fresco5:
                return "<html>Φωτογράφισες την Τοιχογραφία: Πομπή νέων!!!;<br>"
                        + "Νέοι λαμβάνουν μέρος σε θρησκευτική πομπή και φέρουν αγγεία με δώρα για <br>"
                        + "τη θεότητα ή για το βασιλιά. Η τοιχογραφία αυτή κοσμούσε τον λεγόμενο «διάδρομο <br>"
                        + "της πομπής» του ανακτόρου της Κνωσού.</html>";
            case fresco6:
                return "<html>Φωτογράφισες την Τοιχογραφία: Η παριζιάνα!!!<br>"
                        + "Εικονίζεται μια γυναίκα αριστοκρατικής καταγωγής σε θέση προφίλ.  Ονομάστηκε <br>"
                        + "«Παριζιάνα» από τον Άρθουρ Έβανς, γιατί το 1903 (έτος που ανακαλύφθηκε) τα <br>"
                        + "μεγάλα μάτια, τα κατσαρά μαλλιά, τα έντονα κόκκινα χείλη και η ανασηκωμένη <br>"
                        + "μύτη θεωρούνταν τα ιδεώδη της γυναικείας ομορφιάς, τα οποία μόνο μια όμορφη <br>"
                        + "γυναίκα από … το Παρίσι μπορούσε να τα ενσαρκώσει.</html>";
            default:
                throw new AssertionError(this.name());

        }
    }

}
