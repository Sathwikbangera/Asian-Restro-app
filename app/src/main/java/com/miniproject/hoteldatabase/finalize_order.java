package com.miniproject.hoteldatabase;;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class finalize_order extends Activity {
    finalize_order a=this;
    DatabaseReference databaseReference;

    public static String message;
    public static String m1;
    static int old_all_total;
    static int all_total;

    String personal_preferances;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";

    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);
        show_Order();
        tot_v();
        oo=this;
    }


    public void show_Order() {
        if (Dessert.chocolate_ice_cream > 0) {
            fin_order_string = fin_order_string + "Jelly Doughnut-" + String.valueOf(Dessert.chocolate_ice_cream) + "\n";
        }
        if (Dessert.vanilla_ice_cream > 0) {
            fin_order_string = fin_order_string + "Fruit Doughnut-" + String.valueOf(Dessert.vanilla_ice_cream) + "\n";
        }

        if (Dessert.strawberry_ice_cream > 0) {
            fin_order_string = fin_order_string + "Cheese Cake-" + String.valueOf(Dessert.strawberry_ice_cream) + "\n";
        }
        if (Dessert.falooda > 0) {
            fin_order_string = fin_order_string + "Chocolate Cake-" + String.valueOf(Dessert.falooda) + "\n";
        }
        if (Dessert.brownie_fudge > 0) {
            fin_order_string = fin_order_string + "Walnut Cake-" + String.valueOf(Dessert.brownie_fudge) + "\n";
        }
        if (Dessert.alpine_chocolate > 0) {
            fin_order_string = fin_order_string + "Chocolate Fantasy-" + String.valueOf(Dessert.alpine_chocolate) + "\n";
        }
        if (Dessert.devils_delight > 0) {
            fin_order_string = fin_order_string + "Chocolate Dad-" + String.valueOf(Dessert.devils_delight) + "\n";
        }

        if (Dessert.black_forest > 0) {
            fin_order_string = fin_order_string + "Tiramisu-" + String.valueOf(Dessert.black_forest) + "\n";
        }
        if (Dessert.chocolate_lava > 0) {
            fin_order_string = fin_order_string + "Dilkhush-" + String.valueOf(Dessert.chocolate_lava) + "\n";
        }

        if (Dessert.dutch_almond > 0) {
            fin_order_string = fin_order_string + "Gadbud-" + String.valueOf(Dessert.dutch_almond) + "\n";
        }
        if (N_Veg.chicken_burger > 0) {
            fin_order_string = fin_order_string + "Chicken Lolipop-" + String.valueOf(N_Veg.chicken_burger) + "\n";
        }
        if (N_Veg.chicken_bbq_pizza > 0) {
            fin_order_string = fin_order_string + "Chicken Ghee Roast-" + String.valueOf(N_Veg.chicken_bbq_pizza) + "\n";
        }
        if (N_Veg.chicken_tikka > 0) {
            fin_order_string = fin_order_string + "Chicken tikka-" + String.valueOf(N_Veg.chicken_tikka) + "\n";
        }
        if (N_Veg.fried_fish_rice > 0) {
            fin_order_string = fin_order_string + "Pepper Chicken-" + String.valueOf(N_Veg.fried_fish_rice) + "\n";
        }
        if (N_Veg.kolhapuri_chicken > 0) {
            fin_order_string = fin_order_string + "Prawns Fry-" + String.valueOf(N_Veg.kolhapuri_chicken) + "\n";
        }
        if (N_Veg.chicken_noodles > 0) {
            fin_order_string = fin_order_string + "Chicken noodles-" + String.valueOf(N_Veg.chicken_noodles) + "\n";
        }
        if (N_Veg.chicken_fried_rice > 0) {
            fin_order_string = fin_order_string + "Chicken fried rice-" + String.valueOf(N_Veg.chicken_fried_rice) + "\n";
        }

        if (N_Veg.chicken_lollipop > 0) {
            fin_order_string = fin_order_string + "Chicken Thali-" + String.valueOf(N_Veg.chicken_lollipop) + "\n";
        }

        if (N_Veg.chicken_biryani> 0) {
            fin_order_string = fin_order_string + "Chicken Biryani-" + String.valueOf(N_Veg.chicken_biryani) + "\n";
        }
        if (N_Veg.mutton_biryani> 0) {
            fin_order_string = fin_order_string + "Tikka Biryani-" + String.valueOf(N_Veg.mutton_biryani) + "\n";
        }
        if (N_Veg.squid_ghee> 0) {
            fin_order_string = fin_order_string + "Squid Ghee Roast-" + String.valueOf(N_Veg.squid_ghee) + "\n";
        }
        if (N_Veg.prawns_biriyani> 0) {
            fin_order_string = fin_order_string + "Prawns Biriyani-" + String.valueOf(N_Veg.prawns_biriyani) + "\n";
        }

        if (Veg.roti > 0) {
            fin_order_string = fin_order_string + "Gobi Chilli-" + String.valueOf(Veg.roti) + "\n";
        }
        if (Veg.butter_roti > 0) {
            fin_order_string = fin_order_string + "Gobi Manchuri-" + String.valueOf(Veg.butter_roti) + "\n";
        }
        if (Veg.paneer_tikka > 0) {
            fin_order_string = fin_order_string + "Paneer Tikka-" + String.valueOf(Veg.paneer_tikka) + "\n";
        }

        if (Veg.veg_pulao > 0) {
            fin_order_string = fin_order_string + "Panner Manchuri-" + String.valueOf(Veg.veg_pulao) + "\n";
        }
        if (Veg.mutter_paneer> 0) {
            fin_order_string = fin_order_string + "Chilli Manchuri-" + String.valueOf(Veg.mutter_paneer) + "\n";
        }
        if (Veg.veg_noodles> 0) {
            fin_order_string = fin_order_string + "Veg Noodles-" + String.valueOf(Veg.veg_noodles) + "\n";
        }

        if (Veg.veg_fried_rice> 0) {
            fin_order_string = fin_order_string + "Veg fried rice-" + String.valueOf(Veg.veg_fried_rice) + "\n";
        }
        if (Veg.veg_burger> 0) {
            fin_order_string = fin_order_string + "Veg Thali-" + String.valueOf(Veg.veg_burger) + "\n";
        }
        if (Veg.veg_biryani> 0) {
            fin_order_string = fin_order_string + "Panner briyani-" + String.valueOf(Veg.veg_biryani) + "\n";
        }

        if (Veg.paneer_kofta> 0) {
            fin_order_string = fin_order_string + "Mushroom Biriyani-" + String.valueOf(Veg.paneer_kofta) + "\n";
        }
        if (Starters.veg_crispy > 0) {
            fin_order_string = fin_order_string + "veg crispy-" + String.valueOf(Starters.veg_crispy) + "\n";
        }
        if (Starters.chicken_crispy > 0) {
            fin_order_string = fin_order_string + "chicken crispy-" + String.valueOf(Starters.chicken_crispy) + "\n";
        }
        if (Starters.paneer_chilly > 0) {
            fin_order_string = fin_order_string + "paneer chilly-" + String.valueOf(Starters.paneer_chilly) + "\n";
        }
        if (Starters.masala_papad > 0) {
            fin_order_string = fin_order_string + "masala papad-" + String.valueOf(Starters.masala_papad) + "\n";
        }
        if (Starters.veg_soup > 0) {
            fin_order_string = fin_order_string + "veg soup-" + String.valueOf(Starters.veg_soup) + "\n";
        }
        if (Starters.chicken_soup > 0) {
            fin_order_string = fin_order_string + "chicken soup-" + String.valueOf(Starters.chicken_soup) + "\n";
        }
        if (Starters.tomato_soup > 0) {
            fin_order_string = fin_order_string + "tomato soup-" + String.valueOf(Starters.tomato_soup) + "\n";
        }
        if (Starters.cheese_pakoda > 0) {
            fin_order_string = fin_order_string + "cheese pakoda-" + String.valueOf(Starters.cheese_pakoda) + "\n";
        }
        if (Starters.paneer_pakoda > 0) {
            fin_order_string = fin_order_string + "paneer pakoda-" + String.valueOf(Starters.paneer_pakoda) + "\n";
        }
        if (Starters.chicken_chilly > 0) {
            fin_order_string = fin_order_string + "chicken chilly-" + String.valueOf(Starters.chicken_chilly) + "\n";
        }
        String temp_order_view=fin_order_string+old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(finalize_order.this, Orders.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("Total price:" + "₹" +(finalize_order.all_total));
    }


    public void send_ord(View v){
        order_string=fin_order_string+old_ord_string;

    EditText Ed= (EditText) findViewById(R.id.personalp);

    personal_preferances=Ed.getText().toString();

    final Object o = this;
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Are you sure you want to confirm this order?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                      message = "  Orders: " + order_string + "   Bill Amt:" + Integer.toString(all_total)+" Add-On: "+personal_preferances;

                    databaseReference = FirebaseDatabase.getInstance().getReference("Table No: "+SlimpleTextClientActivity.tablex);
                    databaseReference.setValue(message);

                      Toast.makeText(a, "Order Sent", Toast.LENGTH_SHORT).show();

                        Intent nextact = new Intent((finalize_order) o, thankyou.class);
                        startActivity(nextact);
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
    AlertDialog alert = builder.create();
    alert.show();
}
}