import java.util.List;

public class Domain<type> {
    private final List<type> list;
    public Domain(List<type> list){
        this.list = list;
    }
    public boolean isEnd(int pos){
        return list.size() == pos;
    }
    public type get(int pos){
        return list.get(pos);
    }
}
