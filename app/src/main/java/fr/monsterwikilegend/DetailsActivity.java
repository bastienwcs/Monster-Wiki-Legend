package fr.monsterwikilegend;

import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private long monsterId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        this.monsterId = getIntent().getLongExtra(Constants.PARAM_MONSTER_ID, -1);

        ImageView imgEvo = (ImageView) findViewById(R.id.imgEvoMonster);
        ListMonsterAdapter adapter = ListMonsterAdapter.getInstance(this);      // On utilise une instance de ListMonsterAdapter pour accéder aux données
        Monster m = adapter.getMonsterById(this.getMonsterId());
        String evoUrl = m.getUrlEvo();
        Resources res = getResources();
        int evoResId = res.getIdentifier(evoUrl.substring(0, m.getUrlEvo().length() - 4), "drawable", (this.getPackageName()));   // Récupération de l'identifiant de l'image dans les resources en supprimant le ".jpg" à la fin
        imgEvo.setImageResource(evoResId);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_details, container, false);

            ListMonsterAdapter adapter = ListMonsterAdapter.getInstance(getActivity());      // On utilise une instance de ListMonsterAdapter pour accéder aux données
            Monster m = adapter.getMonsterById(((DetailsActivity) getActivity()).getMonsterId());

            Bundle args = getArguments();
            int evol = args.getInt("section_number");

            if (m != null) {

                TextView txtNom = (TextView) rootView.findViewById(R.id.txtNomMonstre);           // On associe des objets à chaque élément du fichier XML devant être affecté
                TextView txtTypeElem = (TextView) rootView.findViewById(R.id.txtTypeElem);
                TextView txtVie = (TextView) rootView.findViewById(R.id.txtStatVie);
                TextView txtPuissance = (TextView) rootView.findViewById(R.id.txtStatPuissance);
                TextView txtVitesse = (TextView) rootView.findViewById(R.id.txtStatVitesse);
                TextView txtEndurance = (TextView) rootView.findViewById(R.id.txtStatEndurance);
                TextView txtEvol = (TextView) rootView.findViewById(R.id.txtLblEgg);

                ImageView imgEgg = (ImageView) rootView.findViewById(R.id.imgEgg);

                txtNom.setText(m.getName());                                             // on affecte les bonnes valeurs aux objets
                txtTypeElem.setText(m.getTypeElement());
                SkillSet skillSet = m.getSkillSetByEvol(evol);
                txtVie.setText(String.valueOf(skillSet.getLife()));
                txtPuissance.setText(String.valueOf(skillSet.getSpeed()));
                txtVitesse.setText(String.valueOf(skillSet.getStrength()));
                txtEndurance.setText(String.valueOf(skillSet.getStamina()));

                Resources res = getResources();
                String eggUrl = m.getUrlEgg();

                int eggResId = res.getIdentifier(eggUrl.substring(0, eggUrl.length() - 5)+evol, "drawable", ((DetailsActivity) getActivity()).getPackageName());   // Récupération de l'identifiant de l'image dans les resources en supprimant le ".jpg" à la fin
                imgEgg.setImageResource(eggResId);

                if (evol==0) txtEvol.setText("Oeuf");
                else txtEvol.setText("Evolution "+evol);
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    public long getMonsterId() {
        return monsterId;
    }
}
