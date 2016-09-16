package fr.monsterwikilegend;

/**
 * Created by romain on 23/06/16.
 */
public class Monster {
    private String name;
    private long id;
    private long typeId;
    private SkillSet[] skills;
    private String urlEgg;
    private String urlEvo;

    public Monster(long pId, String pNom, long pType, SkillSet[] skills, String pUrlEgg, String pUrlEvo) {
        this.id = pId;
        this.name = pNom;
        this.typeId = pType;
        this.skills = skills;
        this.urlEgg = pUrlEgg;
        this.urlEvo = pUrlEvo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getUrlEgg() {
        return urlEgg;
    }

    public void setUrlEgg(String urlEgg) {
        this.urlEgg = urlEgg;
    }

    public String getUrlEvo() {
        return urlEvo;
    }

    public void setUrlEvo(String urlEvo) {
        this.urlEvo = urlEvo;
    }

    public SkillSet getSkillSetByEvol(int evol){
        return this.skills[evol];
    }

    public String getTypeElement() {
        switch ((int)typeId) {
            case 1 : return "Eau";
            case 2 : return "Feu";
            case 3 : return "Foudre";
            case 4 : return "Lumière";
            case 5 : return "Magie";
            case 6 : return "Métal";
            case 7 : return "Mort";
            case 8 : return "Nature";
            case 9 : return "Terre";
            case 10 : return "Spécial";
            default : return "";
        }
    }

}
