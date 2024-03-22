package files.interfacecsp;

import java.util.List;

/**
 * This class represents a generic Domain.
 * @param <type> the type of the domain
 * @author Lillo GAVOIS
 * @version 1.0
 */
public abstract class Domain<type> {
    private final List<type> list;
    public Domain(List<type> list){
        this.list = list;
    }
    public boolean isEnd(int pos){
        return list.size() <= pos;
    }
    public type get(int pos){
        return list.get(pos);
    }
    public void remove(int pos){list.remove(pos);}
    public Domain<type> getDomain(){return this;}
    public int size(){return list.size();};
}
