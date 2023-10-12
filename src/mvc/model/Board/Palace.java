package mvc.model.Board;

/**
 * Enumeration Palace consists of the 4 palaces of the game
 */
public enum Palace {
    Knossos, Malia, Phaistos, Zakros;

    /** <b>Accessor</b>
     * <b>Postcondition</b> Returns the name of this enum constant, exactly as declared in its enum declaration.
     *
     * @return the string name of the enum
     */
    @Override
    public String toString() {
        return this.name();
    }

    /** <b>Accessor</b>
     * <b>Postcondition</b> Returns the description of each palace
     *                      for the display.
     *
     * @return String with the description of the palace
     */
    public String getDescription() {
        switch (this) {
            case Knossos:
                return "<html>Έφτασες στο Ανάκτορο της Κνωσού!!!;<br>"
                        + "Το μινωικό ανάκτορο είναι ο κύριος επισκέψιμος χώρος <br>"
                        + "της Κνωσού (ή Κνωσσού), σημαντικής πόλης κατά την αρχαιότητα, <br>"
                        + "με συνεχή ζωή από τα νεολιθικά χρόνια έως τον 5ο αι. Είναι <br>"
                        + "χτισμένο στο λόφο της Κεφάλας, με εύκολη πρόσβαση στη θάλασσα <br>"
                        + "αλλά και στο εσωτερικό της Κρήτης. Κατά την παράδοση, υπήρξε η <br>"
                        + "έδρα του σοφού βασιλιά Μίνωα. Συναρπαστικοί μύθοι, του Λαβύρινθου <br>"
                        + "με το Μινώταυρο και του Δαίδαλου με τον Ίκαρο, συνδέονται με το <br>"
                        + "ανάκτορο της Κνωσσού.</html>";
            case Malia:
                return "<html>Έφτασες στο Ανάκτορο των Μαλίων!!! <br>"
                        + "Ανατολικά από τα σημερινά Μάλια βρίσκεται το μινωικό ανάκτορο των <br>"
                        + "Μαλίων. Είναι το τρίτο σε μέγεθος ανάκτορο της μινωικής Κρήτης και <br>"
                        + "είναι χτισμένο σε μια τοποθεσία προνομιακή, κοντά στη θάλασσα και πάνω <br>"
                        + "στο δρόμο που συνδέει την ανατολική με την κεντρική Κρήτη. Το ανάκτορο <br>"
                        + "των Μαλίων κατά τη μυθολογία χρησίμευε σαν κατοικία του Σαρπηδόνα, αδερφού <br>"
                        + "του Μίνωα, και πρωτοχτίζεται το 1900 π.Χ. Ο προϋπάρχων ισχυρός οικισμός, από <br>"
                        + "τον οποίο σώζονται συνοικίες γύρω από το ανάκτορο, μετατρέπεται έτσι σε <br>"
                        + "ανακτορικό κέντρο-πόλη.</html>";
            case Phaistos:
                return "<html>Έφτασες στο Ανάκτορο της Φαιστού!!!; <br>"
                        + "Το Μινωικό Ανάκτορο της Φαιστού  βρίσκεται στην νότιο-κεντρική Κρήτη, στην <br>"
                        + "πεδιάδα της Μεσαράς, 55 χιλιόμετρα νότια από το Ηράκλειο και σε μικρή απόσταση <br>"
                        + "από τον αρχαιολογικό χώρο στην Αγία Τριάδα, τον αρχαιολογικό χώρο στη Γόρτυνα <br>"
                        + "και τα Μάταλα. Το μινωικό ανάκτορο της Φαιστού αντιστοιχεί σε ακμαία πόλη που, <br>"
                        + "όχι τυχαία, αναπτύχθηκε στην έφορη πεδιάδα της Μεσαράς κατά τους προϊστορικούς <br>"
                        + "χρόνους, δηλαδή από το 6.000 π.Χ. περίπου μέχρι και τον 1ο π.Χ. αιώνα, όπως <br>"
                        + "επιβεβαιώνουν τα αρχαιολογικά ευρήματα.</html>";
            case Zakros:
                return "<html>Έφτασες στο Ανάκτορο της Ζάκρου!!!;<br>"
                        + "Το ανάκτορο της Ζάκρου είναι το τέταρτο σε μέγεθος της Μινωικής Κρήτης. Βρισκόταν <br>"
                        + "σε σημαντικό στρατηγικό σημείο, σε ασφαλισμένο κολπίσκο, και ήταν κέντρο εμπορικών <br>"
                        + "ανταλλαγών με τις χώρες της Ανατολής, όπως φαίνεται από τα ευρήματα (χαυλιόδοντες <br>"
                        + "ελέφαντα, φαγεντιανή, χαλκός κλπ).  Το ανάκτορο αποτέλεσε το κέντρο διοίκησης,<br>"
                        + " θρησκείας και εμπορίου. Το περιστοίχιζε η πόλη. Στο χώρο δεν έγινε νέα οικοδόμηση, <br>"
                        + "εκτός από κάποιες καλλιέργειες. </html>";
            default:
                throw new AssertionError(this.name());

        }
    }
}
