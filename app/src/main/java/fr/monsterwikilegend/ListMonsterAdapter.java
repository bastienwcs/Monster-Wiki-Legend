package fr.monsterwikilegend;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedHashMap;

/**
 * Created by romain on 23/06/16.
 */
public class ListMonsterAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private LinkedHashMap <Long, Monster> listMonstr;

    private static class ViewHolder {
        private TextView txt;
        private ImageView image;
    }

    private static ListMonsterAdapter instance;

    public static ListMonsterAdapter getInstance(Context context) {
        if (instance == null)
            instance = new ListMonsterAdapter(context);
        return instance;
    }

    private ListMonsterAdapter(Context context) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listMonstr = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return listMonstr.size();
    }

    @Override
    public Object getItem(int i) {
        return (Monster) listMonstr.values().toArray()[i];
    }

    @Override
    public long getItemId(int i) {
        Monster m = (Monster) getItem(i);
        return m.getId();
    }

    public Monster getMonsterById(long id) {                                                                    // Retourne un objet de type Monster en fonction de son Id
        return listMonstr.get(id);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {             // Cette métode retourne l'objet View à afficher pour la ligne à la position demandée
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.ligne, null);					// création de la vue en fonction du fichier XML ligne_liste.xml si elle n'existe pas (le paramètre convertView est null).
            holder = new ViewHolder();
            holder.txt 		= (TextView)convertView.findViewById(R.id.txtType);		    // On créé et sauvegarde le composant TextView dans la classe Holder
            holder.image 	= (ImageView) convertView.findViewById(R.id.imgType);       // Idem pour ImageView
            convertView.setTag(holder);													// La classe holder est positionnée dans la zone Tag du composant convertView pour la prochaine fois que l'on doit réafficher cette ligne
        }
        else
            holder = (ViewHolder)convertView.getTag();									// La vue existe déjà, on récupère le mappage des composants (holder) dans le Tag

        Monster m = (Monster) getItem(position);									    // On récupère l'étudiant correspondant à la position passée en paramètre
        holder.txt.setText(m.getName()/*.toUpperCase()*/);								// on positionne ou raffraichit les informations de la vue selon le cas

        int imgResourceId;
        switch ((int)m.getTypeId()) {                                                   // initialisation de la variable imgResourceId en fonction de la valeur du type de monstre
            case 1 : imgResourceId = R.drawable.eau;break;
            case 2 : imgResourceId = R.drawable.feu;break;
            case 3 : imgResourceId = R.drawable.foudre;break;
            case 4 : imgResourceId = R.drawable.lumiere;break;
            case 5 : imgResourceId = R.drawable.magie;break;
            case 6 : imgResourceId = R.drawable.metal;break;
            case 7 : imgResourceId = R.drawable.mort;break;
            case 8 : imgResourceId = R.drawable.nature;break;
            case 9 : imgResourceId = R.drawable.terre;break;
            case 10 : imgResourceId = R.drawable.special;break;
            default : imgResourceId = -1;
        }

        if (imgResourceId != -1)
            holder.image.setImageBitmap(BitmapFactory.decodeResource(inflater.getContext().getResources(), imgResourceId));

        return convertView;
    }

    public void addMonster(Monster monster) {                                           // Ajoute un objet Monstre à la liste
        listMonstr.put(monster.getId(), monster);
    }
}
