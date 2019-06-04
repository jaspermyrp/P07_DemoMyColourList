package sg.edu.rp.c346.demomycolourlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNewColour, etIndexElement;
    Button btnAddNewColour, btnRemoveColour, btnUpdateColour;
    ListView lvColours;

    ArrayList<String> alColours = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind UI Components //
        etNewColour = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAddNewColour = findViewById(R.id.buttonAddItem);
        btnRemoveColour = findViewById(R.id.buttonRemoveItem);
        btnUpdateColour = findViewById(R.id.buttonUpdateItem);
        lvColours = findViewById(R.id.listViewColour);

        // Add colours to ArrayList //
        alColours.add("Red");
        alColours.add("Orange");

        // ArrayAdapter //
        final ArrayAdapter<String> aaColour = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alColours);
        lvColours.setAdapter(aaColour);

        // Button Listener //
        btnAddNewColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Input from user //
                String getEtColour = etNewColour.getText().toString();

                int pos = 0;
                try {
                    pos = Integer.parseInt(etIndexElement.getText().toString());
                } catch (Exception e) {
                    Log.d("Exception caught", e.getMessage());
                }

                if (getEtColour.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter a colour", Toast.LENGTH_SHORT).show();
                } else {
                    // Add Input into ArrayList //
                    alColours.add(pos, getEtColour);

                    // notifyDataSetChanged //
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        btnRemoveColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = 0;
                try {
                    pos = Integer.parseInt(etIndexElement.getText().toString());
                } catch (Exception e) {
                    Log.d("Exception caught", e.getMessage());
                }

                alColours.remove(pos);
                aaColour.notifyDataSetChanged();
            }
        });

        btnUpdateColour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Input from user //
                String getEtColour = etNewColour.getText().toString();

                int pos = 0;
                try {
                    pos = Integer.parseInt(etIndexElement.getText().toString());
                } catch (Exception e) {
                    Log.d("Exception caught", e.getMessage());
                }

                if (getEtColour.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter a colour", Toast.LENGTH_SHORT).show();
                } else {
                    // Set Input into ArrayList //
                    alColours.set(pos, getEtColour);

                    // notifyDataSetChanged //
                    aaColour.notifyDataSetChanged();
                }
            }
        });

        // ListView Listener //
        lvColours.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, "Colour: " + colour, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
