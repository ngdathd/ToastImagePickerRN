package csell.com.ngdat.library.imagepicker.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import csell.com.ngdat.library.imagepicker.R;
import csell.com.ngdat.library.imagepicker.features.imageloader.ImageLoader;
import csell.com.ngdat.library.imagepicker.features.imageloader.ImageType;
import csell.com.ngdat.library.imagepicker.listeners.OnFolderClickListener;
import csell.com.ngdat.library.imagepicker.model.Folder;

public class FolderPickerAdapter extends BaseListAdapter<FolderPickerAdapter.FolderViewHolder> {

    private final OnFolderClickListener folderClickListener;

    private List<Folder> folders = new ArrayList<>();

    public FolderPickerAdapter(Context context, ImageLoader imageLoader, OnFolderClickListener folderClickListener) {
        super(context, imageLoader);
        this.folderClickListener = folderClickListener;
    }

    @Override
    public FolderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FolderViewHolder(
                getInflater().inflate(R.layout.imagepicker_item_folder, parent, false));
    }

    @Override
    public void onBindViewHolder(final FolderViewHolder holder, int position) {
        final Folder folder = folders.get(position);

        getImageLoader().loadImage(
                folder.getImages().get(0).getPath(),
                holder.image,
                ImageType.FOLDER
        );

        holder.name.setText(folders.get(position).getFolderName());
        holder.number.setText(String.valueOf(folders.get(position).getImages().size()));

        holder.itemView.setOnClickListener(v -> {
            if (folderClickListener != null)
                folderClickListener.onFolderClick(folder);
        });
    }

    public void setData(List<Folder> folders) {
        if (folders != null) {
            this.folders.clear();
            this.folders.addAll(folders);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    static class FolderViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;
        private TextView number;

        FolderViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.tv_name);
            number = itemView.findViewById(R.id.tv_number);
        }
    }
}
