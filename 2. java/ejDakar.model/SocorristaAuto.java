package dakar.model;

import java.sql.SQLOutput;

public class SocorristaAuto implements ISocorristaAuto{
    @Override
    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo auto: " + unAuto.getPatente());
    }
}
