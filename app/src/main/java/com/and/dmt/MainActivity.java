package com.and.dmt;

/**
 * Created by user2 on 11/22/2017.
 */
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements
        OnItemClickListener {

    public static ArrayList<String> titles = new ArrayList<String>();
    public static ArrayList<String> hints = new ArrayList<String>();
    public static ArrayList<String> values = new ArrayList<String>();
    public static ArrayList<Integer> arrows = new ArrayList<Integer>();

    ListView listView;
    List<RowItem> rowItems;
    @BindView(R.id.Main_MainPanel_Today_IE_PlusMinus_Button_Plus)
    ImageView imgPlus;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.Main_MainPanel_Today_IE_PlusMinus_Button_Plus)
    public void onImgPlusBtnClicked()
    {
        rowItems = new ArrayList<RowItem>();
        arrows.add(R.drawable.arrow_lightgreen);
        titles.add("Trans. Pend.");
        hints.add("Madrid");
        values.add("$25,00");

        for (int i = 0; i < titles.size(); i++) {
            RowItem item = new RowItem(false, arrows.get(i), titles.get(i), hints.get(i), values.get(i));
            rowItems.add(item);
        }
        listView = (ListView) findViewById(R.id.Main_MainPanel_Today_IE_MainShow);
        CustomListAdapter adapter = new CustomListAdapter(this,
                R.layout.subitem_list_main, rowItems);
        adapter.getItem(0).setDeleteStatus(false);

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = 60 * (titles.size() + 1);
        listView.setLayoutParams(params);
        listView.requestLayout();


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    @OnClick(R.id.Main_MainPanel_Today_IE_PlusMinus_Button_Minus)
    public void onImgMinusBtnClicked()
    {
        CustomListAdapter adapter = new CustomListAdapter(this,
                R.layout.subitem_list_main, rowItems);

        adapter.getItem(0).setDeleteStatus(true);
    }
    @OnClick(R.id.Main_Bottom_Bar_Summary)
    public void onBottomBarClicked()
    {
        System.out.println("OKOKOKOKOKOK");
        loadFragment(new AddItemFragment());
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
    private void loadFragment(android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}