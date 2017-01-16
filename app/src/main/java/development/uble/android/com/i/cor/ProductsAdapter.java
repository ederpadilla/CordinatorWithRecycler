package development.uble.android.com.i.cor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ederpadilla on 09/01/17.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolderAdapter> implements View.OnClickListener{

    private View.OnClickListener listener;

    private List<Products> productosList;

    private Context context;

    private OnProductSelected onProductSelected;

    public ProductsAdapter(List<Products> ProductosList,Context context,OnProductSelected onProductSelected) {
        this.productosList = ProductosList;
        this.context=context;
        this.onProductSelected=onProductSelected;
    }


    @Override
    public ViewHolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_productos, parent, false);
        ViewHolderAdapter viewholder = new ViewHolderAdapter(view);
        return viewholder;
    }
    public void setOnClickListener(View.OnClickListener listener) {
    }
    @Override
    public void onClick(View view) {
        if (listener != null)
            listener.onClick(view);
    }
    @Override
    public void onBindViewHolder(ViewHolderAdapter holder, int position) {
        Products item = productosList.get(position);
        holder.bindTexts(item);
        holder.rootView.setOnClickListener(view -> onProductSelected.onProductSelected(productosList.get(position)));
    }

    @Override
    public int getItemCount() {
        return productosList.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_candy_name)
        TextView tv_candy_name;

        @BindView(R.id.tv_precio)
        TextView tv_price;

        @BindView(R.id.imgv_product_snack)
        ImageView imgv_product_snack;

        @BindView(R.id.imgv_discount)
        ImageView imgv_discount;

        @BindView(R.id.linear_top_sell)
        LinearLayout linear_top_sell;

        View rootView;

        public ViewHolderAdapter(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootView=itemView;

        }
        public  void bindTexts(Products productos){
            tv_candy_name.setText(productos.getName());
            tv_price.setText("$ "+productos.getPrice());
            if (productos.isMoreSell()){
                linear_top_sell.setVisibility(View.VISIBLE);
            }
            if (productos.isDiscount()){
                imgv_discount.setVisibility(View.VISIBLE);
            }
           //Glide.with(context)
           //        .load(productos.getUrl())
           //        .placeholder(context.getResources().getDrawable(R.drawable.imgtest))
           //        .listener(new RequestListener<String, GlideDrawable>() {
           //            @Override
           //            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
           //                return false;
           //            }

           //            @Override
           //            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

           //                return false;
           //            }
           //        })
           //        .into(imgv_product_snack);
        }


    }
}
