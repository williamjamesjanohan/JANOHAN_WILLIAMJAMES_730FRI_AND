package com.example.newsapp.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newsapp.R;

public class NewsContentFragment extends Fragment {

    private static final String ARG_HEADLINE = "headline";
    private static final String ARG_CONTENT = "content";

    private String headline;
    private String content;

    public static NewsContentFragment newInstance(String headline, String content) {
        NewsContentFragment fragment = new NewsContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_HEADLINE, headline);
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            headline = getArguments().getString(ARG_HEADLINE);
            content = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_content, container, false);

        // Set the headline
        TextView headlineTextView = view.findViewById(R.id.headline_text);
        headlineTextView.setText(headline);

        // Set the content
        TextView newsContentTextView = view.findViewById(R.id.news_content);
        newsContentTextView.setText(content);

        return view;
    }

    public void updateNewsContent(String newHeadline, String newContent) {
        this.headline = newHeadline;
        this.content = newContent;
        if (getView() != null) {
            TextView headlineTextView = getView().findViewById(R.id.headline_text);
            TextView newsContentTextView = getView().findViewById(R.id.news_content);
            headlineTextView.setText(newHeadline);
            newsContentTextView.setText(newContent);
        }
    }
}
