package group2.tcss450.uw.edu.uilab;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckBoxRadioButtonFragment extends Fragment {


    public CheckBoxRadioButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_check_box_radio_button, container, false);
        RadioButton rb = (RadioButton) v.findViewById(R.id.radioYes);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        rb = (RadioButton) v.findViewById(R.id.radioNo);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonClicked(view);
            }
        });

        Button b = v.findViewById(R.id.buttonSubmit);
        b.setOnClickListener(this::toastPop);

        return v;

    }

    private void toastPop(View view) {
        CheckBox cb = getActivity().findViewById(R.id.checkBoxMeat);
        String list = "";
        Toast.makeText(getActivity(),
                cb.getText(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        GradientDrawable bg = (GradientDrawable)
                getActivity().findViewById(R.id.radioGroup).getBackground();
        bg.setColor(getResources().getColor(R.color.fill));
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        GradientDrawable bg = (GradientDrawable)
                getActivity().findViewById(R.id.radioGroup).getBackground();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioYes:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.yes));
                break;
            case R.id.radioNo:
                if (checked)
                    bg.setColor(getResources().getColor(R.color.no));
                break;
        }
    }

}
