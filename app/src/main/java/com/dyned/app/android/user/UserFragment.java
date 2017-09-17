package com.dyned.app.android.user;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.dyned.app.android.R;
import com.dyned.app.android.base.BaseEditText;
import com.dyned.app.android.base.BaseFragment;
import com.dyned.app.android.data.realm.Example;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class UserFragment extends BaseFragment implements UserContract.View {

    private Realm realm;
    private UserAdapter adapter;
    private UserPresenter userPresenter;
    private View view;

    RecyclerView recyclerView;
    BaseEditText editText;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initial(View view) {
        this.view = view;
        setupPresenter();
        setupDatabase();
        setupView();
        setupAdapter();
        setupRecycleView();
        setupSearch();
        findAll();
    }

    @Override
    public void setupSearch() {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                performSearch();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void performSearch() {
        userPresenter.actionFind();
    }

    @Override
    public void renderResult(RealmResults<Example> results) {
        adapter.refreshList(results);
    }

    @Override
    public void findAll() {
        userPresenter.actionSelectAll();
    }

    @Override
    public void setupPresenter() {
        userPresenter = new UserPresenter(this);
    }

    @Override
    public void setupAdapter() {
        adapter = new UserAdapter(getActivity());
    }

    @Override
    public void setupDatabase() {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void setupRecycleView() {
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public Realm getRealm() {
        return realm;
    }

    @Override
    public String getKeyword() {
        return editText.getText().toString().trim();
    }

    @Override
    public void setupView() {
        editText = view.findViewById(R.id.edit_text);
        recyclerView = view.findViewById(R.id.recycle_view);
    }

}