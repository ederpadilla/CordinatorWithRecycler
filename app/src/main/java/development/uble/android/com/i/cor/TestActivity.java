package development.uble.android.com.i.cor;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rd.PageIndicatorView;
import com.rd.animation.AnimationType;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity implements OnProductSelected,OnTypeselected,ViewPager.OnPageChangeListener{

    @BindView(R.id.rec_view_products)
    RecyclerView recyclerViewProducts;

    @BindView(R.id.rec_view_types)
    RecyclerView recyclerViewTypes;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.pageIndicatorView)
    PageIndicatorView pageIndicatorView;


    private ProductsAdapter productsAdapter;

    private TypesAdapter typesAdapter;

    private List<Products> productsList;

    private List<Types> typesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        initActionBar();
        initViewPager();
        initproductsRecView();
        initTypesRecView();
    }

    private void initViewPager() {
        viewPager.setAdapter(new BannerViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        pageIndicatorView.setViewPager(viewPager);
        pageIndicatorView.setAnimationType(AnimationType.WORM);
    }

    private void initActionBar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar actionBar = ((TestActivity)this).getSupportActionBar();
        //actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu);
        if (actionBar != null) {
            //actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(getString(R.string.app_name));
            //actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initproductsRecView() {
        productsList = new ArrayList<>();
        recyclerViewProducts.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false));
        recyclerViewProducts.setHasFixedSize(true);
        productsAdapter = new ProductsAdapter(productsList,getApplicationContext(),this);
        recyclerViewProducts.setAdapter(productsAdapter);
        Products products = new Products("Mangos","12.00","","",false,true,"para darle duro contra el muro","(250 grms)",true);
        Products products1 = new Products("Cacahuates","14.00","","",true,true,"rico coqueto ","(120 grms)",false);
        Products products2= new Products("Pistaches","16.00","","",false,false,"para la cruda","(20 grms)",true);
        Products products3 = new Products("Papas","20.00","","",true,true,"suve y chicloso","(150 grms)",false);
        Products products4 = new Products("Papas","20.00","","",true,true,"suve y chicloso","(150 grms)",false);
        Products products5 = new Products("Papas","20.00","","",true,true,"suve y chicloso","(150 grms)",false);
        Products products6 = new Products("Papas","20.00","","",true,true,"suve y chicloso","(150 grms)",false);
        Products products7 = new Products("Papas","20.00","","",true,true,"suve y chicloso","(150 grms)",false);
        Products products8 = new Products("Papas","20.00","","",true,true,"suve y chicloso","(150 grms)",false);
        Products products9 = new Products("Papas","20.00","","",true,true,"suve y chicloso","(150 grms)",false);
        Products products10 = new Products("Papas","20.00","","",true,true,"suve y chicloso","(150 grms)",false);
        productsList.add(products);
        productsList.add(products1);
        productsList.add(products2);
        productsList.add(products3);
        productsList.add(products4);
        productsList.add(products5);
        productsList.add(products6);
        productsList.add(products7);
        productsList.add(products8);
        productsList.add(products9);
        productsList.add(products10);
        productsAdapter.notifyDataSetChanged();
    }
    private void initTypesRecView(){
        typesList= new ArrayList<>();
        recyclerViewTypes.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewTypes.setHasFixedSize(true);
        typesAdapter= new TypesAdapter(typesList,getApplicationContext(),this);
        recyclerViewTypes.setAdapter(typesAdapter);
        Types types1 = new Types("Para Botanear","","");
        Types types2 = new Types("Dulces Tradicionales","","");
        Types types3 = new Types("Dulces Gourmet","","");
        Types types4 = new Types("Todos Los Productos","","");
        typesList.add(types1);
        typesList.add(types2);
        typesList.add(types3);
        typesList.add(types4);

        typesAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                this.finish();
                return true;
            case R.id.actionsearch:
                return true;
            case R.id.action_filter:
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onProductSelected(Products products) {
    }

    @Override
    public void onTypeSelected(Types types) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}