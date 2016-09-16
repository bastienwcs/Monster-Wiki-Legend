package fr.monsterwikilegend;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private ListMonsterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = ListMonsterAdapter.getInstance(this);         // récupère une instance de la classe

        adapter.addMonster(new Monster(1,"Fire Lion",2,new SkillSet[]{new SkillSet(2480,100,875,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"fire_lion_0.jpg","fire_lion_all.jpg"));
        adapter.addMonster(new Monster(2,"Rockilla",9,new SkillSet[]{new SkillSet(875,3521,875,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"rockilla_0.jpg","rockilla_all.jpg"));
        adapter.addMonster(new Monster(3,"Turtle",1,new SkillSet[]{new SkillSet(1000,2777,1000,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"turtle_0.jpg","turtle_all.jpg"));
        adapter.addMonster(new Monster(4,"Panda",8,new SkillSet[]{new SkillSet(950,2777,1000,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"panda_0.jpg","panda_all.jpg"));
        adapter.addMonster(new Monster(5,"Thunder eagle",3,new SkillSet[]{new SkillSet(875,2480,1250,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"thunder_eagle_0.jpg","thunder_eagle_all.jpg"));
        adapter.addMonster(new Monster(6,"Light Spirit",4,new SkillSet[]{new SkillSet(875,3521,875,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"light_spirit_0.jpg","light_spirit_all.jpg"));
        adapter.addMonster(new Monster(7,"Tyrannoking",7,new SkillSet[]{new SkillSet(1150,2480,875,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"tyrannoking_0.jpg","tyrannoking_all.jpg"));
        adapter.addMonster(new Monster(8,"Genie",5,new SkillSet[]{new SkillSet(950,2480,1250,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"genie_0.jpg","genie_all.jpg"));
        adapter.addMonster(new Monster(9,"Firesaur",2,new SkillSet[]{new SkillSet(1375,2480,875,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"firesaur_0.jpg","firesaur_all.jpg"));
        adapter.addMonster(new Monster(10,"Mersnake",1,new SkillSet[]{new SkillSet(1125,2777,1000,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"mersnake_0.jpg","mersnake_all.jpg"));
        adapter.addMonster(new Monster(11,"Treezard",8,new SkillSet[]{new SkillSet(1125,2777,1000,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"treezard_0.jpg","treezard_all.jpg"));
        adapter.addMonster(new Monster(12,"Metalsaur",6,new SkillSet[]{new SkillSet(1120,2976,1000,100), new SkillSet(3000,700,1045,120), new SkillSet(3600,800,1500,130), new SkillSet(6000,1000,4000,150)},"metalsaur_0.jpg","metalsaur_all.jpg"));

        setListAdapter(adapter);                                // on donne à l'activité l'adapter dont elle a besoin pour remplir la liste
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // L'utilisateur a cliqué sur une ligne correspondant à un monstre.
        Intent ficheIntent = new Intent(this,DetailsActivity.class);	// Construit l'Intent pour passer à l'activité Fiche
        ficheIntent.putExtra(Constants.PARAM_MONSTER_ID, id);		// Ajoute le paramètre Id de l'étudiant à l'Intent
        startActivity(ficheIntent);									// démarre l'activité Fiche
    }
}
