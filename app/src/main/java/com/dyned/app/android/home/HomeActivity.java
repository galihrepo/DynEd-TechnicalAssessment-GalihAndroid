package com.dyned.app.android.home;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.dyned.app.android.R;
import com.dyned.app.android.about.AboutFragment;
import com.dyned.app.android.base.BaseActivity;
import com.dyned.app.android.base.BaseTextView;
import com.dyned.app.android.exit.ExitDialogFragment;
import com.dyned.app.android.user.UserFragment;

public class HomeActivity extends BaseActivity implements HomeContract.View, NavigationView.OnNavigationItemSelectedListener {

    // content home
    View layoutContent;
    Toolbar toolbar;
    BaseTextView tvTitle;
    LinearLayout placeholder;

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initial() {
        setupView();
        setupToolbar();
        setupDrawer();
        setupNavigation();
        setupFirstFragment();
    }

    @Override
    public void setupFirstFragment() {
        onClickUser();
    }

    @Override
    public void onClickUser() {
        tvTitle.setText("USER");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(placeholder.getId(), new UserFragment())
                .commit();
    }

    @Override
    public void onClickAbout() {
        tvTitle.setText("ABOUT");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(placeholder.getId(), new AboutFragment())
                .commit();
    }

    @Override
    public void onClickExit() {
        ExitDialogFragment exitDialogFragment = new ExitDialogFragment();
        exitDialogFragment.show(getSupportFragmentManager(), "");
    }

    @Override
    public void setupDrawer() {
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void setupNavigation() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void setupView() {
        layoutContent = findViewById(R.id.layout_content);
        toolbar = layoutContent.findViewById(R.id.toolbar);
        tvTitle = layoutContent.findViewById(R.id.tv_title);
        placeholder = layoutContent.findViewById(R.id.placeholder);

        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer);
    }

    @Override
    public void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.isChecked()) {
            menuItem.setChecked(false);
        } else {
            menuItem.setChecked(true);
        }

        drawerLayout.closeDrawers();
        switch (menuItem.getItemId()){
            case R.id.exit:
                onClickExit();
                return true;
            case R.id.user:
                onClickUser();
                return true;
            case R.id.about:
                onClickAbout();
                return true;
            default:
                return true;
        }
    }

}
