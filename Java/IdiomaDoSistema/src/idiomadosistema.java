import java.util.Locale;

public class idiomadosistema{
    public static void main(String[] args){
        Locale loc = Locale.getDefault();
        System.out.print("O idioma do sistema operacional é o " + loc.getDisplayLanguage());
    }
}