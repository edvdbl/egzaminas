package sample;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String VALID_ID_REGEX ="^[0-9]{1,7}$";
    private static final String VALID_MIESTAS_REGEX ="^[A-Za-z ]{1,1000}$";
    private static final String VALID_VARDAS_REGEX ="^[A-Za-z ]{1,1000}$";
    private static final String VALID_ELPASTAS_REGEX ="^^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static final String VALID_ATSILIEPIMAS_REGEX ="^[A-Za-z ]{1,1000}$";


    public static boolean isValidID(String id){
        Pattern idPattern = Pattern.compile(VALID_ID_REGEX);
        Matcher idMatcher = idPattern.matcher(id);
        return idMatcher.find();
    }

    public static boolean isValidMiestas(String miestas){
        Pattern miestasPattern = Pattern.compile(VALID_MIESTAS_REGEX);
        Matcher miestasMatcher = miestasPattern.matcher(miestas);
        return miestasMatcher.find();
    }

    public static boolean isValidVardas(String vardas){
        Pattern vardasPattern = Pattern.compile(VALID_VARDAS_REGEX);
        Matcher vardasMatcher = vardasPattern.matcher(vardas);
        return vardasMatcher.find();
    }

    public static boolean isValidElPastas(String elpastas){
        Pattern elpastasPattern = Pattern.compile(VALID_ELPASTAS_REGEX);
        Matcher elpastasMatcher = elpastasPattern.matcher(elpastas);
        return elpastasMatcher.find();
    }

    public static boolean isValidAtsiliepimas(String atsiliepimas){
        Pattern atsiliepimasPattern = Pattern.compile(VALID_ATSILIEPIMAS_REGEX);
        Matcher atsiliepimasMatcher = atsiliepimasPattern.matcher(atsiliepimas);
        return atsiliepimasMatcher.find();
    }
}
