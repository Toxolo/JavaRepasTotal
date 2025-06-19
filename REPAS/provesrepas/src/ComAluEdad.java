
import java.util.Comparator;

public class  ComAluEdad implements Comparator<Alumne> {

    @Override
    public int compare(Alumne alu1, Alumne alu2) {
        return alu1.getEdat() - alu2.getEdat();

        
    }

}
