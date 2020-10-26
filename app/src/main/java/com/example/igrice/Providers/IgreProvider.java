package com.example.igrice.Providers;

import com.example.igrice.Model.Igre;

import java.util.ArrayList;
import java.util.List;

public class IgreProvider {

    private static List<Igre> igre = null;
    private static List<Igre> igreByKategorija = null;
    private static List<String> kategorije = null;

    private static void init() {
        if (igre == null) {
            igre = new ArrayList<>();
            igre.add(new Igre(0, "CyberPunk 2077", "Cyberpunk 2077 is an open-world, action-adventure story set in Night City, a megalopolis obsessed with power, glamour and body modification." +
                    " You play as V, a mercenary outlaw going after a one-of-a-kind implant that is the key to immortality.", "Shooter", "cyberpunk2077.jpg", 100.00));
            igre.add(new Igre(1, "FIFA 21", "FIFA 21 is a football simulation video game published by Electronic Arts as part of the FIFA series. It is the 28th installment in the FIFA series, " +
                    "and was released 9 October 2020 for Microsoft Windows, Nintendo Switch, PlayStation 4, and Xbox One", "Sport", "fifa21.jpeg", 55.50));
            igre.add(new Igre(2, "Horizon Forbidden West", "Horizon Forbidden West is an upcoming action role-playing game developed by Guerrilla Games and published " +
                    "by Sony Interactive Entertainment, and set to be released in 2021 for the PlayStation 4 and PlayStation 5", "Action-adventure", "horizonforbwest.jpg", 90.50));
            igre.add(new Igre(3, "Hitman 3", "Hitman 3 is an upcoming stealth game developed and published by IO Interactive. The game will be the eighth main installment in the Hitman series " +
                    "and the third and final installment of the World of Assassination trilogy, following Hitman and Hitman 2.", "Shooter", "hitman3.jpg", 100.00));
            igre.add(new Igre(4, "Hogwarts Legacy", "Hogwarts Legacy is an upcoming action role-playing video game set in the late 1800s in the Wizarding World being developed by Avalanche " +
                    "Software and published by Portkey Games. The game will be released for Microsoft Windows, PlayStation 4, PlayStation 5, Xbox One, and Xbox Series X/S in 2021.", "Adventure", "HogwartsLegacy.png", 100.00));
            igre.add(new Igre(5, "Far Cry 6", "Far Cry 6 is an upcoming first-person shooter game developed by Ubisoft Toronto and published by Ubisoft. It is the sixth main installment of the Far Cry series, and expected to be " +
                    "released on February 18, 2021 for Amazon Luna, Microsoft Windows, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X/S, and Stadia.", "Shooter", "farcry.jfif", 100.00));
            igre.add(new Igre(6, "Roller Champions", "Roller Champions is an upcoming free-to-play sports game developed by Ubisoft Montreal and published by Ubisoft. It is set to be released for Microsoft Windows, " +
                    "Xbox One, PlayStation 4, Nintendo Switch and mobile devices in 2021.", "Sport", "rollerchamp.jpg", 100.00));
            igre.add(new Igre(7, "DOOM Eternal", "Doom Eternal is a first-person shooter video game developed by id Software and published by Bethesda Softworks.", "Shooter", "doom.jpg", 100.00));
            igre.add(new Igre(8, "The Last of Us Part II", "The Last of Us Part II is a 2020 action-adventure game developed by Naughty Dog and published by Sony Interactive Entertainment for the PlayStation 4.",
                    "Adventure", "lastofus2.jpg", 100.00));
            igre.add(new Igre(9, "Assassin's Creed Valhalla", "Assassin's Creed Valhalla is an upcoming action role-playing video game developed by Ubisoft Montreal and published by Ubisoft. It is the twelfth major " +
                    "installment and the twenty-second release in the Assassin's Creed series, and a successor to the 2018 game Assassin's Creed Odyssey.", "Adventure", "assvalh.jfif", 100.00));
            igre.add(new Igre(10, "WRC 9", "WRC 9, also known as WRC 9: World Rally Championship, is the official racing video game of the 2020 World Rally Championship.", "Race", "wrc.jpg", 100.00));
            igre.add(new Igre(11, "Tom Clancy's Rainbow Six Quarantine", "Tactical shooter.", "Shooter", "rsq.jpg", 100.00));
            igre.add(new Igre(12, "Crash Bandicoot 4: It's About Time", "Crash Bandicoot 4: It's About Time is a platform game developed by Toys for Bob and published by Activision.", "Shooter", "crashb.jpg", 100.00));
            igre.add(new Igre(13, "Outriders", "Outriders is an upcoming third-person shooter developed by People Can Fly and published by Square Enix.", "Shooter", "outr.jpg", 100.00));
            igre.add(new Igre(14, "Godfall", "Godfall is an upcoming action role-playing game developed by Counterplay Games and published by Gearbox Publishing.", "Adventure", "godfall.png", 100.00));
            igre.add(new Igre(15, "Halo Infinite", "Halo Infinite is an upcoming first-person shooter game developed by 343 Industries and published by Xbox Game Studios for Microsoft Windows, Xbox One, and Xbox Series X and Series S" +
                    "", "Shooter", "haloinf.jfif", 100.00));
        }
    }

    public static List<Igre> getAllIgrice() {
        init();
        return igre;
    }

    public static List<String> getKategorije() {
        init();
        kategorije = new ArrayList<>();

        for (int i = 0; i < igre.size(); i++) {
            if (!kategorije.contains(igre.get(i).getKategorija()))
                kategorije.add(igre.get(i).getKategorija());
        }

        return kategorije;
    }

    public static List<Igre> getAllIgreByKategorija(String kategorija) {
        init();

        igreByKategorija = new ArrayList<>();

        for (int i = 0; i < igre.size(); i++) {
            if (getIgreById(i).getKategorija().equals(kategorija))
                igreByKategorija.add(igre.get(i));
        }

        return igreByKategorija;
    }

    public static Igre getIgreById(int id) {
        init();

        if (id >= 0 && id < igre.size()) {
            return igre.get(id);
        }
        return null;
    }

    public static Igre getIgreByNaziv(String naziv) {
        init();

        for (int i = 0; i < igre.size(); i++) {
            if (igre.get(i).getNazivIgrice().equals(naziv))
                return igre.get(i);
        }
        return null;
    }
}
