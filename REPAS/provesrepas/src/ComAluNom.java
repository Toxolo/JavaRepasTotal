
import java.util.Comparator;

public class ComAluNom implements Comparator<Alumne> {

    @Override
    public int compare(Alumne alu1, Alumne alu2) {
        return alu1.getNom().compareTo(alu2.getNom());
    }
    
}
