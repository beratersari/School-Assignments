import java.util.ArrayList;

public class User extends Person{
    private ArrayList<String> oylananfilminidsi=new ArrayList<>();
    private ArrayList<String> oylananfilminismi=new ArrayList<>();
    private ArrayList<String> filminoyu=new ArrayList<>();
    public User(String name, String surname, String country, String uniqeId) {
        super(name, surname, country, uniqeId);
    }

    public User() {
        super();
    }
    public void oyudegis(int index, String yenioy){
        filminoyu.set(index,yenioy);

    }
    public void removeVote(int index){
        oylananfilminidsi.remove(index);
        oylananfilminismi.remove(index);
        this.filminoyu.remove(index);

    }
    //bu fonksiyonda film oylama isini yapiyorum kaldirilma durumu olursa
    // idden kaldiriyorum o idnin bulundugu indexi tespit edip filmin oyu arraylistinden de kaldiriyorum
    public void filmoyla(String filmid,String filmismi,String filminoyu){
        oylananfilminidsi.add(filmid);
        oylananfilminismi.add(filmismi);
        this.filminoyu.add(filminoyu);
    }

    public ArrayList<String> getOylananfilminidsi() {
        return oylananfilminidsi;
    }

    public ArrayList<String> getFilminoyu() {
        return filminoyu;
    }


}
