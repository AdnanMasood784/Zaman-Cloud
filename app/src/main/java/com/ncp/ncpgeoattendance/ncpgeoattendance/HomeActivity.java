package com.ncp.ncpgeoattendance.ncpgeoattendance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.ncp.ncpgeoattendance.R;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private Toolbar toolbar;
    private TextView Login,Text;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed()
            {
                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else
                {
                    new AlertDialog.Builder(HomeActivity.this)
                            .setTitle("Exit App")
                            .setIcon(R.drawable.logo)
                            .setMessage("Are you sure you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", (dialog, which) -> {
                                finishAffinity(); // Close all activities
                                System.exit(0);   // Optional force close
                            })
                            .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                            .show();
                }
            }
        });








        toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);
        Login=findViewById(R.id.Login);
        Text=findViewById(R.id.Text);

        Text.setText("Zaman Cloud HR Management App is the official mobile application of zamancloud.com, designed to empower HR teams and employees with secure, mobile-first access to key HR functions.\n" +
                "\n" +
                "\uD83D\uDD39 Key Features:\n" +
                "✅ Mark and track daily attendance with geo-location and face verification\n" +
                "\n" +
                "\uD83D\uDCDD Submit daily work reports and logs\n" +
                "\n" +
                "\uD83C\uDF34 Apply for and approve leave requests in real time\n" +
                "\n" +
                "\uD83D\uDCBC View payroll information and download payslips\n" +
                "\n" +
                "\uD83D\uDCCA Manage other essential HR tasks anytime, anywhere\n" +
                "\n" +
                "This app is primarily a WebView-based interface of the Zaman Cloud web platform, optimized for mobile users.\n" +
                "\n" +
                "\uD83D\uDD10 Permissions Disclosure:\n" +
                "To support secure and accurate HR operations, the app may request the following permissions:\n" +
                "\n" +
                "Camera – Used to capture photos for facial recognition during attendance marking\n" +
                "\n" +
                "Location – Used to verify the geographic location of employees during check-in\n" +
                "\n" +
                "Media & Photos Access – Used to upload profile images or documents in leave requests and reports\n" +
                "\n" +
                "\uD83D\uDCCC Important:\n" +
                "A registered Zaman Cloud account is required to log in.\n" +
                "\n" +
                "An active internet connection is necessary for full functionality.");

        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
             startActivity(intent);
            }
        });


        // Drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
            String url = "https://zamancloud.com/privacy-policy-2/";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
        else if (id == R.id.nav_profile)
        {
           Intent intent=new Intent(getApplicationContext(),MainActivity.class);
           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
           startActivity(intent);
        }
        else if (id == R.id.nav_settings)
        {
            Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(HomeActivity.this)
                    .setTitle("Exit App")
                    .setIcon(R.drawable.logo)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // Close the app
                        finishAffinity();  // Closes all activities
                        System.exit(0);    // Optional: Force quit
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        // Do nothing, dialog will dismiss automatically
                        dialog.dismiss();
                    })
                    .show();

        }
        else if (id == R.id.nav_logout)
        {
                 openRateUs();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void openRateUs() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (android.content.ActivityNotFoundException e) {
            // Fallback if Play Store is not installed
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }




}
