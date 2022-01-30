package uz.pdp.fragmentjava.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import uz.pdp.fragmentjava.R;
import uz.pdp.fragmentjava.model.User;

public class FirstFragment extends Fragment {
    private FirstListener listener;
    View root;
    TextView first_tv;
    Button first_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_first, container, false);

        first_tv = root.findViewById(R.id.first_tv);
        first_btn = root.findViewById(R.id.first_btn);

        first_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Diyor", 20);
                listener.onFirstSend(user);
            }
        });
        return root;
    }

    public void updateFirstText(User s){
        first_tv.setText("name = "+s.name + " age = " +s.age);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FirstListener){
            listener = (FirstListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement First Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface FirstListener{
        void onFirstSend(User s);
    }
}