package Chat;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private List<String> pseudoList;
    private List<String> chat;

    public Chat() {

        this.pseudoList = new ArrayList<>();
        this.pseudoList.add("Shadowfax");
        this.pseudoList.add("MysticMuse");
        this.pseudoList.add("DreamWeaver");
        this.pseudoList.add("WildWanderer");
        this.pseudoList.add("Nightingale");
        this.pseudoList.add("SilverStorm");
        this.pseudoList.add("CrimsonTide");
        this.pseudoList.add("MoonlitMirage");
        this.pseudoList.add("BlazePhoenix");
        this.pseudoList.add("OceanSoul");
        this.pseudoList.add("EmberEnigma");
        this.pseudoList.add("CelestialSiren");
        this.pseudoList.add("SunflowerSoul");
        this.pseudoList.add("MidnightMystery");
        this.pseudoList.add("MysticMoon");
        this.pseudoList.add("GalaxyGazer");
        this.pseudoList.add("MysticMelody");
        this.pseudoList.add("NorthernLights");
        this.pseudoList.add("WhisperingWillow");
        this.pseudoList.add("SkywardSoul");
        this.pseudoList.add("EmeraldEcho");
        this.pseudoList.add("EnchantedEagle");
        this.pseudoList.add("MysticMeadow");
        this.pseudoList.add("CrimsonCrest");
        this.pseudoList.add("DreamDancer");
        this.pseudoList.add("RadiantRainbow");
        this.pseudoList.add("FireflyFury");
        this.pseudoList.add("MysticMountain");
        this.pseudoList.add("Thunderbolt");
        this.pseudoList.add("OceanicOrbit");
        this.pseudoList.add("SunsetSiren");
        this.pseudoList.add("MysticMist");
        this.pseudoList.add("LunarLullaby");
        this.pseudoList.add("EnchantedEcho");
        this.pseudoList.add("StarryNight");
        this.pseudoList.add("MysticMosaic");
        this.pseudoList.add("RubyRipple");
        this.pseudoList.add("CosmicCrescendo");
        this.pseudoList.add("MysticMaelstrom");
        this.pseudoList.add("GoldenGlitter");
        this.pseudoList.add("SnowySummit");
        this.pseudoList.add("OceanicOasis");
        this.pseudoList.add("MysticMandala");
        this.pseudoList.add("MysticMagma");
        this.pseudoList.add("LunarLuminosity");
        this.pseudoList.add("MountainMystic");
        this.pseudoList.add("MysticMirage");
        this.pseudoList.add("CrystalCove");
        this.pseudoList.add("MysticMurmur");
        this.pseudoList.add("OceanicOpulence");



        this.chat = new ArrayList<>();
        this.chat.add("Salut tout le monde !");
        this.chat.add("Bienvenue dans le chat !");
        this.chat.add("N'oubliez pas de vous abonner !");
        this.chat.add("On est en train de battre tous les records !");
        this.chat.add("Comment allez-vous aujourd'hui ?");
        this.chat.add("Je suis tellement heureux/se que vous soyez là !");
        this.chat.add("Merci d'être venu/e !");
        this.chat.add("J'adore ce jeu !");
        this.chat.add("C'est ma première fois que je joue à ce jeu !");
        this.chat.add("Vous avez des conseils pour moi ?");
        this.chat.add("Je suis un/une débutant/e !");
        this.chat.add("Vous êtes tous les meilleurs !");
        this.chat.add("Je suis tellement excité/e pour ce stream !");
        this.chat.add("Je suis prêt/e à passer un bon moment !");
        this.chat.add("J'adore interagir avec vous !");
        this.chat.add("Vous avez des idées pour les prochains streams ?");
        this.chat.add("Comment s'est passé votre journée ?");
        this.chat.add("On va passer un moment incroyable ensemble !");
        this.chat.add("Je suis tellement heureux/se de faire ce stream avec vous !");
        this.chat.add("Vous êtes tous tellement gentils !");
        this.chat.add("J'adore cette communauté !");
        this.chat.add("Je suis un/une grand/e fan de ce jeu !");
        this.chat.add("Je suis un/une grand/e fan de vous !");
        this.chat.add("Vous êtes tous tellement talentueux/ses !");
        this.chat.add("N'oubliez pas de donner un like si vous appréciez le stream !");
        this.chat.add("Avez-vous vu le dernier trailer de ce jeu ?");
        this.chat.add("Je suis impressionné/e par vos compétences !");
        this.chat.add("Vous êtes tous tellement drôles !");
        this.chat.add("Je suis tellement content/e que vous soyez là !");
        this.chat.add("On va passer un moment inoubliable !");
        this.chat.add("Je suis prêt/e à tout donner !");
        this.chat.add("N'oubliez pas de partager le stream avec vos amis !");
        this.chat.add("Vous êtes tous des légendes !");
        this.chat.add("Je suis tellement excité/e pour les prochains streams !");
        this.chat.add("J'ai hâte de vous montrer mes compétences !");
        this.chat.add("N'oubliez pas de suivre le stream pour ne rien rater !");
        this.chat.add("Vous êtes tous tellement inspirants !");
        this.chat.add("Je suis un/une grand/e fan de cette communauté !");
        this.chat.add("Je suis tellement reconnaissant/e pour votre soutien !");
        this.chat.add("Je suis tellement fier/fière de faire partie de cette communauté !");
        this.chat.add("Vous êtes tous tellement gentils et bienveillants !");
        this.chat.add("J'adore passer du temps avec vous !");
        this.chat.add("Je suis tellement reconnaissant/e pour vos dons !");
        this.chat.add("N'oubliez pas de vous abonner pour avoir accès à des avantages exclusifs !");
        this.chat.add("Vous êtes tous tellement talentueux/ses !");
    }
    public String getRandomPseudo() {
        int index = (int) (Math.random() * pseudoList.size());
        return pseudoList.get(index);
    }
    public String getRandomChatPhrase() {
        int index = (int) (Math.random() * chat.size());
        return chat.get(index);
    }


}
