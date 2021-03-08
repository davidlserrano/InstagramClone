package com.example.instagramclone.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.instagramclone.Post;
import com.example.instagramclone.PostsAdapter;
import com.example.instagramclone.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    private TextView tvProfileUser;
    private TextView tvProfileDesc;
    private ImageView ivProfileImg;
    private RecyclerView rvPosts;
    private PostsAdapter postsAdapter;
    private List<Post> allPosts;
    private static final String TAG = "ProfileFragment";
    private static final String PROFILE_DESCRIPTION_KEY = "profileDescription";
    private static final String PROFILE_IMG_KEY = "profileImg";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PostsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvProfileDesc = view.findViewById(R.id.tvProfileDesc);
        tvProfileUser = view.findViewById(R.id.tvProfileUser);
        ivProfileImg = view.findViewById(R.id.ivProfileImg);
        tvProfileUser.setText(ParseUser.getCurrentUser().getUsername());
        tvProfileDesc.setText(ParseUser.getCurrentUser().get(PROFILE_DESCRIPTION_KEY).toString());
        rvPosts = view.findViewById(R.id.rvProfilePosts);
        allPosts = new ArrayList<>();
        postsAdapter = new PostsAdapter(getContext(), allPosts);
        rvPosts.setAdapter(postsAdapter);
        rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPosts();
        ParseFile image = (ParseFile) ParseUser.getCurrentUser().get(PROFILE_IMG_KEY);
        if (image != null){
            Glide.with(view).load(image.getUrl()).circleCrop().into(ivProfileImg);
        }
    }


    protected void queryPosts() {
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.setLimit(20);
        query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        query.addDescendingOrder(Post.KEY_CREATED_KEY);
        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for( Post post : posts){
                    try {
                        Log.i(TAG, "Post: " + post.getDescription() + "Username: " + post.getUser().fetchIfNeeded().getUsername());
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                }
                allPosts.addAll(posts);
                postsAdapter.notifyDataSetChanged();
            }
        });
    }
}
