package com.omar.bonappetit.ui;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.omar.bonappetit.R;

public class MainActivity extends AppCompatActivity {

	private ActionBarDrawerToggle drawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// after finish everything
		setupUI();

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...

		return super.onOptionsItemSelected(item);
	}

	private void setupUI()
	{
		final Toolbar toolbar;
		final DrawerLayout drawerLayout;
		final NavigationView navigationView;
		final ViewPager viewPager;
		final TabLayout tabLayout;

		/* apply default app theme */
		setTheme(R.style.AppTheme);

		/* view main app content */
		setContentView(R.layout.activity_main);

		/* attach views */
		toolbar = findViewById(R.id.main_toolbar);
		drawerLayout = findViewById(R.id.drawer_layout);
		navigationView = findViewById(R.id.nav_view);
		viewPager = findViewById(R.id.view_pager);
		tabLayout = findViewById(R.id.tab_layout);

		/* setup toolbar */
		setSupportActionBar(toolbar);

		/* setup drawer toggle */
		drawerToggle = new ActionBarDrawerToggle(this,
				drawerLayout, toolbar, R.string.drawer_toggle_open, R.string.drawer_toggle_close);
		drawerLayout.addDrawerListener(drawerToggle);

		/* setup navigation view */
		navigationView.setNavigationItemSelectedListener(
				new NavigationView.OnNavigationItemSelectedListener() {
					@Override
					public boolean onNavigationItemSelected(MenuItem menuItem) {
						menuItem.setChecked(true);      // Highlight the selected item
						drawerLayout.closeDrawers();    // Close drawer
						return true;
					}
				});

		/* setup pager */
		FragmentPagerAdapter fa = new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Nullable
			@Override
			public CharSequence getPageTitle(int position) {
				switch (position) {
					case 0:
						return "EXPLORE";
					case 1:
						return "ORDERS";
					default:
						return null;
				}
			}

			@Override
			public Fragment getItem(int position) {
				switch (position) {
					case 0:
						return new LeftFragment();
					case 1:
						return new RightFragment();
					default:
						return null;
				}
			}

			@Override
			public int getCount() {
				return 2;
			}
		};

		viewPager.setAdapter(fa);
		tabLayout.setupWithViewPager(viewPager);

	}
}
