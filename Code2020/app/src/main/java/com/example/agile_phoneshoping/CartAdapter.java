package com.example.agile_phoneshoping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agile_phoneshoping.model.Cart;
import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.fragment.CartFragment;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List mCart;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;

    public CartAdapter(List mCart, Context mContext) {
        this.mCart = mCart;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử
        View cartView =
                inflater.inflate(R.layout.item_cart, parent, false);

        ViewHolder viewHolder = new ViewHolder(cartView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Cart cart = (Cart) mCart.get(position);
    }

    @Override
    public int getItemCount() {
        return mCart.size();
    }

    /**
     * Lớp nắm giữ cấu trúc view
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public ImageView imgsanpham;
        public TextView tvtensanpham,tvmausampham,tvgiasanpham,tvsoluongsanpham,tvTong;
        public Button btnTru,btnCong,btnDelete;
        static double tt = Double.parseDouble(CartFragment.tvTongtien.getText() + "");

        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            imgsanpham = itemView.findViewById(R.id.imgsanpham);
            tvTong = itemView.findViewById(R.id.tvTong);
            final String[] tong = {tvTong.getText() + ""};
            tvtensanpham = itemView.findViewById(R.id.tvtensanpham);
            tvmausampham = itemView.findViewById(R.id.tvmausanpham);
            tvgiasanpham = itemView.findViewById(R.id.tvgiasanpham);
            final String[] giasp = {tvgiasanpham.getText() + ""};
            final String tongtien = CartFragment.tvTongtien.getText() + "";

            tvsoluongsanpham = itemView.findViewById(R.id.tvSoluong);
            final String[] soluong = {tvsoluongsanpham.getText() + ""};
            btnTru = itemView.findViewById(R.id.btnTru);
            btnCong = itemView.findViewById(R.id.btnCong);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            //Xử lý khi nút Chi tiết được bấm
            btnCong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int gsp = Integer.parseInt(giasp[0]);
                    int sl = Integer.parseInt(soluong[0]);
                    sl =sl +1;
                    tt = tt+gsp;
                    soluong[0] = String.valueOf(sl);

                    tvsoluongsanpham.setText(soluong[0]);

                    CartFragment.tvTongtien.setText(String.valueOf(tt));
//                    tvTongtien.setText("100");
                }
            });
            btnTru.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int gsp = Integer.parseInt(giasp[0]);
                    int sl = Integer.parseInt(soluong[0]);
                    if (sl > 1){
                        sl =sl -1;
                        soluong[0] = String.valueOf(sl);
                        tvsoluongsanpham.setText(soluong[0]);
                        tt = tt-gsp;
                        CartFragment.tvTongtien.setText(String.valueOf(tt));
                    }

                }
            });
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int gsp = Integer.parseInt(giasp[0]);
                    int sl = Integer.parseInt(soluong[0]);
                    int t = Integer.parseInt(tong[0]);
                    CartFragment.cart.remove(getPosition());
                    tt = tt-gsp*sl;
                    tong[0] = String.valueOf(t);
                    tvTong.setText(tong[0]);
                    CartFragment.tvTongtien.setText(String.valueOf(tt));
                    if(CartFragment.cart.size()<1){
                        CartFragment.tvnoproduct.setVisibility(View.VISIBLE);
                    }


                }
            });
        }
    }


}
