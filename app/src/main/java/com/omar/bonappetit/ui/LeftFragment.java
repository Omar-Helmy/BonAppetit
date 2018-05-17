package com.omar.bonappetit.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omar.bonappetit.R;

public class LeftFragment extends Fragment {


	private View rootView;

	public LeftFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		rootView = inflater.inflate(R.layout.fragment_left, container, false);

		setupRecycleView();

		return rootView;
	}

	private void setupRecycleView(){

		RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycle_view_left);

		/* setup recycle view with adapter */
		RecyclerAdapter recyclerAdapter = new RecyclerAdapter();
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
		linearLayoutManager.setSmoothScrollbarEnabled(true);
		recyclerView.setLayoutManager(linearLayoutManager);
		recyclerView.setAdapter(recyclerAdapter);


	}
	/////////////////////////////// Recycle Adapter /////////////////////////////////
	private class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

			// put data from cursor into the right layout
			((NormalViewHolder) holder).setupData();


		}

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			// choose which layout to inflate which view holder based on view type:
			return new NormalViewHolder(inflater.inflate(R.layout.card_main_item,
					parent, false));

		}


		@Override
		public int getItemCount() {
			//TODO: return data count
			return 10;
		}


		private class NormalViewHolder extends RecyclerView.ViewHolder {

			//TODO: create final objects of views

			private NormalViewHolder(View itemView) {
				super(itemView);    // pass view to super class

				//TODO: attach views

					/* on click listener on the whole view */
				itemView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//TODO: handle click event
						startActivityTransition();
					}
				});
			}

			private void setupData() {
				//TODO: inflate view with right data
			}

			private void startActivityTransition() {
				// Check if we're running on Android 5.0 or higher
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					// Apply activity transition
					startActivity(new Intent(getContext(), SecondActivity.class),
							ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity()).toBundle());
				} else {
					// Swap without transition
				}
			}
		}
	}

}
