package development.uble.android.com.i.cor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ederpadilla on 09/01/17.
 */

public class TypesAdapter extends RecyclerView.Adapter<TypesAdapter.ViewHolderAdapter> implements View.OnClickListener{

    private View.OnClickListener listener;

    private List<Types> typesList;

    private Context context;

    private OnTypeselected onTypeselected;

    public TypesAdapter(List<Types> typesList,Context context,OnTypeselected onTypeselected) {
        this.typesList = typesList;
        this.context=context;
        this.onTypeselected=onTypeselected;
    }


    @Override
    public TypesAdapter.ViewHolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_types, parent, false);
        TypesAdapter.ViewHolderAdapter viewholder = new TypesAdapter.ViewHolderAdapter(view);
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
    public void onBindViewHolder(TypesAdapter.ViewHolderAdapter holder, int position) {
        Types item = typesList.get(position);
        holder.bindTexts(item);
        holder.rootView.setOnClickListener(view -> onTypeselected.onTypeSelected(typesList.get(position)));
    }

    @Override
    public int getItemCount() {
        return typesList.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {

        @BindView(R.id.ite_type_snack_name)
        TextView ite_type_snack_name;

        @BindView(R.id.type_snack_image)
        CircularImageView type_snack_image;

        View rootView;


        public ViewHolderAdapter(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            rootView=itemView;

        }
        public  void bindTexts(Types types){
            ite_type_snack_name.setText(types.getName());
          // Glide.with(context)
          //         .load(types.getUrl())
          //         .placeholder(context.getResources().getDrawable(R.drawable.others))
          //         .listener(new RequestListener<String, GlideDrawable>() {
          //             @Override
          //             public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
          //                 return false;
          //             }

          //             @Override
          //             public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

          //                 return false;
          //             }
          //         })
          //         .into(type_snack_image);
          //         type_snack_image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }



    }
}
