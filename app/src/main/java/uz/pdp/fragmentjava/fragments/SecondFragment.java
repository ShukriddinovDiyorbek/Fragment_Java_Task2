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


public class SecondFragment extends Fragment {
    private SecondListener listener;
    View root;
    TextView second_tv;
    Button second_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_second, container, false);
        second_btn = root.findViewById(R.id.second_btn);
        second_tv = root.findViewById(R.id.second_tv);
        second_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Doniyor", 13);
                listener.onSecondSend(user);
            }
        });
        return root;
    }

    public void updateFirstText(User s){
        second_tv.setText("name = "+s.name + " age = " +s.age);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof SecondListener){
            listener = (SecondListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement First Listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface SecondListener{
        void onSecondSend(User s);
    }
}