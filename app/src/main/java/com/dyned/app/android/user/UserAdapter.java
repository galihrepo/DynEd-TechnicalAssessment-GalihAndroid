package com.dyned.app.android.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dyned.app.android.R;
import com.dyned.app.android.base.BaseImageView;
import com.dyned.app.android.base.BaseTextView;
import com.dyned.app.android.data.realm.Address;
import com.dyned.app.android.data.realm.Company;
import com.dyned.app.android.data.realm.Example;
import com.dyned.app.android.data.realm.Geo;

import net.cachapa.expandablelayout.ExpandableLayout;

import io.realm.RealmResults;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private RealmResults<Example> list;

    public UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_user, parent, false);

            vh = new UserViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Example item = list.get(position);
        Company company = item.getCompany();
        Address address = item.getAddress();
        Geo geo = item.getAddress().getGeo();


        BaseTextView tvName = ((UserViewHolder) holder).tvName;
        tvName.setText(item.getName());

        BaseTextView tvEmail = ((UserViewHolder) holder).tvEmail;
        tvEmail.setText(item.getEmail());

        BaseTextView tvUsername = ((UserViewHolder) holder).tvUsername;
        tvUsername.setText(item.getUsername());

        BaseTextView tvId = ((UserViewHolder) holder).tvId;
        tvId.setText("id : " + item.getId());

        BaseTextView tvPhone = ((UserViewHolder) holder).tvPhone;
        tvPhone.setText("Phone : " + item.getPhone());

        BaseTextView tvWebsite = ((UserViewHolder) holder).tvWebsite;
        tvWebsite.setText("Website : " + item.getWebsite());


        final BaseImageView ivArrow = ((UserViewHolder) holder).ivArrow;

        final ExpandableLayout expandableLayout = ((UserViewHolder) holder).expandableLayout;
        expandableLayout.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                if (state == ExpandableLayout.State.EXPANDING) {
                    ivArrow.setImageResource(R.drawable.ic_expand_less);
                } else if (state == ExpandableLayout.State.COLLAPSING) {
                    ivArrow.setImageResource(R.drawable.ic_expand_more);
                }
            }
        });

        LinearLayout btnToggle = ((UserViewHolder) holder).btnToggle;
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expandableLayout.toggle();
            }
        });

        BaseTextView tvStreet = ((UserViewHolder) holder).tvStreet;
        tvStreet.setText("Street : " + address.getStreet());

        BaseTextView tvSuite = ((UserViewHolder) holder).tvSuite;
        tvSuite.setText("Suite : " + address.getSuite());

        BaseTextView tvCity = ((UserViewHolder) holder).tvCity;
        tvCity.setText("City : " + address.getCity());

        BaseTextView tvZipcode = ((UserViewHolder) holder).tvZipcode;
        tvZipcode.setText("Zip Code : " + address.getZipcode());


        BaseTextView tvLong = ((UserViewHolder) holder).tvLong;
        tvLong.setText("Longitude : " + geo.getLng());

        BaseTextView tvLat = ((UserViewHolder) holder).tvLat;
        tvLat.setText("Latitude : " + geo.getLat());


        BaseTextView tvCompanyName = ((UserViewHolder) holder).tvCompanyName;
        tvCompanyName.setText("Company : " + company.getName());

        BaseTextView tvCompanyCatchPhrase = ((UserViewHolder) holder).tvCompanyCatchPhrase;
        tvCompanyCatchPhrase.setText("Catch Phrase : " + company.getCatchPhrase());

        BaseTextView tvCompanyBs = ((UserViewHolder) holder).tvCompanyBs;
        tvCompanyBs.setText("Bs : " + company.getBs());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout btnToggle;
        public ExpandableLayout expandableLayout;
        public BaseImageView ivArrow;
        public BaseTextView tvName;
        public BaseTextView tvEmail;
        public BaseTextView tvUsername;
        public BaseTextView tvId;
        public BaseTextView tvStreet;
        public BaseTextView tvSuite;
        public BaseTextView tvCity;
        public BaseTextView tvZipcode;
        public BaseTextView tvLong;
        public BaseTextView tvLat;
        public BaseTextView tvPhone;
        public BaseTextView tvWebsite;
        public BaseTextView tvCompanyName;
        public BaseTextView tvCompanyCatchPhrase;
        public BaseTextView tvCompanyBs;

        public UserViewHolder(View v) {
            super(v);

            btnToggle = v.findViewById(R.id.btn_toggle);
            expandableLayout = v.findViewById(R.id.expanadable_layout);
            ivArrow = v.findViewById(R.id.iv_arrow);
            tvName = v.findViewById(R.id.tv_name);
            tvEmail = v.findViewById(R.id.tv_email);
            tvUsername = v.findViewById(R.id.tv_username);
            tvId = v.findViewById(R.id.tv_id);
            tvStreet = v.findViewById(R.id.tv_street);
            tvSuite = v.findViewById(R.id.tv_suite);
            tvCity = v.findViewById(R.id.tv_city);
            tvZipcode = v.findViewById(R.id.tv_zipcode);
            tvLong = v.findViewById(R.id.tv_long);
            tvLat = v.findViewById(R.id.tv_lat);
            tvPhone = v.findViewById(R.id.tv_phone);
            tvWebsite = v.findViewById(R.id.tv_website);
            tvCompanyName = v.findViewById(R.id.tv_company_name);
            tvCompanyCatchPhrase = v.findViewById(R.id.tv_company_catch_phrase);
            tvCompanyBs = v.findViewById(R.id.tv_company_bs);
        }
    }

    public void refreshList(RealmResults<Example> list) {
        this.list = list;
        notifyDataSetChanged();
    }

}
