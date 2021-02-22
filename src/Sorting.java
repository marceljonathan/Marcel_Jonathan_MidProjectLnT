
import java.util.Comparator;
public class Sorting implements Comparator <KaryawanClone>{

	@Override
	public int compare(KaryawanClone o1, KaryawanClone o2) {
		// TODO Auto-generated method stub
		return o1.getNamaClone().compareToIgnoreCase(o2.getNamaClone());
	}

}
